package algoexpert.linkedlist;

public class RemoveKthNode {
    public static void main(String[] args) {
        LinkedList one = new LinkedList(0);
        LinkedList two = new LinkedList(1);
        LinkedList three = new LinkedList(2);
        LinkedList four = new LinkedList(3);
        LinkedList five = new LinkedList(4);
        LinkedList six = new LinkedList(5);
        LinkedList seven = new LinkedList(6);
        LinkedList eight = new LinkedList(7);
        LinkedList nine = new LinkedList(8);
        LinkedList ten = new LinkedList(9);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        six.next = seven;
        seven.next = eight;
        eight.next = nine;
        nine.next = ten;

        removeKthNodeFromEnd(one, 10);
    }

    public static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }

    public static void removeKthNodeFromEnd(LinkedList head, int k) {
        LinkedList aNode = head, bNode = head;

        for(int i = 0; i < k; i++) {
            if(bNode != null)
                bNode = bNode.next;
        }

        while (bNode != null && bNode.next != null) {
            aNode = aNode.next;
            bNode = bNode.next;
        }

        if(bNode == null) {
            head.value = aNode.next.value;
            head.next = aNode.next.next;
        }
        else
            aNode.next = aNode.next.next;
    }
}
