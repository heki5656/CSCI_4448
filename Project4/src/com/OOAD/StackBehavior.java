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
        //create a new game list to put the games with an inventory of 1 in
        ArrayList<Game> inventoryGames = new ArrayList<Game>();

        //check which games have an inventory of 1 and if so remove them and put them on a new list
        for (int i = 0; i < games.size(); i++){
            if (games.get(i).countInventory == 1){
                inventoryGames.add(games.get(i));
                games.remove(i);
            }
        }

        // Width is of a single game
        for (Game g:games) g.shelfMeasure = g.width;
        games.sort(new Sorter());

        //add the inventory 1 games back to the games list
        for (int i = 0; i < inventoryGames.size(); i++){
            games.add(inventoryGames.get(i));
        }


    //print out Burt stacking the games
    int i = 0;
    for (Game g:games) {
        g.shelfPosition = i;
        System.out.println("Bart stacked "+g.name+" on shelf "+g.shelfPosition+", game width=" + g.shelfMeasure);
        i += 1;
    }
   
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
