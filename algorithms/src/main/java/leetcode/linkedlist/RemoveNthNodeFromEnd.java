package leetcode.linkedlist;

public final class RemoveNthNodeFromEnd {

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;

        removeNthFromEnd(one, 2);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null && n > 0)
            return null;

        ListNode pointerA = head, pointerB = head;
        for (int i = 0; i < n; i++) {
            if (pointerA != null)
                pointerA = pointerA.next;
        }

        while (pointerA != null && pointerA.next != null) {
            pointerA = pointerA.next;
            pointerB = pointerB.next;
        }
        if (pointerA == null) {
            head.val = pointerB.next.val;
            head.next = pointerB.next.next;
        } else
            pointerB.next = pointerB.next.next;

        return head;
    }
}
