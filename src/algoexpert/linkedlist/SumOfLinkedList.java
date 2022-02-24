package algoexpert.linkedlist;

public class SumOfLinkedList {
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static void main(String[] args) {
//        LinkedList one = new LinkedList(2);
//        LinkedList two = new LinkedList(4);
//        LinkedList three = new LinkedList(7);
//        LinkedList four = new LinkedList(1);
//
//        LinkedList five = new LinkedList(9);
//        LinkedList six = new LinkedList(4);
//        LinkedList seven = new LinkedList(5);
//
//        one.next = two;
//        two.next = three;
//        three.next = four;
//
//        five.next = six;
//        six.next = seven;

        LinkedList one = new LinkedList(2);
        LinkedList two = new LinkedList(4);
        LinkedList three = new LinkedList(3);

        LinkedList five = new LinkedList(5);
        LinkedList six = new LinkedList(6);
        LinkedList seven = new LinkedList(4);

        one.next = two;
        two.next = three;

        five.next = six;
        six.next = seven;

        LinkedList result = sumOfLinkedList(one, five);
    }

    public static LinkedList sumOfLinkedList(LinkedList linkedListOne, LinkedList linkedListTwo) {
        LinkedList result = null, headOfResult = null;
        int carry = 0;

        while (linkedListOne != null || linkedListTwo != null || carry != 0) {
            int sum = 0;

            if (linkedListOne != null) {
                sum += linkedListOne.value;
                linkedListOne = linkedListOne.next;
            }
            if (linkedListTwo != null) {
                sum += linkedListTwo.value;
                linkedListTwo = linkedListTwo.next;
            }
            int sumOfValuesAndCarrier = sum + carry >= 10 ? sum + carry - 10 : sum + carry;
            if (result == null) {
                result = new LinkedList(sumOfValuesAndCarrier);
                headOfResult = result;
            }
            else {
                result.next = new LinkedList(sumOfValuesAndCarrier);
                result = result.next;
            }
            carry = sum > 9? 1 : 0;
        }
        return headOfResult;
    }
}
