package org.example;

public class PriorityQueueList implements PriorityQueue{
    public Node head;
    private int length;

    public PriorityQueueList() {
        this.head = null;
        this.length = 0;
    }

    // copy constructor
    public PriorityQueueList(PriorityQueueList pql) {
        this.length = 0;
        Node current = pql.head;
        Node location = null;

        while (current != null) {
            // Check if the current node is the head
            if (current == pql.head) {
                this.head = new Node(current.data.deepCopy(current.data));
                location = this.head;
                current = current.next;
                this.length++;
                continue;
            }
            // create new node for each occurrence of a node in the pql to copy
            Node temp = new Node(current.data.deepCopy(current.data));

            location.next = temp;
            current = current.next;
            location = location.next;
            this.length++;

        }
    }

    @Override
    public void addHouse(House a) {
        Node temp = new Node(a);
        temp.next = this.head;
        this.head = temp;
        this.length++;
    }

    @Override
    public House getMostExpensive() {
        Node max = this.head;
        Node current = this.head;

        while (current != null) {
            if (current.data.getValue() > max.data.getValue()) {
                max = current;
            }
            current = current.next;
        }
        current = this.head;
        Node prev = current;
        while (current != null) {
            if (max == this.head) {
                this.head = current.next;
                length--;
            }
            if (current == max) {
                prev.next = current.next;
                length--;
                return current.data;
            }
            prev = current;
            current = current.next;
        }

        return max.data;
    }

    @Override
    public void clear() {
        this.head = null;
    }

    @Override
    public int getLength() {
        return this.length;
    }

    @Override
    public boolean isEmpty() {
        return this.head == null;
    }


    public void show() {
        Node current = this.head;
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
