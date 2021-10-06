package com.OOAD;

public class Baker extends Employee{
    Game game;
    Store store;
    double bakerWallet = 0.0; // $0 to begin with

    public Baker(String name) {
        super(name, null);
    }

    public void dropOffCookies(int packages){
        store.registerCash = store.registerCash - (0.5 * store.cookie.price * (packages * 12));
        bakerWallet = store.registerCash; //money reduced will go to Baker's pocket
        store.cookie.inventory += (packages * 12); //update the cookie inventory 

    }
}

