package com.OOAD;
import java.util.*;

//decorator class file for the games
//called when the store opens and the cashier is selling the game
//note: don't need to keep track of all the parts sold in addition, just need to announce
//referenced chp 3 of the head first textbook for the coffee example

public abstract class GameDecorator extends Game {

    //random variable for generating the random values, values 0 - 100
    int random_int = (int)Math.floor(Math.random()*(100-0+1)+0);
    //need an object to reference to (for adding on the price and such)
    public GameDecorator(String name) {
        super(name);
        Store store = new Store();
        //monopoly game condition: 50% chance of getting 1 special tokens pack
        if((name == "Monopoly") && (random_int <= 50)){

        }

    }
}