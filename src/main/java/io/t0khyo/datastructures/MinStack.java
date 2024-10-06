package io.t0khyo.datastructures;

public class MinStack {
    private Node top;

    public MinStack() {

    }

    public void push(int val) {
        if (top == null) {
            top = new Node(val, val);
        }

        Node newNode = new Node(val, Math.min(top.min, val));
        newNode.next = top;
        top = newNode;
    }

    public void pop() {
        top = top.next;
    }

    public int top() {
        return top.data;
    }

    public int getMin() {
        return top.min;
    }

    private static class Node {
        private final int data;
        private final int min;
        private Node next;

        public Node(int data, int min) {
            this.data = data;
            this.min = min;
        }
    }
}
