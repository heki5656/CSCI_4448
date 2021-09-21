import java.util.*;
import java.util.List;
import java.lang.Math;

public class Employee{
 //name attribute for each instance of a class
    String name;

    public Employee(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// List of games in store, cashier has reference to store, cashier can access games
class Cashier extends Employee { // Example of Inheritance

    Store storeObj = new Store();
    Game game = new Game();

    String cashierName = storeObj.pickEmployee();

    public Cashier(String storeObj) {
        super(storeObj);
    }


    public void arriveAtStore(){
        System.out.println(cashierName + " the cashier has arrived at the store on Day ");
    }

    public void vacuumStore(){
//        System.out.println(cashierName + " vacuumed the store");
//
//        if (cashierName == "Ernie"){
//        }
//
//        var d = Math.random();
//        if (d * 100 < 15){
//            storeObj.gameVals(); //randomly pick a game from gameList in gameVal - to do
//        }

    }

//    public static void stackGame(){
//
//    }
//
//    public static void openStore(){
//
//    }

    public static void orderGame(){
        System.out.println("Ordering new games.");

    }

    public void closeStore(){
        System.out.println(cashierName + " is leaving and closed the store");
    }

    public void countMoney(){
        System.out.println("There are $" + storeObj.cashReg + " in the cash register.");

        if (storeObj.cashReg < 100){
            storeObj.cashReg = storeObj.cashReg + 1000;
            System.out.println("Money was added to the cash register.");
        }
    }
}
