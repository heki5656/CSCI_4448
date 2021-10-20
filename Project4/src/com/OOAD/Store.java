package com.OOAD;
import java.util.*;

import java.util.ArrayList;

public class Store {

    Announcer announcer;
    String[] customers = new String[]{"CustomerA", "CustomerB", "CustomerC", "CustomerD", "CustomerE"};
    String[] previousCustomers = new String[]{"", "", "", "", "", "", "", "", "", ""};
    double registerCash; //starts at $0
    int registerAdds; //starts at 0, incremented when we add $1000
    ArrayList<Cashier> cashiers;
    ArrayList<Game> games;
    Cashier activeCashier;
    ArrayList<Game> brokenGames;
    Cookie cookie;
    Baker baker;
    CustomerFactory factory;
    boolean cookieMonster = false;

    public Store() {
        //initialize the announcer
        announcer = new Announcer("Guy");

        //initialize the customer factory
        factory = new CustomerFactory();

        //initialize the cashiers
        cashiers = new ArrayList<Cashier>();
        cashiers.add(new Cashier("Burt",10,new BurtStacks()));
        cashiers.add(new Cashier("Ernie", 5,new ErnieStacks()));
        cashiers.add(new Cashier("Bart", 2, new BartStacks()));

        //initialize the games
        games = new ArrayList<Game>();
        games.add(new KidsGame("Mousetrap"));
        games.add(new KidsGame("Candyland"));
        games.add(new KidsGame("Connect Four"));
        games.add(new CardGame("Magic"));
        games.add(new CardGame("Pokémon"));
        games.add(new CardGame("Netrunner"));
        games.add(new FamilyGame("Monopoly"));
        games.add(new FamilyGame("Clue"));
        games.add(new FamilyGame("Life"));
        games.add(new BoardGame("Catan"));
        games.add(new BoardGame("Risk"));
        games.add(new BoardGame("Gloomhaven"));

        //initialize a place for broken games
        brokenGames = new ArrayList<Game>();

        //initialize a cookie object for the store
        cookie = new Cookie();

        //initializing the baker
        baker = new Baker("Gonger");
    }

    //customer comes in, so just set as a empty string
    public void customerComes(String type){
        //check what type of customer
        double customerProbability = Utility.rndFromRange(1, 100);

        Customer customer;

        //customer is a Family Gamer 25% chance
        if (customerProbability <= 25){
            //notifyObserver("Family Gamer");
            customer = factory.createCustomer("Family Gamer");
        }

        //customer is a  Kid Gamer 25% chance
        else if (customerProbability <= 50){
            //notifyObserver("Kid Gamer");
            customer = factory.createCustomer("Kid Gamer");
        }

        //customer is a card gamer 24% chance
        else if (customerProbability <= 74){
            //notifyObserver("Card Gamer");
            customer = factory.createCustomer("Card Gamer");
        }

        //customer is a board gamer 24% chance
        else if (customerProbability <= 98){
            //notifyObserver("Board Gamer");
            customer = factory.createCustomer("Board Gamer");
        }

        //customer is the cookie monster 2% chance
        else if (customerProbability <= 100){
            //notifyObserver("COOKIE MONSTER!!!");
            customer = factory.createCustomer("Cookie Monster");
            cookieMonster = true;
        }
    }

