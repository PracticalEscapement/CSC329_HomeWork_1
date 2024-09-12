package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        PriorityQueueList pql2 = new PriorityQueueList();
        House house1 = new House("Mike", 1);
        House house1Copy = house1.deepCopy(house1);
        System.out.println(house1);
        System.out.println(house1Copy);

        System.out.println(house1.getOwner());
        System.out.println(house1Copy.getOwner());

        House houseB = new House("bill", 1000);
        House house2 = new House("Mahi", 2);
        House house3 = new House("matt", 3);
        House house4 = new House("rozie", 4);


        pql2.addHouse(houseB);
        pql2.addHouse(house1);
        pql2.addHouse(house2);
        pql2.addHouse(house3);
        pql2.addHouse(house4);

        System.out.println(pql2.getMostExpensive().getValue());

        PriorityQueueList pql2Copy = new PriorityQueueList(pql2);
        pql2.show();
        pql2Copy.show();



        PriorityQueueList pql = new PriorityQueueList();

        try {
            File file = new File("input.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String owner  = scanner.nextLine();
                int value = Integer.parseInt(scanner.nextLine());
                House house = new House();
                house.setOwner(owner);
                house.setValue(value);
                pql.addHouse(house);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println(pql.getMostExpensive().getValue());
        pql.show();
        PriorityQueueList pqlCopy = new PriorityQueueList(pql);
        pqlCopy.show();

    }
}