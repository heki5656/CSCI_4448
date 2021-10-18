package com.OOAD;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

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

    static String selectName(int day) {
        return store.customers[(day-1) % store.customers.length];


//        int len = store.customers.length;
//
//        String[] b = new String[(2 * len)];
//
//        for (int i = 0; i < len; i++) {
//            b[i] = b[len + i] = store.customers[i];
//        }
//
//        for (int i = 0; i < b.length; i++) {
//            String searchedValue = b[i];
//            ArrayList<String> stringList = new ArrayList<String>(Arrays.asList(store.previousCustomers));
//
//            if (!stringList.contains(searchedValue)) {
//                store.previousCustomers[i] = searchedValue;
//                return store.previousCustomers[i];
//            }
//            else{
//                store.previousCustomers = new String[]{"", "", "", "", "", "", "", "", "", ""};
//                store.previousCustomers[i] = searchedValue;
//                return store.previousCustomers[i];
//            }
//        }
//        return "";
    }

}

