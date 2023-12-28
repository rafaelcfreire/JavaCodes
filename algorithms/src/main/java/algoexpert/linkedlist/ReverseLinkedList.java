package algoexpert.linkedlist;

public final class ReverseLinkedList {
    public static void main(String[] args) {
        LinkedNode zero = new LinkedNode(0);
        LinkedNode one = new LinkedNode(1);
        LinkedNode two = new LinkedNode(2);
        LinkedNode three = new LinkedNode(3);
        LinkedNode four = new LinkedNode(4);
        LinkedNode five = new LinkedNode(5);

        zero.next = one;
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;

        LinkedNode newHead = reverseLinkedList2(zero);
        System.out.println(newHead);
    }

    public static class LinkedNode {
        int value;
        LinkedNode next = null;

        public LinkedNode(int value) {
            this.value = value;
        }
    }

    public static LinkedNode reverseLinkedList(LinkedNode head) {
        LinkedNode p1 = null, p2 = head, p3 = null;

        while(p2 != null) {
            p3 = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = p3;
        }
        return p1;
    }

    public static LinkedNode reverseLinkedList2(LinkedNode head) {
        LinkedNode temp = null, nextNode = null;

        while (head != null) {
            nextNode = head.next;
            head.next = temp;
            temp = head;
            head = nextNode;
        }
        return temp;
    }

    public static LinkedNode recursiveReverseLinkedList(LinkedNode head) {
        if (head == null)
            return null;
        if (head.next == null)
            return head;
        LinkedNode nextElement = head.next;
        head.next = null;
        LinkedNode reversed = recursiveReverseLinkedList(nextElement);
        nextElement.next = head;
        return reversed;
    }
}
