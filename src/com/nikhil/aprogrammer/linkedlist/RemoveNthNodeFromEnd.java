package com.nikhil.aprogrammer.linkedlist;

public class RemoveNthNodeFromEnd {

    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd_1(ListNode head, int n) {

        /* Returning Null if head Node is Null */
        if (head == null) {
            return head;
        }

        /* Finding the length of the list */
        int listLength = findListLength(head);

        /* Calculating the node to be removed from start of the list */
        int posFromStart = listLength - n;

        if (posFromStart == 0) {
            return head.next;
        }

        ListNode prevNode = null, tempNode = head;
        int counter = 0;

        while (counter != posFromStart) {
            counter++;
            prevNode = tempNode;
            tempNode = tempNode.next;
        }

        prevNode.next = tempNode.next;
        tempNode.next = null;
        return head;
    }

    private int findListLength(ListNode head) {
        int length = 0;

        while (head != null) {
            length++;
            head = head.next;
        }

        return length;
    }

    public ListNode removeNthFromEnd_2(ListNode head, int n) {

        if (head == null) {
            return head;
        }

        ListNode fastPointer = head, slowPointer = head, prevNode = null;

        for (int i = 0; i < n; i++) {
            fastPointer = fastPointer.next;
        }

        while (fastPointer != null) {
            fastPointer = fastPointer.next;
            prevNode = slowPointer;
            slowPointer = slowPointer.next;
        }

        if (prevNode == null) {
            return head.next;
        }

        prevNode.next = slowPointer.next;
        slowPointer.next = null;

        return head;
    }
}
