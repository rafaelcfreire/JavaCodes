package leetcode.recursion;

// https://leetcode.com/problems/remove-linked-list-elements/
public final class RemoveNodeLinkedList {
    public static class ListNode {
        int value;
        ListNode next;
        ListNode(int val) { this.value = val; }
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(6);
        ListNode two = new ListNode(2);
        ListNode temp = new ListNode(6);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        ListNode six = new ListNode(6);

        one.next = two;
        two.next = temp;
        temp.next = three;
        three.next = four;
        four.next = five;
        five.next = six;

        System.out.print(removeElements(one, 6).value);
    }

    public static ListNode removeElements(ListNode head, int value) {
        if (head == null)
            return null;
        ListNode next = removeElements(head.next, value);
        if (head.value == value)
            head = next;
        else
            head.next = next;
        return head;
    }
}
