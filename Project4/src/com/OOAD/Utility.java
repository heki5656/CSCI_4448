package com.OOAD;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.*;

public interface Utility {

    Store store = new com.OOAD.Store();

    // making this utility function that can be used by saying com.OOAD.Utility.rndFromRange(min,max)
    // https://www.baeldung.com/java-generating-random-numbers-in-range
    static int rndFromRange(int min, int max) {
        //returns a uniform inclusive random number from a given min and max range
        return (int) ((Math.random() * ((max+1) - min)) + min);
    }

    // another utility for printing out pretty $ values
    // https://stackoverflow.com/questions/13791409/java-format-double-value-as-dollar-amount
    static String asDollar(double value) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        return formatter.format(value);
    }
    
    static String selectDemonstratorName(){
        String[] demonstrators = new String[]{"Jay", "Jim", "Joe", "John", "Jill", "Joy", "Jessica", "Jeff", "Tina", "Sal", "Ben", "Bill", "Nick", "Jan", "Mia", "Maddy", "Tracy", "Macy"};
        Random r = new Random();
        int randomString=r.nextInt(demonstrators.length);
        return (demonstrators[randomString]);
    }

    static String selectName() {
        String[] customers = new String[]{"Max", "Bruce", "Tom", "Tim", "Tam", "Sam", "Pam", "Laura", "Drake", "Rose", "Lily", "Tommy", "Bobby", "Robert", "Herbert", "Sherbert", "Kermit", "Kirby"};
        Random r = new Random();
        int randomString=r.nextInt(customers.length);
        return (customers[randomString]);

        //return store.customers[(day-1) % store.customers.length];
    }

}

