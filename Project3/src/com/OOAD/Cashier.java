package com.OOAD;
import java.util.*;
import java.util.ArrayList;
//message refers to the string that gets sent to announcer

public class Cashier extends Employee{

    int damageChance; //integer percentage chance of damage for vacuuming
    String stackMethod; // how does this cashier stack games

    //initialize reference variables for the stack behavior
    StackBehavior stackBehavior;
    //Announcer announcer;
    String message;
    Observer observer;

    //initialize reference variables for the cookie class
    Cookie cookie;

    //initialize reference variables for the baker class
    Baker baker;

    //delegate to the behavior class
    public void performStack(ArrayList<Game> games){
        stackBehavior.stack(games);
    }

    public Cashier(String name, int dmgChance, StackBehavior stack) {
        super(name);
        damageChance = dmgChance;
        this.stackBehavior = stack;
        //this.announcer = announcer;
    }

    public void registerObserver(Observer observerInput){
        observer = observerInput;
    }

    public void notifyObserver(String inputMessage){
        observer.Announcement(inputMessage);
    }

    public void arriveAtStore(int day) {

        //System.out.println(name+" has arrived on day "+day);
        message = name+" has arrived on day "+day;

        //this.announcer(name, message);  need to call a method
        //announcer.Announcement(message); /* COMMENT THIS OUT IN ORDER TO RUN */
        notifyObserver(message);
    }

    public void leaveTheStore(int day) {
        notifyObserver(name+" has left on day "+day);
    }

    public void checkForNewGames(Store store) {
        // Check for game arrivals, move them to inventory
        for (Game g:store.games) {
            if (g.countOrdered > 0) {
                g.countInventory += g.countOrdered;
                g.countOrdered = 0; // clear this after they're in inventory
            }
        }
    }

    public void countTheMoney(Store store) {
        //say what the starting cash is
        //System.out.println(name+" counts the money.");
        message = name+" counts the money.";
        notifyObserver(message);
        //System.out.println(name+" sees "+Utility.asDollar(store.registerCash)+" in the register");
        message = name+" sees "+Utility.asDollar(store.registerCash)+" in the register";
        notifyObserver(message);

        // if the money is less than 100, add 1000
        if (store.registerCash < 100) {
            store.registerCash += 1000;
            store.registerAdds += 1;
            notifyObserver(name+" added $1000 to the register, now at $"+store.registerCash);
        }
    }

    public void vacuumTheStore(Store store) {
        notifyObserver(name+" vacuums the store");
        int damageCheck = Utility.rndFromRange(1,100);
        if (damageCheck<=damageChance) {
            notifyObserver(name+" broke a game!");
            store.breakARandomGame();
        }
        else {
            notifyObserver(name+" did not break a game!");
        }
    }

    public void stackTheGames(ArrayList<Game> games) {
        stackBehavior.stack(games);
    }
}