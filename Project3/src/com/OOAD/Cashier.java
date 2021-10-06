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

    // https://stackoverflow.com/questions/9832919/generate-poisson-arrival-in-java
    private static int getPoissonRandom(double mean) {
        Random r = new Random();
        double L = Math.exp(-mean);
        int k = 0;
        double p = 1.0;
        do {
            p = p * r.nextDouble();
            k++;
        } while (p > L);
        return k - 1;
    }

    public void openTheStore(Store store) {
        boolean cookieMonster = false;
        //int customerCount = Utility.rndFromRange(0,4);
        int customerCount = 1 + getPoissonRandom(3.0);
        //System.out.println(name+" sees "+customerCount+" customers coming in the store!");
        String message = name + " sees " + customerCount + " customers coming in the store!";
        for (int c = 1; c <= customerCount; c++) {
            int cookieNum = Utility.rndFromRange(1, 3); // customer purchases 1-3 cookies
            double cookieCustomerPrice = store.cookie.price * cookieNum;
            //store.registerCash += cookieCustomerPrice; // addi.
            // ..price of cookies to cash register money
            //cookie.inventory -= cookieNum; // reduce cookie inventory
            int cookiePurchaseCount = 0; // number of cookies bought
            double chanceOfPurchase = 20;
            int purchaseCount = 0;

            //**********COOKIE MONSTER************//
            int cookieMonsterChance = Utility.rndFromRange(1, 100); //cookie monster chance
            //check if customer is the cookie monster
            if(cookieMonsterChance == 1){
                cookieMonster = true;
                System.out.println("COOKIE MONSTER!!!");

                //check if there is cookies in the store
                if(store.cookie.inventory > 0){
                    //cookie monster will eat all the cookies without paying for them
                    System.out.println("Cookie monster is eating " + store.cookie.inventory + " cookie(s). There are no more cookies in the inventory.");
                    store.cookie.inventory = 0;

                    //cookie monster will destroy 1-6 games
                    int cookieMonsterDestroyed = Utility.rndFromRange(1, 6);

                    //loop through the games cookie monster destroyed
                    for (int i = 0; i < cookieMonsterDestroyed; i++){
                        System.out.println("Cookie monster is breaking a random game!");
                        store.breakARandomGame();
                    }

                }
                //if there are no cookies then cookie monster leaves the store
                else{
                    System.out.println("There are no cookies! Cookie monster is leaving the store.");
                }

            }
            //for (Cookie ck:store.games) {
            //if (purchaseCount <= 1) {   // two game purchase limit
            //if (Utility.rndFromRange(1,100)<=chanceOfPurchase) {
            //buying this game if it's on the shelf
            if ((cookieNum > store.cookie.inventory) && (store.cookie.inventory < 0)) {
                store.cookie.inventory = cookieNum - store.cookie.inventory; // customer buys whatever remaining cookies left if inventory is less than desired number of cookies
            }
            if (store.cookie.inventory == 0) {
                // decrease chance of purchasing game by 10%
                if (Utility.rndFromRange(1, 100) <= chanceOfPurchase){
                    chanceOfPurchase = chanceOfPurchase * 0.9;
                }
            }
            if (store.cookie.inventory > 0) {
                cookiePurchaseCount = cookiePurchaseCount + 1;
                if (Utility.rndFromRange(1, 100) <= chanceOfPurchase) {
                    chanceOfPurchase = chanceOfPurchase * 1.2;
                }
                store.registerCash += cookieCustomerPrice;
                store.cookie.inventory -= cookieNum;
                //g.countSold += 1;
                //this is where gameDecorator would go in
                //GameDecorator decorator;
                //move this to announcer class
                System.out.println(name + " sold " + cookieNum + " cookies to customer " + c + " for " + Utility.asDollar(store.cookie.price));
            }

            //chanceOfPurchase -= 2;
            //}
            //}
            // customer now decides to buy games after having bought cookies

            //Only let customers buy games if not cookie monster
            if (cookieMonster == false){
                for (Game g : store.games) {
                    if (purchaseCount <= 1) {   // two game purchase limit
                        //if (cookiePurchaseCount > 0 ){ // customer bought cookies, so check if they will buy games
                            //if (Utility.rndFromRange(1, 100) <= chanceOfPurchase * 1.2) { // chance of buying game increases 20%
                            //buying this game if it's on the shelf
                            if (g.countInventory > 0) {
                                purchaseCount += 1;
                                store.registerCash += g.price;
                                g.countInventory -= 1;
                                g.countSold += 1;
                                //this is where gameDecorator would go in
                                GameDecorator decorator;
                                //move this to announcer class
                                System.out.println(name + " sold " + g.name + " to customer " + c + " for " + Utility.asDollar(g.price));
                            }
                            chanceOfPurchase -= 2;
                        //}
                    }
                }
            }

        }
    }

    public void orderNewGames(Store store) {
        double cost = 0;
        if (store.cookie.inventory == 0) {
            store.baker.packages += 1;
        }

        else { // if there are cookies in store at end of the day
            if (store.baker.packages >= 2) { // deliver a minimum package of 1 cookies if there are cookies in store
                store.baker.packages -= 1;
            }
        }

        for (Game g:store.games) {
            if (g.countInventory == 0) {
                g.countOrdered = 3; // always order 3
                cost += g.countOrdered * g.price / 2; //pay for the order
                System.out.println(name+" ordering new copies of "+g.name);
            }
        }
        if (cost != 0) {
            store.registerCash -= cost;
            System.out.println(name+" ordered new games for "+Utility.asDollar(cost));
        }
        else System.out.println(name + " did not order any games");
    }

    public void closeTheStore(int day) {
        System.out.println(name + " is closing the store");
        leaveTheStore(day);
    }
}


