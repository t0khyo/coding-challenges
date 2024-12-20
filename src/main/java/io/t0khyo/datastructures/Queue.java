package io.t0khyo.datastructures;

// FIFO
public class Queue {
    private Node head; // remove from head
    private Node tail; // add from here

    public boolean isEmpty() {
        return head == null;
    }

    public int peek() {
        return head.data;
    }

    public void add(int data) {
        Node newNode = new Node(data);
        if (tail != null) {
            tail.next = newNode;
        }
        tail = newNode;
        if (head == null)
            head = newNode;
    }

    public int remove() {
        int data = head.data;
        head = head.next;
        if (head == null)
            tail = null;
        return data;
    }

    private static class Node {
        private final int data;
        private Node next;

        private Node(int data) {
            this.data = data;
        }
    }
}

