package leetcode.linkedlist;

// https://leetcode.com/problems/merge-k-sorted-lists/description/
final class MergeKSortedLists {
    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(3);
        ListNode a3 = new ListNode(5);
        a1.next = a2;
        a2.next = a3;

        ListNode b1 = new ListNode(2);
        ListNode b2 = new ListNode(4);
        ListNode b3 = new ListNode(6);
        b1.next = b2;
        b2.next = b3;

        ListNode c1 = new ListNode(2);
        ListNode c2 = new ListNode(6);
        c1.next = c2;
//        ListNode a1 = new ListNode(8);
//        ListNode a2 = new ListNode(7);
//        ListNode a3 = new ListNode(6);
//        a3.next = a2;
//        a2.next = a1;
//
//        ListNode b1 = new ListNode(5);
//        ListNode b2 = new ListNode(4);
//        ListNode b3 = new ListNode(3);
//        b3.next = b2;
//        b2.next = b1;
//
//        ListNode c1 = new ListNode(2);
//        ListNode c2 = new ListNode(1);
//        c2.next = c1;

//        ListNode newHead = mergeKLists(new ListNode[]{a1, b1, c1});

        ListNode result = mergeTwoLists(a1, b1);
//        System.out.println(newHead);
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null)
            return null;
        if (lists.length == 1)
            return lists[0];

        ListNode[] splittedList = new ListNode[(lists.length + 1) / 2];

        for (int i = 0; i < lists.length; i += 2) {
            int reducedIndex = i / 2;
            splittedList[reducedIndex] = (i + 1 < lists.length) ? mergeTwoLists(lists[i], lists[i + 1]) : lists[i];
        }
        return mergeKLists(splittedList);
    }

    private static ListNode mergeTwoLists(ListNode listOne, ListNode listTwo) {
        ListNode i = listOne, j = listTwo;
        ListNode aux = null, currNode = null;

        while (i != null && j != null) {
            if (i.val < j.val) {
                if (aux == null) {
                    aux = new ListNode(i.val);
                    currNode = aux;
                } else {
                    currNode.next = new ListNode(i.val);
                    currNode = currNode.next;
                }
                i = i.next;
            } else {
                if (aux == null) {
                    aux = new ListNode(j.val);
                    currNode = aux;
                } else {
                    currNode.next = new ListNode(j.val);
                    currNode = currNode.next;
                }
                j = j.next;
            }
        }
        while (i != null) {
            if (aux == null) {
                aux = new ListNode(i.val);
                currNode = aux;
            } else {
                currNode.next = new ListNode(i.val);
                currNode = currNode.next;
            }
            i = i.next;
        }
        while (j != null) {
            if (aux == null) {
                aux = new ListNode(j.val);
                currNode = aux;
            } else {
                currNode.next = new ListNode(j.val);
                currNode = currNode.next;
            }
            j = j.next;
        }
        return aux;
    }


    public static ListNode mergeKLists2(ListNode[] lists) {
        ListNode mergedList = null, currNode = null;
        ListNode[] currentNodePerList = lists;

        while (!isAllListsFinished(lists)) {
            int min = Integer.MAX_VALUE;
            int minCurr = 0;

            for (int i = 0; i < lists.length; i++) {
                ListNode temp = currentNodePerList[i];

                if (temp != null && temp.val < min) {
                    minCurr = i;
                    min = temp.val;
                }
            }
            currentNodePerList[minCurr] = currentNodePerList[minCurr].next;
            if (mergedList == null) {
                mergedList = new ListNode(min);
                currNode = mergedList;
            } else {
                currNode.next = new ListNode(min);
                currNode = currNode.next;
            }
        }
        return mergedList;
    }

    private static boolean isAllListsFinished(ListNode[] lists) {
        for (ListNode curr : lists) {
            if (curr != null)
                return false;
        }
        return true;
    }
}