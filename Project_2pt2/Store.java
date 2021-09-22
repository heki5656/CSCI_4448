import java.util.Arrays;
import java.io.IOException;
import java.util.*;
//import java.util.ArrayList;
//import java.util.Random;
//import java.util.List;

public class Store{
    //creating the lists for damaged games, employees, and the games in the store
    List<Game> damageContainer = new ArrayList<Game>(); // list of all the damaged games
    List<String> employeeList = new ArrayList<String>();
    List<Game> gameList = new ArrayList<Game>();
    double cashReg = 0.00;
    int day = 1;

    public void createEmployee(){
        Employee employee1 = new Employee();
        employee1.setName("Burt");
        employeeList.add(employee1.getName());
        Employee employee2 = new Employee();
        employee2.setName("Ernie");
        employeeList.add(employee2.getName());
    }
    //create and pick employee are an example of coupling because they both initialize who the staff of the store are and set who works for the day and it is a property
    //that cannot be changed by the employee or cashier class, and they can only use the store objects of the employee to determine who does what.
    public String pickEmployee(){
        createEmployee();
        double rangeMin = 0.0f;
        double rangeMax = 1.0f;
        //Employee getEmployee = null;
        Random r = new Random();
        double createdRanNum = rangeMin + (rangeMax - rangeMin) * r.nextDouble();

        if (createdRanNum < 0.5){
            return employeeList.get(0); // get Burt
            //return getEmployee;
        }

        if (createdRanNum >= 0.5){
            return employeeList.get(1); // get Ernie
            //return getEmployee;
        }

        return null;
    }
    
    //this method instantiates all the game objects in the game list that the store uses to sell games to customers
    //these different game objects are an example of identity because even though they are all game type objects and there are groups of game subclasses where 
    //there are 3 of those different subclass objects, they are still used differently as they each have their own unique game and card game also has a different set of sizes.
    //And when they are being sold the inventory of each specific game is being affected depending on which one is called despite them being of the same class type of even 
    //subclass type object
    public void gameVals(){
        //implementing the family game objects
        Game famGame1 = new familyGame();
        famGame1.name = "Monopoly";
        famGame1.shelfPosition = 1;
        gameList.add(famGame1);
        Game famGame2 = new familyGame();
        famGame2.name = "Clue";
        famGame2.shelfPosition = 2;
        gameList.add(famGame2);
        Game famGame3 = new familyGame();
        famGame3.name = "Life";
        famGame3.shelfPosition = 3;
        gameList.add(famGame3);

        //implementing the kids game objects
        Game kidsGame1 = new kidsGame();
        kidsGame1.name = "Mousetrap";
        kidsGame1.shelfPosition = 4;
        gameList.add(kidsGame1);
        Game kidsGame2 = new kidsGame();
        kidsGame2.name = "Candyland";
        kidsGame2.shelfPosition = 5;
        gameList.add(kidsGame2);
        Game kidsGame3 = new kidsGame();
        kidsGame3.name = "Connect Four";
        kidsGame3.shelfPosition = 6;
        gameList.add(kidsGame3);

        //implementing the card game objects
        Game cardGame1 = new cardGame();
        cardGame1.name = "Magic";
        cardGame1.shelfPosition = 7;
        gameList.add(cardGame1);
        Game cardGame2 = new cardGame();
        cardGame2.name = "Pokemon";
        cardGame2.shelfPosition = 8;
        gameList.add(cardGame2);
        Game cardGame3 = new cardGame();
        cardGame3.name = "Netrunner";
        cardGame3.shelfPosition = 9;
        gameList.add(cardGame3);

        //implementing the board game objects
        Game boardGame1 = new boardGame();
        boardGame1.name = "Catan";
        boardGame1.shelfPosition = 10;
        gameList.add(boardGame1);
        Game boardGame2 = new boardGame();
        boardGame2.name = "Risk";
        boardGame2.shelfPosition = 11;
        gameList.add(boardGame2);
        Game boardGame3 = new boardGame();
        boardGame3.name = "Gloomhaven";
        boardGame3.shelfPosition = 12;
        gameList.add(boardGame3);
    }

    //runs all the methods necessary to run the store for 30 days of how an average day would go
    public void dayStimulation(){
//        Cashier cashierObj = new Cashier(pickEmployee());
        //the cashier has to be outside the loop since the cash reg keeps
        //resetting each time
        Cashier cashierObj = new Cashier();
        for(int i = 1; i < 31; i++){
            day = i;
            String cashier = pickEmployee();
            cashierObj.arriveAtStore(cashier);
            System.out.print(day);
            System.out.println();
            cashierObj.stackGame(cashier);
            cashierObj.countMoney();
            cashierObj.openStore(cashier);
            cashierObj.vacuumStore(cashier);
            //cashierObj.orderGame();
            cashierObj.closeStore(cashier);
            System.out.println();
        }
    }
}
