package leetcode.linkedlist;

// https://leetcode.com/problems/reverse-nodes-in-k-group/
public class ReverseNodeKGroup {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

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

        reverseOneItem(one);
//        reverseKGroup(one, 3);
    }

    public static ListNode reverseOneItem(ListNode head) {
        ListNode p1 = head, p2 = p1.next;

        p1.next = p2.next;
        p2.next = p1;
        return p2;
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode p1 = null, p2 = head, p3 = null;
        int counter = 1;

        while (counter <= k) {
            p3 = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = p3;
            if (counter == k) {
                ListNode temp = p1;
                while (temp.next != null)
                    temp = temp.next;
                temp.next = p2;
            }
            counter++;
        }
        return p1;
    }
}
