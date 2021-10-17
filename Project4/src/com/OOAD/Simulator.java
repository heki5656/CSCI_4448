package com.OOAD;
import java.util.*;

public class Simulator {
    public void run(int days) {
        //initialize and instantiate the store for the simulation
        Store store = new Store();

        //create a boolean to see if the store was robbed
        boolean robbed = false;

        //run for n days
        for (int day = 1; day <= days; day++) {
            System.out.println("--- Simulation starting Day "+day);

            //check if it's day 2, to see if store got robbed after closing on day
            if (day == 2){

                //chance of being robbed
                double robbedChance = Utility.rndFromRange(1,100);
                if (robbedChance <= 30){
                    robbed = true;
                    store.robbed();
                }

                //check if store was robbed and if so close store for day
                if (robbed == true){
                    System.out.println("Store is closed for the day to restock.");
                    store.restockRobbery();
                }

                //if the store wasn't robbed then open then start the day
                else{
                    store.startADay(day);
                }
            }

            else{
                store.startADay(day);
            }


    }

        //display summary
        store.summaryReport();
    }
}