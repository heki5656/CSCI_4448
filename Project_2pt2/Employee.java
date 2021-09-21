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

    public void stackGame(){
        storeObj.gameVals();
        //System.out.println(storeObj.gameList.get(2).name);
        if(cashierName == "Ernie"){
            //all the games have the same height so Ernie would not sort the list
            storeObj.gameList = storeObj.gameList;
        }
        else if(cashierName == "Burt"){
            for(int i = storeObj.gameList.size()-1; i > 0; i--){
                for(int j = 0; j < storeObj.gameList.size()-i-1; j++){
                    if(storeObj.gameList.get(j).width > storeObj.gameList.get(j+1).width){
                        Game tempObj; //don't need it to be new since I declare a val for it below
                        Game tempObj2;
                        tempObj = storeObj.gameList.get(j);
                        tempObj2 = storeObj.gameList.get(j+1);
                        storeObj.gameList.set(j, tempObj2);
                        storeObj.gameList.set(j+1, tempObj);
                    }
                }
            }
        }
    }

    public void openStore(){

    }

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
