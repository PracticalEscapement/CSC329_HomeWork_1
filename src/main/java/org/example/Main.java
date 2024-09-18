package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Main Class where code is executed in main method
 */
public class Main {
    public static void main(String[] args) {

        PriorityQueueList pql2 = new PriorityQueueList();
        House house1 = new House("Mike", 1);
        House house1Copy = house1.deepCopy();
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

        PriorityQueueList pql3 = new PriorityQueueList();
        pql3.addHouse(houseB);
        pql3.addHouse(house1);
        pql3.addHouse(house2);
        pql3.addHouse(house3);
        pql3.addHouse(house4);

        pql2.show();

        System.out.println(pql2.getMostExpensive().getValue());

        pql2.show();

        System.out.println(pql2.getMostExpensive().getValue());

        pql2.show();

        PriorityQueueList pql2Copy = new PriorityQueueList(pql2);
        pql2.show();
        pql2Copy.show();

        System.out.println(pql2.equals(pql2Copy));
        System.out.println(pql2.getLength());

        System.out.println(pql3.getLength());
        pql2.show();
        pql3.show();
        PriorityQueueList pql3Copy = pql3.deepCopy();
        pql3Copy.getMostExpensive();
        pql3Copy.getMostExpensive();
        pql3Copy.getMostExpensive();
        pql3Copy.show();



        PriorityQueueList pql = new PriorityQueueList();

        // Reading input.txt file
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


        PriorityQueueList pqlCopy = new PriorityQueueList(pql);
        System.out.println("\n\n\n\n");
        System.out.println(pql.getMostExpensive().getValue());
        System.out.println(pqlCopy.getMostExpensive().getValue());
        System.out.println(pql.getMostExpensive().getValue());

        System.out.println(pql);
        System.out.println(pqlCopy);

        System.out.println(pql.getLength());
        System.out.println(pqlCopy.getMostExpensive().getValue());
        System.out.println(pqlCopy.getLength());

        System.out.println(pql.equals(pql2Copy));
        PriorityQueueList pqlDeepCopy = pql.deepCopy();
        System.out.println(pql.equals(pqlDeepCopy));


    }
}