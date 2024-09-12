package org.example;

public class PriorityQueueList implements PriorityQueue{
    public Node root;
    private int length;

    public PriorityQueueList() {
        this.root = null;
        this.length = 0;
    }

    // copy constructor
    public PriorityQueueList(PriorityQueueList pql) {
        this.length = 0;
        this.root = pql.root;
        Node location = this.root;
        Node current = pql.root;
        while (current != null) {
            location.next = current.next;
            location = location.next;
            current = current.next;
            this.length++;
        }
    }

    @Override
    public void addHouse(House a) {
        Node temp = new Node(a);
        temp.next = this.root;
        this.root = temp;
    }

    @Override
    public House getMostExpensive() {
        Node max = this.root;
        Node current = this.root;
        while (current != null) {
            if (current.data.getValue() > max.data.getValue()) {
                max = current;
            }
            current = current.next;
        }
        current = this.root;
        Node prev = this.root;
        while (current != null) {
            if (current == max && current == this.root) {
                this.length--;
                return current.data;
            } else if (current == max) {
                prev.next = current.next;
                this.length--;
                return current.data;
            } else {
                prev = current;
                current = current.next;
            }
        }
        return null;
    }

    @Override
    public void clear() {
        this.root = null;
    }

    @Override
    public int getLength() {
        return this.length;
    }

    @Override
    public boolean isEmpty() {
        return this.root == null;
    }


    public void show() {
        Node current = this.root;
        while (current != null) {
            System.out.print(current.data.getOwner() + "-->");
            current = current.next;
        }
        System.out.println("\n");
    }


    class Node {
        House data;
        Node next;

        public Node() {
            this.data = null;
            this.next = null;
        }

        public Node(House data) {
            this.data = data;
            this.next = null;
        }
    }
}
