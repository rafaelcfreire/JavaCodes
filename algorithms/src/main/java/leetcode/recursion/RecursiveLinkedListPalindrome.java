package leetcode.recursion;

// https://leetcode.com/problems/palindrome-linked-list/
public final class RecursiveLinkedListPalindrome {
    public static class ListNode {
        int value;
        ListNode next;
        ListNode(int val) { this.value = val; }
    }

    public static void main(String[] args) {
//        ListNode zero = new ListNode(0);
//        ListNode one = new ListNode(1);
//        ListNode two = new ListNode(2);
//        ListNode twoTwo = new ListNode(2);
//        ListNode oneOne = new ListNode(5);
//        ListNode zeroZero = new ListNode(0);
//
//        zero.next = one;
//        one.next = two;
//        two.next = twoTwo;
//        twoTwo.next = oneOne;
//        oneOne.next = zeroZero;
        ListNode one = new ListNode(1);
        ListNode zero = new ListNode(0);
        ListNode zeroZero = new ListNode(0);

        one.next = zero;
        zero.next = zeroZero;
        System.out.print(isPalindrome(one));
    }

    public static boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head, currentNode = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode headOfReversedHalf = reverseList(slow, null);

        return checkMatch(currentNode, headOfReversedHalf);
    }

    private static boolean checkMatch(ListNode nodeA, ListNode nodeB) {
        if (nodeB == null)
            return true;
        if (nodeA.value == nodeB.value)
            return checkMatch(nodeA.next, nodeB.next);
        else
            return false;
    }

    private static ListNode reverseList(ListNode head, ListNode prev) {
        if (head == null)
            return null;
        ListNode next = head.next;
        head.next = prev;
        return next == null ? head : reverseList(next, head);
    }
}
