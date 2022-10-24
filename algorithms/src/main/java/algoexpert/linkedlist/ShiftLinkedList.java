package algoexpert.linkedlist;

public final class ShiftLinkedList {
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
        LinkedList newHead = shiftLinkedList(zero, 1);
    }

    static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            next = null;
        }
    }

    public static LinkedList shiftLinkedList(LinkedList head, int k) {
        LinkedList currentNode = head;
        int listLength = 1;

        while (currentNode.next != null) {
            currentNode = currentNode.next;
            listLength++;
        }

        int offset = Math.abs(k) % listLength;
        if(offset == 0) return head;

        int newTailPosition = (k > 0) ? listLength - offset : offset;
        LinkedList newTail = head;
        for(int i = 1; i < newTailPosition; i++) {
            newTail = newTail.next;
        }
        LinkedList newHead = newTail.next;
        newTail.next = null;
        currentNode.next = head;
        return newHead;
    }
}
