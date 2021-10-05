package com.OOAD;

public class Baker extends Employee{
    Game game;
    Store store;
    double bakerWallet = 0.0; // $0 to begin with
    int cookiePrice = 3; // $3 per cookie

    public Baker(String name) {
        super(name);
    }

    public void dropOffCookies(int numOfCookies){
        store.registerCash = store.registerCash - (0.5 * cookiePrice * numOfCookies);
        bakerWallet = store.registerCash; //money reduced will go to Baker's pocket

    }
}
