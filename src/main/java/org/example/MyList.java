package org.example;

public class MyList {
    private Node head;
    private int length;

    public MyList() {
        this.head = null;
        this.length = 0;
    }

    public MyList(MyList other) {
        this.head = null;
        this.length = 0;
        Node current = other.head;
        while (current != null) {
            House houseCopy = current.data.deepCopy();
            addHouse(houseCopy);
            current = current.next;
        }
    }

    public MyList deepCopy() {
        MyList listCopy = new MyList();
        Node current = this.head;
        while (current != null) {
            listCopy.addHouse(current.data.deepCopy());
            current = current.next;
        }
        return listCopy;
    }

    public void addHouse(House house) {
        Node temp = new Node(house);
        temp.next = this.head;
        this.head = temp;
        this.length++;
    }

    public House find(String owner) {
        Node current = this.head;
        while (current != null) {
            if (current.data.getOwner().equals(owner)) {
                return current.data;
            }
            current = current.next;
        }
        return null;
    }

    class Node {
        House data;
        Node next;

        public Node() {
            this.data = null;
            this.next = null;
        }

        public Node(House house) {
            this.data = house;
            this.next = null;
        }
    }


}
