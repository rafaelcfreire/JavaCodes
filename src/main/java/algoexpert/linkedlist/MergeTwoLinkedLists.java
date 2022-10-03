package algoexpert.linkedlist;

public final class MergeTwoLinkedLists {
    public static class LinkedList {
        int value;
        LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

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
        LinkedList ten = new LinkedList(10);

//        one.next = two;
//        two.next = three;
//        three.next = four;
//        four.next = five;
//
//        six.next = seven;
//        seven.next = eight;
//        eight.next = nine;
//        nine.next = ten;
//
//        mergeLinkedLists2(one, six);

//        two.next = six;
//        six.next = seven;
//        seven.next = eight;
//
//        one.next = three;
//        three.next = four;
//        four.next = five;
//        five.next = nine;
//        nine.next = ten;
//
//        mergeLinkedLists2(two, one);

        six.next = seven;
        seven.next = eight;
        eight.next = nine;
        nine.next = ten;

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;

        mergeLinkedLists2(six, one);

//        one.next = three;
//        three.next = five;
//        five.next = seven;
//        seven.next = nine;
//
//        two.next = four;
//        four.next = six;
//        six.next = eight;
//        eight.next = ten;
//
//        mergeLinkedLists(one, two);

//        zero.next = one;
//        one.next = two;
//        two.next = three;
//        three.next = four;
//        four.next = five;
//        five.next = seven;
//        seven.next = eight;
//        eight.next = nine;
//        nine.next = ten;
//
//        mergeLinkedLists(six, zero);
    }

    public static LinkedList mergeLinkedLists(LinkedList headOne, LinkedList headTwo) {
        LinkedList p1 = headOne, p2 = headTwo, prev = null;

        while (p1 != null && p2 != null) {
            if(p1.value < p2.value) {
                prev = p1;
                p1 = p1.next;
            } else {
                if(prev != null)
                    prev.next = p2;
                prev = p2;
                p2 = p2.next;
                prev.next = p1;
            }
        }
        if(p1 == null) prev.next = p2;
        return headOne.value < headTwo.value ? headOne : headTwo;
    }

    public static LinkedList mergeLinkedLists2(LinkedList headOne, LinkedList headTwo) {
        mergeListsRecursively(headOne, headTwo, null);
        return headOne.value < headTwo.value ? headOne : headTwo;
    }

    private static void mergeListsRecursively(LinkedList p1, LinkedList p2, LinkedList prev) {
        if (p1 == null) {
            prev.next = p2;
            return;
        } else if (p2 == null) {
            return;
        }

        if (p1.value < p2.value) {
            mergeListsRecursively(p1.next, p2, p1);
        } else {
            if (prev != null)
                prev.next = p2;
            LinkedList newP2 = p2.next;
            p2.next = p1;
            mergeListsRecursively(p1, newP2, p2);
        }
    }
}

//    mergeListsRecursively(headOne, headTwo, null);
//        return headOne.value < headTwo.value ? headOne : headTwo;


//    private static void mergeListsRecursively(LinkedList p1, LinkedList p2, LinkedList prev) {
//        if (p1 == null) {
//            prev.next = p2;
//            return;
//        }
//        if (p2 == null) {
//            return;
//        }
//
//        if(p1.value < p2.value) {
//            mergeListsRecursively(p1.next, p2, p1);
//        } else {
//            if (prev != null)
//                prev.next = p2;
//            LinkedList newP2 = p2.next;
//            p2.next = p1;
//            mergeListsRecursively(p1, newP2, p2);
//        }
//    }
