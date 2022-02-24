package leetcode.recursion;

public class SwapNodes {
    public static void main(String[] args) {
        ListNode zero = new ListNode(0);
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);

        zero.next = one;
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;

        ListNode head = swapPairs(zero);
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int value){
            this.val = value;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode second = head.next;
        head.next = swapPairs(second.next);
        second.next = head;

        return second;
    }

    public static ListNode swapPairsRecursive(ListNode head) {
        ListNode tempNode = new ListNode(0);
        tempNode.next = head;

        ListNode prevNode = tempNode;
        while (prevNode.next != null && prevNode.next.next != null) {
            ListNode firstNode = prevNode.next, secondNode = prevNode.next.next;

            firstNode.next = secondNode.next;
            secondNode.next = firstNode;
            prevNode.next = secondNode;
            prevNode = firstNode;
        }
        return tempNode.next;
    }
}
//        if (head == null || head.next == null)
//                return head;
//
//                ListNode second = head.next;
//                head.next = swapPairs(second.next);
//                second.next = head;
//                return second;
