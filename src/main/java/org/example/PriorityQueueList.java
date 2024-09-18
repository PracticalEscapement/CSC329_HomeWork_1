package org.example;

import java.util.Objects;

/**
 * PriorityQueueList class implementing the PriorityQueue Interface
 */
public class PriorityQueueList implements PriorityQueue{
    public Node head;
    private int length;

    //Default Constructor
    public PriorityQueueList() {
        this.head = null;
        this.length = 0;
    }

    /**
     * Returns Deep copy of a pql passed as a parameter
     * @param pql PriorityQueueList
     */
    // copy constructor
    public PriorityQueueList(PriorityQueueList pql) {
        this.length = 0;
        Node current = pql.head;
        Node location = null;

        while (current != null) {
            // Check if the current node is the head
            if (current == pql.head) {
                this.head = new Node(current.data.deepCopy());
                location = this.head;
                current = current.next;
                this.length++;
                continue;
            }
            // create new node for each occurrence of a node in the pql to copy
            Node temp = new Node(current.data.deepCopy());

            location.next = temp;
            current = current.next;
            location = location.next;
            this.length++;

        }
    }

    /**
     * Adds new house to the pql
     * @param house House
     *
     */
    @Override
    public void addHouse(House house) {
        Node temp = new Node(house);
        temp.next = this.head;
        this.head = temp;
        this.length++;
    }

    /**
     * Returns most expensive house and removes it from the list
     * @return House
     */
    @Override
    public House getMostExpensive() {
        Node max = this.head;
        Node current = this.head;

        // First loop finds the object with the highest value
        while (current != null) {
            if (current.data.getValue() > max.data.getValue()) {
                max = current;
            }
            current = current.next;
        }
        current = this.head;
        Node prev = current;
        // Remove the highest value home and fixes pointers in the list
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

    /**
     * compares objects and returns boolean value based on equality
     * @param o takes object
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PriorityQueueList that = (PriorityQueueList) o;
        if (this.length != that.length) {
            return false;
        }

        Node thatCurrent = that.head;
        Node thisCurrent = this.head;
        while (thatCurrent != null) {
            if (!Objects.equals(thisCurrent.data.getOwner(), thatCurrent.data.getOwner()) &&
                    !Objects.equals(thisCurrent.data.getValue(), thatCurrent.data.getValue())) {
                return false;
            }
            thisCurrent = thisCurrent.next;
            thatCurrent = thatCurrent.next;
        }
        return true;
    }

    /**
     * Take the current instance and returns a deep copy
     * @return PriorityQueueList
     */
    public PriorityQueueList deepCopy() {
        Node current = this.head;
        PriorityQueueList pqlCopy = new PriorityQueueList();
        Node copyCurrent = pqlCopy.head;
        while (current != null) {
            House house = current.data.deepCopy();
            Node node = new Node(house);
            if (current == this.head) {
                pqlCopy.head = node;
                copyCurrent = pqlCopy.head;
            }
            copyCurrent.next = current.next;
            copyCurrent = copyCurrent.next;
            current = current.next;
        }
        return pqlCopy;
    }


    // Temp method to do some testing
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

        // For convenience, I added a constructor with parameters
        public Node(House data) {
            this.data = data;
            this.next = null;
        }
    }
}
