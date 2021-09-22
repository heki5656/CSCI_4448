import java.util.*;
import java.util.List;
import java.lang.Math;
import java.util.Random;

public class Employee{
    //name attribute for each instance of a class
    //this private variable is an example of encapsulation because it shouldn't be edited by other classes as once an employee is picked it has to remain the same 
    //for the other class uses 
    private String name;

//    public Employee(String name){
//        this.name = name;
//    }
    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
    Store storeObj = new Store();
}

// List of games in store, cashier has reference to store, cashier can access games

//The cashier methods are an example of abstraction because how the cahsier decides to do certain tasks are not displayed for the customers and the details of it are instead 
//hidden and only the necessary values of what occurs is being shown in the store class.
class Cashier extends Employee { // Example of Inheritance

//    Store storeObj = new Store();
    //this keeps resetting the cash register as well
    Game game = new Game();

    //String cashierName = storeObj.pickEmployee();

    //public Cashier(String storeObj) {
//        super(storeObj);
//    }
    public void arriveAtStore(String cashierName){
        System.out.print(cashierName + " the cashier has arrived at the store on Day ");
    }

    public void vacuumStore(String cashierName){
        System.out.println(cashierName + " vacuumed the store");
        java.util.Random rand = new java.util.Random();
        double f = rand.nextDouble();

        if (cashierName == "Ernie"){
            if (f < 0.95){
                Random random = new Random();
                int max = 12;
                int min = 1;
                int i = random.nextInt(max - min + 1) + min;
                storeObj.gameVals();
                String name = storeObj.gameList.get(i).name;
                System.out.println(cashierName + " says that " + name + " is damaged.");
                storeObj.gameList.get(i).inventoryAmount = storeObj.gameList.get(i).inventoryAmount - 1;
                System.out.println(storeObj.gameList.get(i).name + " has " + storeObj.gameList.get(i).inventoryAmount + " games left in inventory");
                if(storeObj.gameList.get(i).inventoryAmount == 0){
                    orderGame(i);
                }
                storeObj.damageContainer.add(storeObj.gameList.get(i));
                //System.out.println("removed" + storeObj.damageContainer);

            }
        }

        if (cashierName == "Burt"){
            if (f < 0.60){
                Random random = new Random();
                int max = 12;
                int min = 1;
                int i = random.nextInt(max - min + 1) + min;
                stackGame(cashierName);
                String name = storeObj.gameList.get(i).name;
                System.out.println(cashierName + " says that " + name + " is damaged.");
                //System.out.println("height" + storeObj.gameList.get(i).height);
                if(storeObj.gameList.get(i).inventoryAmount > 0){
                    storeObj.gameList.get(i).inventoryAmount = storeObj.gameList.get(i).inventoryAmount - 1;
                }
                else if(storeObj.gameList.get(i).inventoryAmount == 0){
                    orderGame(i);
                }
                System.out.println(storeObj.gameList.get(i).name + " has " + storeObj.gameList.get(i).inventoryAmount + " games left in inventory");
                storeObj.damageContainer.add(storeObj.gameList.remove(i));
                // System.out.println("removed" + storeObj.damageContainer);

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
        for(int i = 0; i < numCustomers; i++){
            Random randGame = new Random();
            int soldGameAmt = randGame.nextInt(3);
            for(int j = 0; j < soldGameAmt; j++){
                Random randNum = new Random();
                int prob = randNum.nextInt(99);
                if(prob <= (20-i*2)){
                    storeObj.cashReg = storeObj.cashReg + storeObj.gameList.get(i).cost;
                    storeObj.gameList.get(i).inventoryAmount = storeObj.gameList.get(i).inventoryAmount - 1;
                    if(storeObj.gameList.get(i).inventoryAmount == 0){
                        orderGame(i);
                    }
                    game.numSold = game.numSold + 1;
                    System.out.println(cashierName + " sold a " + storeObj.gameList.get(i).name + " game to Customer " + i + " for $" + storeObj.gameList.get(i).cost);
                }
            }
        }
    }

    public void orderGame(int gameNum){
        System.out.println("Ordering new games.");
//        Random random = new Random();
//        int max = 12;
//        int min = 1;
//        int j = random.nextInt(max - min + 1) + min;
        storeObj.gameVals();
        String name = storeObj.gameList.get(gameNum).name;

        //if (storeObj.gameList.get(j).inventoryAmount == 0) {
            storeObj.gameList.get(gameNum).inventoryAmount = storeObj.gameList.get(gameNum).inventoryAmount + 3;
            storeObj.cashReg = storeObj.cashReg - (storeObj.gameList.get(gameNum).cost/2.0);
        //}
    }

    public void closeStore(String cashierName){
        System.out.println(cashierName + " is leaving and closed the store");
    }

    public void countMoney(){
        System.out.println("There are $" + storeObj.cashReg + " in the cash register.");

        if (storeObj.cashReg < 100){
            storeObj.cashReg = storeObj.cashReg + 1000;
            System.out.println("Money was added to the cash register.");
            //System.out.println("test: " + storeObj.cashReg );
        }
    }
}
