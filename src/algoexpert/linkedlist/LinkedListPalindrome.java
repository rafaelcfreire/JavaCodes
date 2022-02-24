package algoexpert.linkedlist;

public class LinkedListPalindrome {
    public static void main(String[] args) {
        LinkedList zero = new LinkedList(0);
        LinkedList one = new LinkedList(1);
        LinkedList two = new LinkedList(2);
        LinkedList twoTwo = new LinkedList(2);
        LinkedList oneOne = new LinkedList(1);
        LinkedList zeroZero = new LinkedList(0);

        zero.next = one;
        one.next = two;
        two.next = twoTwo;
        twoTwo.next = oneOne;
        oneOne.next = zeroZero;

        linkedListPalindrome(zero);
    }

    static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static boolean linkedListPalindrome(LinkedList head) {
        LinkedList slow = head, fast = head, currentNode = head;

        while(fast != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        LinkedList headOfReversedHalf = revertList(slow);

        while (headOfReversedHalf != null) {
            if (currentNode.value != headOfReversedHalf.value)
                return false;
            currentNode = currentNode.next;
            headOfReversedHalf = headOfReversedHalf.next;
        }
        return true;
    }

    public static LinkedList revertList(LinkedList head) {
        LinkedList previousNode = null, nextNode = head;

        while (head != null) {
            nextNode = head.next;
            head.next = previousNode;
            previousNode = head;
            head = nextNode;
        }
        return previousNode;
    }


}
