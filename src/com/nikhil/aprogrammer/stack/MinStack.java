package com.nikhil.aprogrammer.stack;

/**
 * Implementing a program to construct a stack data structure with extra feature of retrieving the minimum in the stack
 * in O(1) time.
 */
class MinStack {

    private Node head;

    /**
     * Pushing an element into the stack. Basically if the head Node is null, we are creating a new node and if not
     * we are creating a new node and making the current head as its next node and referring it as new head;
     *
     * @param x Value to be pushed to stack
     */
    public void push(int x) {
        if (head == null) {
            head = new Node(x, x, null);
        } else {
            head = new Node(x, Math.min(x, head.min), head);
        }
    }

    /**
     * Popping the value from the stack.
     */
    public void pop() throws IllegalAccessException {
        if (head == null) {
            throw new IllegalAccessException("Stack is Empty");
        }
        head = head.next;
    }

    /**
     * Retrieving the top value of the stack.
     *
     * @return Returns the element at the top of the stack.
     */
    public int top() throws IllegalAccessException {
        if (head == null) {
            throw new IllegalAccessException("Stack is Empty");
        }
        return head.val;
    }

    /**
     * Retreiving the minimum element of the stack. Here head node always has the minimum node value inserted until now.
     *
     * @return Returns minimum element value in the stack.
     */
    public int getMin() throws IllegalAccessException {
        if (head == null) {
            throw new IllegalAccessException("Stack is Empty");
        }
        return head.min;
    }

    /**
     * Node class for storing the each element of stack. This node has the properties to store current Node value,
     * minimum until the current node and the next node of the current node.
     */
    private class Node {
        int val, min;
        Node next;

        Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}