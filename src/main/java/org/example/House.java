package org.example;

import java.util.Objects;

public class House {
    private String owner;
    private int value;

    // Default constructor
    public House() {
        this.owner = "default";
        this.value = 0;
    }

    public House(String owner, int value) {
        this.owner = owner;
        this.value = value;
    }

    // copy constructor
    public House(House house) {
        this.owner = house.getOwner();
        this.value = house.getValue();
    }

    // House Deep Copy
    public House deepCopy() {
        return new House(this.getOwner(), this.getValue());
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return value == house.value && Objects.equals(owner, house.owner);
    }

}