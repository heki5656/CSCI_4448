import java.util.*;
import java.util.List;
import java.lang.Math;
import java.util.Random;

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
        System.out.println(cashierName + " the cashier has arrived at the store on Day " + storeObj.day);
    }

    public void vacuumStore(){
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
                storeObj.damageContainer.add(storeObj.gameList.get(i));
                System.out.println("removed" + storeObj.damageContainer);

            }
        }

        if (cashierName == "Burt"){
            if (f < 0.60){
                Random random = new Random();
                int max = 12;
                int min = 1;
                int i = random.nextInt(max - min + 1) + min;
                stackGame();
                String name = storeObj.gameList.get(i).name;
                System.out.println(cashierName + " says that " + name + " is damaged.");
                //System.out.println("height" + storeObj.gameList.get(i).height);
                storeObj.gameList.get(i).inventoryAmount = storeObj.gameList.get(i).inventoryAmount - 1;
                System.out.println(storeObj.gameList.get(i).name + " has " + storeObj.gameList.get(i).inventoryAmount + " games left in inventory");
                storeObj.damageContainer.add(storeObj.gameList.remove(i));
                System.out.println("removed" + storeObj.damageContainer);

            }
        }


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
        stackGame();
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
                    game.numSold = game.numSold + 1;
                    System.out.println(cashierName + " sold a " + storeObj.gameList.get(i).name + " game to Customer " + i + " for $" + storeObj.gameList.get(i).cost);
                }
            }
        }
    }

    public static void orderGame(){
        System.out.println("Ordering new games.");
        
        System.out.println("Ordering new games.");
        Random random = new Random();
        int max = 12;
        int min = 1;
        int j = random.nextInt(max - min + 1) + min;
        storeObj.gameVals();
        String name = storeObj.gameList.get(j).name;

        if (storeObj.gameList.get(j).inventoryAmount == 0) {
            storeObj.gameList.get(j).inventoryAmount = storeObj.gameList.get(j).inventoryAmount + 3;
            storeObj.cashReg = storeObj.cashReg - (storeObj.gameList.get(j).cost/2.0);
        }


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
