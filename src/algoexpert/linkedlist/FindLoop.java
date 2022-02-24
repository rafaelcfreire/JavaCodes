package algoexpert.linkedlist;

public class FindLoop {
    public static void main(String[] args) {
        LinkedList zero = new LinkedList(0);
        LinkedList one = new LinkedList(1);
        LinkedList two = new LinkedList(2);
        LinkedList three = new LinkedList(3);
        LinkedList four = new LinkedList(4);
        LinkedList five = new LinkedList(5);
        LinkedList six = new LinkedList(6);
        LinkedList seven = new LinkedList(7);
        LinkedList eight = new LinkedList(8);
        LinkedList nine = new LinkedList(9);

        zero.next = one;
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        six.next = seven;
        seven.next = eight;
        eight.next = nine;
        nine.next = two;

        findLoop(zero);
    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }

    public static LinkedList findLoop(LinkedList head) {
        LinkedList slow = head.next, fast = head.next.next;

        while(slow != fast) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = head;
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
