package algoexpert.linkedlist;

public final class RemoveDuplicates {
    public static void main(String[] args) {
        LinkedList one = new LinkedList(1);
        LinkedList two = new LinkedList(1);
        LinkedList three = new LinkedList(3);
        LinkedList four = new LinkedList(4);
        LinkedList five = new LinkedList(4);
        LinkedList six = new LinkedList(4);
        LinkedList seven = new LinkedList(5);
        LinkedList eight = new LinkedList(6);
        LinkedList nine = new LinkedList(6);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        six.next = seven;
        seven.next = eight;
        eight.next = nine;

        removeDuplicatesFromLinkedList(one);
    }

    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
        LinkedList currentNode = linkedList;

        while(currentNode != null) {

            while(currentNode.next != null &&
                    currentNode.next.value == currentNode.value) {
                currentNode.next = currentNode.next.next;
            }
            currentNode = currentNode.next;
        }
        return linkedList;
    }
}
