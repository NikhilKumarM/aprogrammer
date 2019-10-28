package com.nikhil.aprogrammer.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * Implementing the deep copy of Linked List where Node has a value, next node and random node the current node
 * is linked to.
 */
public class CopyRandomList {

    /**
     * Definition for singly-linked list.
     */
    public class Node {
        int val;
        Node next;
        Node random;

        Node(int x) {
            val = x;
        }
    }

    /**
     * This method is used to create the deep copy of the given list.
     *
     * @param head Head of the Linked List.
     * @return Head Node of the deep copied list.
     */
    public Node random(Node head) {
        Node resultHead = new Node(-1);
        Node prev = resultHead;
        Node temp = head;

        Map<Node, Node> nodeCopyMap = new HashMap<>();
        Map<Node, Node> randomPointerNodeMap = new HashMap<>();

        while (temp != null) {
            Node node = new Node(temp.val);
            nodeCopyMap.put(temp, node);
            randomPointerNodeMap.put(temp, temp.random);
            prev.next = node;
            prev = prev.next;
            temp = temp.next;
        }

        for (Map.Entry<Node, Node> entry : randomPointerNodeMap.entrySet()) {
            Node tempNode = entry.getKey();
            Node randomNode = entry.getValue();
            nodeCopyMap.get(tempNode).random = nodeCopyMap.get(randomNode);
        }

        return resultHead.next;
    }


}
