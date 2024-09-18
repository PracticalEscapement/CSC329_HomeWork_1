package org.example;

import org.example.House;

/**
 * PriorityQueue interface
 */
public interface PriorityQueue {
    void addHouse(House a);
    House getMostExpensive();
    void clear();
    int getLength();
    boolean isEmpty();


}
