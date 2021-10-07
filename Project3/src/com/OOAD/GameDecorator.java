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
    Cashier cashierObj;
    public GameDecorator(Game g) {
        super(g);
    }
}

class specialToken extends GameDecorator{
    //int random_int = (int)Math.floor(Math.random()*(100-0+1)+0);
    public specialToken(Game g){
        super(g);
        if(random_int <= 50){
            System.out.print("Special token also purchased. ");
            g.price += 1.00;
        }
    }
}

class specialCard extends GameDecorator{
    public specialCard(Game g){
        super(g);
        if(random_int <= 20){
            System.out.print("Special card also purchased. ");
            g.price += 2.00;
        }

    }
}

class spareParts extends GameDecorator{
    public spareParts(Game g){
        super(g);
        if(random_int <= 30){
            System.out.print("Spare parts also purchased. ");
            g.price += 3.00;
        }
    }
}

class customMini extends GameDecorator{
    public customMini(Game g){
        super(g);
        if(random_int <= 20){
            System.out.print("Special token also purchased. ");
            g.price += 2.50;
        }
    }
}