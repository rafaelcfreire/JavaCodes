package leetcode.linkedlist;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/intersection-of-two-linked-lists/
final class IntersectionTwoLinkedLists {
    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode c1 = new ListNode(3);
        ListNode c2 = new ListNode(4);
        ListNode c3 = new ListNode(5);
        ListNode b1 = new ListNode(1);
        ListNode b2 = new ListNode(2);
        ListNode b3 = new ListNode(3);

        a1.next = a2;
        a2.next = c1;
        c1.next = c2;
        c2.next = c3;

        b1.next = b2;
        b2.next = b3;
        b3.next = c1;
//        ListNode a1 = new ListNode(2);
//        ListNode a2 = new ListNode(2);
//        ListNode c1 = new ListNode(4);
//        ListNode c2 = new ListNode(5);
//        ListNode c3 = new ListNode(4);
//
//        ListNode b1 = new ListNode(2);
//        ListNode b2 = new ListNode(2);
//
//        a1.next = a2;
//        a2.next = c1;
//        b1.next = b2;
//        b2.next = c1;
//        c1.next = c2;
//        c2.next = c3;

        ListNode intersection = getIntersectionNode(a1, b1);
        System.out.println(intersection.val);
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> previousNodesA = new HashSet<>();
        Set<ListNode> previousNodesB = new HashSet<>();
        boolean hasNext = headA != null || headB != null;

        while (hasNext) {
            if (headA != null) {
                previousNodesA.add(headA);

                if (previousNodesB.contains(headA)) {
                    return headA;
                }
                headA = headA.next;
            }
            if (headB != null) {
                previousNodesB.add(headB);

                 if (previousNodesA.contains(headB)) {
                     return headB;
                 }
                headB = headB.next;
            }
            hasNext = headA != null || headB != null;
        }
        return null;
    }
}