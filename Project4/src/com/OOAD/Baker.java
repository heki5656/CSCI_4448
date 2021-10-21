package com.OOAD;

public class Baker extends Employee{
    Game game;
    Store store;
    double bakerWallet = 0.0; // $0 to begin with
    Announcer announcer;
    int packages = 1;

    public Baker(String name) {
        super(name);
    }

    public void dropOffCookies(int packages, Store storeInput){
        packages = packages;
        store = storeInput;
        store.registerCash = store.registerCash - (0.5 * store.cookie.price * (packages * 12));
        bakerWallet += (0.5 * store.cookie.price * (packages * 12)); //money reduced will go to Baker's pocket
        store.cookie.inventory += (packages * 12); //update the cookie inventory 

    }
}

