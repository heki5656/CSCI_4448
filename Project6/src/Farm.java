package Project6.src;
import java.util.Scanner;
import java.util.ArrayList;

public class Farm {
    String FarmMap = new String[30][20];
    //generating the initial map
    for(int row = 0; row < 30; row ++){
        for(int col = 0; col < 20; col++){
            FarmMap[row][col] = "/";
        }
    }

    Observer observer; //creating mayor observer object


    //TODO ALL COSTS, PRICES, AND STATUS NEED TO BE CHANGED FOR SEEDS
    //instantiate the seed objects
    Seed carrot = new Seed("carrot", 20, 30, 0/10);
    Seed turnip = new Seed("turnip", 20, 30, 0/10);
    Seed onion = new Seed("onion", 20, 30, 0/10);
    Seed pumpkin = new Seed("pumpkin", 20, 30, 0/10);
    Seed potato = new Seed("potato", 20, 30, 0/10);

    

    public void Farm(){
        //create the mayor (observer) ****COMMENTED OUT TO RUN ****
        //mayor = new Announcer("Mayor"); ****COMMENTED OUT TO RUN ****
        SingletonMayor singletonMayor = null;
        //mayor = singletonMayor.getMayor(); ****COMMENTED OUT TO RUN ****

    }

    //set up the players farm
    public Player setUp(){

        //create a scanner object
        Scanner myObj = new Scanner(System.in);

        System.out.println("Welcome to Stardew Horizon Simulator.");

        //get the players name
        System.out.println("Enter your farmers name: ");
        String name = myObj.nextLine();

        //get the players farm name
        System.out.println("Enter your farm name: ");
        String farmName = myObj.nextLine();

        //create a new player object
        Player player = new Player(name, farmName);

        //print out the farmers name, and the farms name
        System.out.println("Welcome farmer " + player.name);
        System.out.println("You have arrived at " + player.farmName);

        return player;

    }


    public void morningReport(Player player){
        System.out.println("--------- " + player.name + "'s stats ---------");
        System.out.println("Money: " + player.money + "g");
        System.out.println("Total inventory: " + player.seedInventory);
        System.out.println("Weather: "); //TODO NEED TO IMPLEMENT WEATHER
        System.out.println("Farm Map: ");
        for(int row = 0; row < 30; row ++){
            for(int col = 0; col < 20; col++){
                System.out.print(FarmMap[row][col]);
            }
            System.out.println();
        }
    }

    public int availableActions(){
        //create a Scanner object
        Scanner myObj = new Scanner(System.in);

        //display the available action choices
        System.out.println("Available actions (please enter the # of the action you would like to select:)");
        System.out.println("1. Go to the plaza");
        System.out.println("2. Tend to your farm");
        System.out.println("3. Go to a pond and fish");

        //store the players choice
        int choice = myObj.nextInt();

        //loop until we get valid input
        while (choice < 1 || choice > 3){
            System.out.println("Invalid input. Please select a number between 1 and 3 from the following options:");
            System.out.println("1. Go to the plaza");
            System.out.println("2. Tend to your farm");
            System.out.println("3. Go to a pond and fish");
            choice = myObj.nextInt();
        }

        return choice;

    }

    public int plazaOptions(){
        //TODO NEED TO IMPLEMENT WEATHER INFLUENCE 

        //create a Scanner object
        Scanner myObj = new Scanner(System.in);

        //display the available plaza choices
        System.out.println("Plaza actions (please enter the # of the action you would like to select:)");
        System.out.println("1. Visit the crop shop");
        System.out.println("2. Visit the seed shop");
        System.out.println("3. Visit the general shop");

        //store the players choice
        int choice = myObj.nextInt();

        //loop until we get valid input
        while (choice < 1 || choice > 3){
            System.out.println("Invalid input. Please select a number between 1 and 3 from the following options:");
            System.out.println("Plaza actions (please enter the # of the action you would like to select:)");
            System.out.println("1. Visit the crop shop");
            System.out.println("2. Visit the seed shop");
            System.out.println("3. Visit the general shop");
            choice = myObj.nextInt();
        }

        return choice;
    }

