package algoexpert.linkedlist;

public final class ReverseLinkedList {
    public static void main(String[] args) {
        LinkedList zero = new LinkedList(0);
        LinkedList one = new LinkedList(1);
        LinkedList two = new LinkedList(2);
        LinkedList three = new LinkedList(3);
        LinkedList four = new LinkedList(4);
        LinkedList five = new LinkedList(5);

        zero.next = one;
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;

        LinkedList newHead = recursiveReverseLinkedList(zero);
        System.out.println(newHead);
    }

    public static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }

    public static LinkedList reverseLinkedList(LinkedList head) {
        LinkedList p1 = null, p2 = head, p3 = null;

        while(p2 != null) {
            p3 = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = p3;
        }
        return p1;
    }

    public static LinkedList reverseLinkedList2(LinkedList head) {
        LinkedList temp = null, nextNode = null;

        while (head != null) {
            nextNode = head.next;
            head.next = temp;
            temp = head;
            head = nextNode;
        }
        return temp;
    }

    public static LinkedList recursiveReverseLinkedList(LinkedList head) {
        if (head == null)
            return null;
        if (head.next == null)
            return head;
        LinkedList nextElement = head.next;
        head.next = null;
        LinkedList reversed = recursiveReverseLinkedList(nextElement);
        nextElement.next = head;
        return reversed;
    }
}
