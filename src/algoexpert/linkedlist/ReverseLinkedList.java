package algoexpert.linkedlist;

public class ReverseLinkedList {
    public static void main(String[] args) {
        LinkedList one = new LinkedList(0);
        LinkedList two = new LinkedList(1);
        LinkedList three = new LinkedList(2);
        LinkedList four = new LinkedList(3);
        LinkedList five = new LinkedList(4);
        LinkedList six = new LinkedList(5);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;

        reverseLinkedList2(one);
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

        while (head != null){
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
        LinkedList secondElement = head.next;
        return null;
    }
}
