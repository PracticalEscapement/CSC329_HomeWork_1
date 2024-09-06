package org.example;

public class Main {
    public static void main(String[] args) {
        House house1 = new House("Mike", 1);
        House house1Copy = house1.deepCopy(house1);
        System.out.println(house1);
        System.out.println(house1Copy);

        System.out.println(house1.getOwner());
        System.out.println(house1Copy.getOwner());
    }
}