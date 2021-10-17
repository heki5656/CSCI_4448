package com.OOAD;
import java.util.*;

import java.util.ArrayList;

public class Store {

    Announcer announcer;
    double registerCash; //starts at $0
    int registerAdds; //starts at 0, incremented when we add $1000
    ArrayList<Cashier> cashiers;
    ArrayList<Game> games;
    Cashier activeCashier;
    ArrayList<Game> brokenGames;
    Cookie cookie;
    Baker baker;
    CustomerFactory factory;

    public Store() {
        //initialize the announcer
        announcer = new Announcer("Guy");

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

    public void startADay(int day) {
        //pick a cashier for the day
        int n = Utility.rndFromRange(0,cashiers.size()-1);
        activeCashier = cashiers.get(n);

        //need to send an announcer to the cashier so that it won't null
        activeCashier.registerObserver(announcer);

        //have the cashier do their things
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
