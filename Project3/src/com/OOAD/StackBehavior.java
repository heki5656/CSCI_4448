package com.OOAD;
import java.util.Comparator;
import java.util.ArrayList;

//The strategy pattern is being used here. As the different employees have different ways they
//stack the games, we are handling this in the StackBehavior class, in order for each employee
//of the store to be able to stack the games on the shelves using their own behavior. 
public interface StackBehavior {
    public void stack(ArrayList<Game> games);
}

class ErnieStacks implements StackBehavior{
    public void stack(ArrayList<Game> games){
        // Height source is the whole stack of games
        for (Game g:games) g.shelfMeasure = g.height*g.countInventory;
        games.sort(new Sorter());

        //print out Ernie stacking the games
        int i = 0;
        for (Game g:games) {
            g.shelfPosition = i;
            System.out.println("Ernie stacked "+g.name+" on shelf "+g.shelfPosition+", game height=" + g.shelfMeasure);
            i += 1;
        }
    }
}

class BurtStacks implements StackBehavior{
    public void stack(ArrayList<Game> games){
        System.out.println("Burt is stacking");
        
        // Width is of a single game
        for (Game g:games) g.shelfMeasure = g.width;
        games.sort(new Sorter());

    //print out Burt stacking the games
    int i = 0;
    for (Game g:games) {
        g.shelfPosition = i;
        System.out.println("Burt stacked "+g.name+" on shelf "+g.shelfPosition+", game width=" + g.shelfMeasure);
        i += 1;
    }

}
    
}

class BartStacks implements StackBehavior{
    public void stack(ArrayList<Game> games){
        System.out.println("Bart is stacking");

        // Width is of a single game
        for (Game g:games) g.shelfMeasure = g.width;
        games.sort(new Sorter());

    //print out Burt stacking the games
    int i = 0;
    for (Game g:games) {
        g.shelfPosition = i;
        System.out.println("Bart stacked "+g.name+" on shelf "+g.shelfPosition+", game width=" + g.shelfMeasure);
        i += 1;
    }

    //TODO implement the inventory for Bart stacking the games
   
   }
}

class Sorter implements Comparator<Game> {
    @Override
    public int compare(Game o1, Game o2) {
        Integer o2m = o2.shelfMeasure;
        Integer o1m = o1.shelfMeasure;
        return o2m.compareTo(o1m);
    }
}