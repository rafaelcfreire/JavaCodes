package leetcode.linkedlist;

public final class LinkedListCycle {
    public static void main(String[] args) {
        ListNode three = new ListNode(3);
        ListNode two = new ListNode(2);
        ListNode zero = new ListNode(0);
        ListNode mFour = new ListNode(-4);
        three.next = two;
        two.next = zero;
        zero.next = mFour;
//        mFour.next = two;

        hasCycle(three);
    }

    public static boolean hasCycle(ListNode head) {
        ListNode pointerA = head, pointerB = head;

        while (pointerA != null && pointerB != null && pointerB.next != null) {
            pointerA = pointerA.next;
            pointerB = pointerB.next.next;
            if (pointerA == pointerB)
                return true;
        }
        return false;
    }
}
