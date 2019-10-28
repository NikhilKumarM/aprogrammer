package com.nikhil.aprogrammer.linkedlist;

/**
 * Implementing the program to merge two sorted linked lists.
 */
public class MergeTwoSortedLists {

    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * THis method is used to merge given two sorted Linked lists.
     *
     * @param l1 Sorted Linked List 1.
     * @param l2 Sorted Linked List 2.
     * @return Head of the merged Linked list of given two lists.
     */
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {

        if (l1 == null && l2 == null) {
            return l1;
        }

        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode resultHead = null, node = null;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                if (resultHead == null) {
                    resultHead = l1;
                    node = resultHead;
                } else {
                    node.next = l1;
                    node = node.next;
                }
                l1 = l1.next;
            } else {
                if (resultHead == null) {
                    resultHead = l2;
                    node = resultHead;
                } else {
                    node.next = l2;
                    node = node.next;
                }
                l2 = l2.next;
            }
        }

        if (l1 != null) {
            node.next = l1;
        }


        if (l2 != null) {
            node.next = l2;
        }

        return resultHead;
    }

    /**
     * THis method is used to merge given two sorted Linked lists.
     *
     * @param l1 Sorted Linked List 1.
     * @param l2 Sorted Linked List 2.
     * @return Head of the merged Linked list of given two lists.
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {

        ListNode resultHead = new ListNode(-1), node = resultHead;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                node.next = l1;
                l1 = l1.next;
            } else {
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }

        node.next = (l1 != null) ? l1 : l2;

        return resultHead.next;
    }

}
