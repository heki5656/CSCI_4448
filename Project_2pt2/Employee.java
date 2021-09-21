import java.util.*;
import java.util.List;

public class Employee{
 //name attribute for each instance of a class
    String name;

    public Employee(String name){
        this.name = name;
    }
}

// List of games in store, cashier has reference to store, cashier can access games
class Cashier extends Employee { // Example of Inheritance

    Store storeObj = new Store();
    Game game = new Game();

    public Cashier(String name) {
        super(name);
    }


    public void arriveAtStore(){
        System.out.println(storeObj.pickEmployee() + "the cashier has arrived at the store on Day ");
    }

    public void vacuumStore(){
        System.out.println(storeObj.pickEmployee() + " vacuumed the store");

    }

    public static void stackGame(){

    }

    public static void openStore(){

    }

    public static void orderGame(){

    }

    public void closeStore(){
        System.out.println(storeObj.pickEmployee() + " is leaving and closed the store");
    }

    public void countMoney(){
        System.out.println("There are $" + game.cashReg + " in the cash register.");

        if (game.cashReg < 100){
            game.cashReg = game.cashReg + 1000;
            System.out.println("Money was added to the cash register.");
        }
    }
}
