package com.test;

import java.util.Comparator;

public class Checker implements Comparator<Player> {

    public int compare(Player a, Player b) {

// In short, when sorting in ascending order, a comparator function returns -1 if a<b, 0 if a=b, and 1 if a>b.
        return a.score > b.score ? -1 : b.score > a.score ? 1 : a.name.compareTo(b.name);
    }
}
