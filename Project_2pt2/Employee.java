import java.util.*;
import java.util.List;
import java.lang.Math;
import java.util.Random;

public class Employee{
    //this private variable is an example of encapsulation because it shouldn't be edited by other classes as once an employee is picked it has to remain the same 
    //for the other class uses 
    private String name;

    public void setName(String name){ // set employee name
        this.name = name;
    }

    public String getName() { // get name of employee
        return name;
    }
    Store storeObj = new Store();
}

//The cashier methods are an example of abstraction because how the cashier decides to do certain tasks are not displayed for the customers and the details of it are instead 
//hidden and only the necessary values of what occurs is being shown in the store class.

// The fact that the cashier class "extends" the employee class is an example of inheritance because the methods and attributes in Employee are inherited by Cashier like name,
// setName(), and getName(). Cashier can now use those methods and attributes from Employee. 

// An example of cohesion is the relationship between the cashier and store classes. They are highly cohesive because Cashier only focuses on the specific actions a cashier
// can take. The Store class solely focues on deciding who that cashier is that will work that day and takes care of initializations for the games. These actions are not 
// combined into one class as separate methods. Instead, Cashier is calling those methods and attributes from Store. 

class Cashier extends Employee {

//    Store storeObj = new Store();
    Game game = new Game();

    public void arriveAtStore(String cashierName){ 
        System.out.print(cashierName + " the cashier has arrived at the store on Day ");
    }

    public void vacuumStore(String cashierName){
        System.out.println(cashierName + " vacuumed the store");
        java.util.Random rand = new java.util.Random();
        double damageProb = rand.nextDouble(); // pick random double value to determine if Burt or Ernie damages a game

        if (cashierName == "Ernie"){
            if (damageProb < 0.95){
                Random random = new Random();
                int max = 12;
                int min = 1;
                int i = random.nextInt(max - min + 1) + min; //pick random shelf number to represent game
                storeObj.gameVals();
                String name = storeObj.gameList.get(i).name; //select name of random game chosen based on shelf number 
                System.out.println(cashierName + " says that " + name + " is damaged.");
                storeObj.gameList.get(i).inventoryAmount = storeObj.gameList.get(i).inventoryAmount - 1; // reduce inventory because a game was damaged so we take a new game out
                System.out.println(storeObj.gameList.get(i).name + " has " + storeObj.gameList.get(i).inventoryAmount + " games left in inventory");
                if(storeObj.gameList.get(i).inventoryAmount == 0){
                    orderGame(i);
                }
                storeObj.damageContainer.add(storeObj.gameList.get(i)); // add the damaged game to the damaged game container
            }
        }

        if (cashierName == "Burt"){
            if (damageProb < 0.60){
                Random random = new Random();
                int max = 12;
                int min = 1;
                int i = random.nextInt(max - min + 1) + min;
                stackGame(cashierName);
                String name = storeObj.gameList.get(i).name;
                System.out.println(cashierName + " says that " + name + " is damaged.");
                if(storeObj.gameList.get(i).inventoryAmount > 0){
                    storeObj.gameList.get(i).inventoryAmount = storeObj.gameList.get(i).inventoryAmount - 1;
                }
                else if(storeObj.gameList.get(i).inventoryAmount == 0){
                    orderGame(i);
                }
                System.out.println(storeObj.gameList.get(i).name + " has " + storeObj.gameList.get(i).inventoryAmount + " games left in inventory");
                storeObj.damageContainer.add(storeObj.gameList.remove(i));
            }
        }
    }

    public void stackGame(String cashierName){ 
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
    
    public void openStore(String cashierName){
        stackGame(cashierName);
        Random rand = new Random();
        int numCustomers = rand.nextInt(4);
        //generates a random number of customers from 1-4 for the day 
        for(int i = 0; i < numCustomers; i++){
            Random randGame = new Random();
            int soldGameAmt = randGame.nextInt(3);
            //determins the number of games each customer chooses to buy in a day, ranging from 0-3
            for(int j = 0; j < soldGameAmt; j++){
                Random randNum = new Random();
                int prob = randNum.nextInt(99);
                //determines the probability for which games are sold to the customer
                if(prob <= (20-i*2)){
                    storeObj.cashReg = storeObj.cashReg + storeObj.gameList.get(i).cost;
                    storeObj.gameList.get(i).inventoryAmount = storeObj.gameList.get(i).inventoryAmount - 1;
                    //checking of the inventory to make sure that the cashier orders more games if the amount of one drops to 0
                    if(storeObj.gameList.get(i).inventoryAmount == 0){
                        orderGame(i);
                    }
                    //counter for the number of games sold 
                    game.numSold = game.numSold + 1;
                    System.out.println(cashierName + " sold a " + storeObj.gameList.get(i).name + " game to Customer " + i + " for $" + storeObj.gameList.get(i).cost);
                }
            }
        }
    }

    public void orderGame(int gameNum){ // pass in the shelf number of the game that has zero quantity left in inventory in order to add more games of that type
        System.out.println("Ordering new games.");
        storeObj.gameVals();
        String name = storeObj.gameList.get(gameNum).name; // get the name of the game that has zero left in inventory
        storeObj.gameList.get(gameNum).inventoryAmount = storeObj.gameList.get(gameNum).inventoryAmount + 3; // reset inventory amount for that game back to 3
        storeObj.cashReg = storeObj.cashReg - (storeObj.gameList.get(gameNum).cost/2.0); // update cash register amount after paying for the new game
    }

    public void closeStore(String cashierName){
        System.out.println(cashierName + " is leaving and closed the store");
    }

    public void countMoney(){
        System.out.println("There are $" + storeObj.cashReg + " in the cash register.");

        if (storeObj.cashReg < 100){ // if money in cash register goes below $100, add $1000 to it
            storeObj.cashReg = storeObj.cashReg + 1000;
            System.out.println("Money was added to the cash register.");
        }
    }
}