    public int seedStoreOptions(Player player){
        //create a Scanner object
        Scanner myObj = new Scanner(System.in);

        //store whether the user can pay for the item they want
        boolean cost = true;

        //display the available seed store choices
        System.out.println("Seeds in stock (please enter the # of the seed you would like to buy:)");
        System.out.println("1. Carrot");
        System.out.println("2. Turnip");
        System.out.println("3. Onion");
        System.out.println("4. Pumpkin");
        System.out.println("5. Potato");
        System.out.println("6. Exit seed shop");

        //store the players choice
        int choice = myObj.nextInt();

        //check to make sure user has enough money for carrot seeds
        if (choice == 1){
            if (player.money - carrot.cost < 0){
                System.out.println("You do not have enough money to buy carrot seeds.");
                System.out.println("You have: " + player.money + "g in your pocket.");
                System.out.println("Carrot seeds cost: " + carrot.cost + "g per packet.");
                return -1;
            }

            else{
                //subtract cost of seeds
                player.money -= carrot.cost;
                //increase inventory
                carrot.inventory += 1;
            }
        }

        //check to make sure user has enough money for turnip seeds
        else if (choice == 2){
            if (player.money - turnip.cost < 0){
                System.out.println("You do not have enough money to buy turnip seeds.");
                System.out.println("You have: " + player.money + "g in your pocket.");
                System.out.println("Turnip seeds cost: " + turnip.cost + "g per packet.");
                return -1;
            }

            else{
                //subtract cost of seeds
                player.money -= turnip.cost;
                //increase inventory
                turnip.inventory += 1;
            }

        }

        //check to make sure user has enough money for onion seeds
        else if (choice == 3){
            if (player.money - onion.cost < 0){
                System.out.println("You do not have enough money to buy onion seeds.");
                System.out.println("You have: " + player.money + "g in your pocket.");
                System.out.println("Onion seeds cost: " + onion.cost + "g per packet.");
                return -1;
            }

            else{
                //subtract cost of seeds
                player.money -= onion.cost;
                //increase inventory
                onion.inventory += 1;
            }
        }

        //check to make sure user has enough money for pumpkin seeds
        else if (choice == 4){
            if (player.money - pumpkin.cost < 0){
                System.out.println("You do not have enough money to buy pumpkin seeds.");
                System.out.println("You have: " + player.money + "g in your pocket.");
                System.out.println("Pumpkin seeds cost: " + pumpkin.cost + "g per packet.");
                return -1;
            }

            else{
                //subtract cost of seeds
                player.money -= pumpkin.cost;
                //increase inventory
                pumpkin.inventory += 1;
            }
        }

        //check to make sure user has enough money for potato seeds
        else if (choice == 5){
            if (player.money - potato.cost < 0){
                System.out.println("You do not have enough money to buy potato seeds.");
                System.out.println("You have: " + player.money + "g in your pocket.");
                System.out.println("Potato seeds cost: " + potato.cost + "g per packet.");
                return -1;
            }

            else{
                //subtract cost of seeds
                player.money -= potato.cost;
                //increase inventory
                potato.inventory += 1;
            }
        }

        //loop until we get valid input
        while (choice < 1 || choice > 6){

            //check if user wants to exit seed shop
            if (choice == 6){
                return choice;
            }
            
            System.out.println("Invalid input. Please select a number between 1 and 3 from the following options:");
            System.out.println("Seeds in stock (please enter the # of the seed you would like to buy:)");
            System.out.println("1. Carrot");
            System.out.println("2. Turnip");
            System.out.println("3. Onion");
            System.out.println("4. Pumpkin");
            System.out.println("5. Potato");
            System.out.println("6. Exit seed shop");
            choice = myObj.nextInt();
        }
        return choice;
    }


    public void startADay(Player player){
        //create a variable that keeps track of how many actions player is allowed to do in a day
        int numberOfActions = 3;

        //get the morning report
        morningReport(player);

        //allow player to do the number of actions for the day
        for(int i = 0; i < numberOfActions; i++){

            //pick from available actions, and store user input in choice
            int choice = availableActions();

            //player wants to go to plaza
            if (choice == 1){
                System.out.println("Welcome to the plaza!");
                int plazaOption = plazaOptions();

                //crop shop 
                if (plazaOption == 1){
                    //TODO
                    System.out.println("Welcome to the crop shop.");
                }

                //seed shop
                else if (plazaOption == 2){
                    System.out.println("Welcome to the seed shop.");

                    //store player option 
                    int seedStoreOption = 0;

                    //keep going to the seed store until user wants to exit
                    while (seedStoreOption != 6){
                        seedStoreOption = seedStoreOptions(player);
                    }

                }

                //general shop
                else if (plazaOption == 3){
                    //TODO
                    System.out.println("Welcome to the general shop.");
                }

            }

            //player wants to tend to their farm
            else if (choice == 2){
                System.out.println("The mayor has a message for player");
                //mayor.Announcement("Add 10g to your inventory for tending your farm. Every day that you complete farm work, you will earn 10g.");
                System.out.println("Player wants to tend to their farm");
            }

            //player wants to go fishing
            else if (choice == 3){
                System.out.println("Player want to go fishing at the pond");
            }
        }

    }


}
