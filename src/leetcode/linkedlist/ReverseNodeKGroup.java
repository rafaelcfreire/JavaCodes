package leetcode.linkedlist;

// https://leetcode.com/problems/reverse-nodes-in-k-group/
public class ReverseNodeKGroup {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
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

//        reverseOneItem(one);
        reverseKGroup(one, 2);
    }

    public static ListNode reverseOneItem(ListNode head) {
        ListNode p1 = head, p2 = p1.next;

        p1.next = p2.next;
        p2.next = p1;
        return p2;
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;

        while (curr != null && count < k) {
            count++;
            curr = curr.next;
        }
        if (count == k) {
            curr = reverseKGroup(curr, k);

            while (count-- > 0) {
                ListNode temp = head.next;
                head.next = curr;
                curr = head;
                head = temp;
            }
            head = curr;
        }
        return head;
    }
}
