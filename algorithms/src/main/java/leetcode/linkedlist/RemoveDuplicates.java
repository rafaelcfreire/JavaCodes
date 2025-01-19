package leetcode.linkedlist;

//https://leetcode.com/problems/remove-duplicates-from-sorted-list/
final class RemoveDuplicates {
    public static void main(String[] args) {
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(1);
        ListNode third = new ListNode(2);
//        ListNode fourth = new ListNode(3);
//        ListNode fifth = new ListNode(3);
//
        first.next = second;
        second.next = third;
//        third.next = fourth;
//        fourth.next = fifth;

        deleteDuplicates(first);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode pointerA = head, pointerB = head.next;

        while (pointerB != null) {
            if (pointerA.val == pointerB.val) {
                pointerB = pointerB.next;
                pointerA.next = pointerB;
            } else {
                pointerB = pointerB.next;
                pointerA = pointerA.next;
            }
        }
        return head;
    }
}