    public void startADay(int day) {
        //pick a cashier for the day
        int n = Utility.rndFromRange(0,cashiers.size()-1);
        activeCashier = cashiers.get(n);

        //the type of announcer (lazy or eager)
        double announcerType = Utility.rndFromRange(1, 10);
        //null or not singleton objects depending on which one is called
        //SingletonLazyAnnouncer lazyAnnouncer = null;
        //SingletonEagerAnnouncer eagerAnnouncer = null;

        //instantiating the lazy announcer
        SingletonLazyAnnouncer lazyAnnouncer = null;
        SingletonEagerAnnouncer eagerAnnouncer = null;
        if(announcerType <= 5){
            lazyAnnouncer = lazyAnnouncer.getInstance();
        }
        //otherwise the eager announcer is instantiated
        else if(announcerType <= 10){
            eagerAnnouncer = eagerAnnouncer.getInstance();
        }
        announcer.announcerPersonality(lazyAnnouncer, eagerAnnouncer);

        //need to send an announcer to the cashier so that it won't null
        activeCashier.registerObserver(announcer);

        //have the cashier do their things
//        String val = com.OOAD.Utility.selectName(day);
//        System.out.println("selected customer " + val);
        activeCashier.arriveAtStore(day);
        activeCashier.checkForNewGames(this);
        activeCashier.countTheMoney(this);
        baker.dropOffCookies(1, this);
        activeCashier.vacuumTheStore(this);
        activeCashier.stackTheGames(games);
        activeCashier.openTheStore(this);
        activeCashier.orderNewGames(this);
        activeCashier.closeTheStore(day);
    }

    public void summaryReport() {
        // per game type number in inventory, number sold, total sales
        System.out.println("===Store Summary Report===");
        System.out.println("Game sales:");
        System.out.println("Game\tInventory\tSold\tTotal $");
        for (Game g:games) {
            System.out.println(g.name+"\t"+g.countInventory+"\t"+g.countSold+"\t"+Utility.asDollar(g.countSold*g.price));
        }
        // what's in damaged games
        System.out.println("Broken games:");
        if (brokenGames.size()==0) System.out.println("No games broken.");
        else {
            System.out.println("Game\tCount");
            for (Game g : brokenGames) {
                System.out.println(g.name+"\t"+g.countInventory);
            }
        }
        // final register count
        System.out.println("Final register funds: "+Utility.asDollar(registerCash));
        // additions to register
        System.out.println("$ added to register: "+Utility.asDollar(registerAdds*1000)+" ("+registerAdds+" adds)");
    }

    public void breakARandomGame() {
        //break a random game
        Game g;
        do {
            // find a random game with an inventory > 0
            int n = Utility.rndFromRange(1, games.size());
            g = games.get(n-1);
        } while (g.countInventory==0);
        //remove it from inventory
        g.countInventory -= 1;
        //place it in the brokenGames (if not there)
        Game foundbg = null;
        for (Game bg:brokenGames) {
            if (bg.name.equals(g.name)) {
                foundbg = bg;
                break;
            }
        }
        if (foundbg == null) {
            Game bg = new Game(g); //uses the copy constructor in Game
            bg.countInventory = 1;  //i'm going to use the countInventory to count broken games
            brokenGames.add(bg);
        }
        else {
            //The game is in the list of broken games, so just increase inventory count by 1
            foundbg.countInventory += 1;
        }
    }

    public void robbed() {
        announcer.Announcement("The store was robbed! The robber stole all the money, games, and cookies!!!!");

        //set cookie and cash to 0
        cookie.inventory = 0;
        registerCash = 0;

        //set game inventory to 0 for all the games
        for (int i = 0; i < games.size(); i++){
            games.get(i).countInventory = 0;
        }

        //announce the cash register amount, cookies, and the game inventory
        announcer.Announcement("Cash Register = " + Utility.asDollar(registerCash));
        announcer.Announcement("Cookies in stock: " + cookie.inventory);
        for (int i =0; i < games.size(); i++) {
            announcer.Announcement(games.get(i).name + " inventory: " + games.get(i).countInventory);
        }
        
    }

    public void restockRobbery() {
        //restock all the games to 3
        for (int i = 0; i < games.size(); i++){
            games.get(i).countInventory = 3;
        }
        announcer.Announcement("Insurance payed to restock the games to inventory of 3.");

        //restock cookies
        cookie.inventory += 12;
        announcer.Announcement("Insurance payed to restock cookies to inventory of 12.");
        

        //adding $1000 to the cash register
        registerCash = 1000;
        registerAdds += 1;
        announcer.Announcement("Insurance added $1000 to the register, now at $"+ registerCash);
    }





}
