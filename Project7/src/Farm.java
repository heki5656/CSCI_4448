package Project7.src;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;

public class Farm {
    Observer observer; //creating mayor observer object
    Fishing fishing = new Fishing();

    //just created a temp seed if needed
    //Seed seedTemp = new Seed("", "", 0, 0, 0, 0, 0);

    //TODO ALL COSTS, PRICES, AND STATUS NEED TO BE CHANGED FOR SEEDS
    //instantiate the seed objects
    //to harvest the crops, the status has to be equal to the qualityMax value
    Seed carrot = new Seed("carrot", "*", 16, 32, 0, 0, 6);
    Seed turnip = new Seed("turnip", "*", 10, 20, 0, 0, 4);
    Seed onion = new Seed("onion", "*", 16, 32, 0, 0, 6);
    Seed pumpkin = new Seed("pumpkin", "*", 12, 24, 0, 0, 5);
    Seed potato = new Seed("potato", "*", 10, 20, 0, 0, 6);

    //create the mayor (observer) ****COMMENTED OUT TO RUN ****
    //mayor = new Announcer("Mayor"); ****COMMENTED OUT TO RUN ****
    SingletonMayor singletonMayor = null;
    //mayor = singletonMayor.getMayor(); ****COMMENTED OUT TO RUN ****

    //WeatherSingleton weatherObj;
    String weather;

    public void Farm(){


    }
    //instantiate the weather object within the farm
    public void getWeather(String weath){
        weather = weath;
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
        player.generateMap();

        //print out the farmers name, and the farms name
        System.out.println("Welcome farmer " + player.name);
        System.out.println("You have arrived at " + player.farmName);

        //instantiate the player's seed array so that it isn't null
        player.seedInventory[0] = carrot;
        player.seedInventory[1] = turnip;
        player.seedInventory[2] = onion;
        player.seedInventory[3] = pumpkin;
        player.seedInventory[4] = potato;

        //Player starts with 6 turnip seeds
        player.seedInventory[1].inventory += 6;
        //player also starts with 3 standard fishing poles
        player.objectInventoryCount[0] += 3;
        //player starts with 100 g
        player.money += 100;

        return player;

    }

    public boolean checkPlayerInventory(Player player){
        int total = 0;
        for(int e = 0; e < 5; e++){
            total += player.seedInventory[e].inventory;
        }
        for(int i = 0; i < player.objectInventory.length; i++){
            total += player.objectInventoryCount[i];
        }
        if(total == 0)
            return true; //the player inventory is empty
        else
            return false;
    }


    public void morningReport(Player player){
        boolean emptyInventory = checkPlayerInventory(player);

        System.out.println("--------- " + player.name + "'s stats ---------");
        System.out.println("Money: " + player.money + "g");
        //System.out.println("Total inventory: " + player.seedInventory);

        //inventory only prints out the items the player has
        System.out.println(player.name + "'s inventory: ");
        //check to see if the player inventory is empty or not
        if(emptyInventory == true){
            System.out.println("Nothing in your bag!");
        }
        else{
            for(int e = 0; e < 5; e++){
                if(player.seedInventory[e].inventory != 0){
                    System.out.println(player.seedInventory[e].type + " seeds: " + player.seedInventory[e].inventory);
                }
            }
            for(int i = 0; i < player.objectInventory.length; i++){
                System.out.println(player.objectInventory[i] + ": " + player.objectInventoryCount[i]);
            }
        }

        System.out.println("Weather: " + weather);
        System.out.println("Farm Map: ");
        for(int row = 0; row < 10; row ++){
            for(int col = 0; col < 30; col++){
                System.out.print(player.FarmMap[row][col].seedImage);
            }
            System.out.println();
        }
    }

    public int availableActions(int numActions){
        //create a Scanner object
        Scanner myObj = new Scanner(System.in);

        //print out the number of actions player has used
        System.out.println("Actions for the day: " + numActions + "/3");
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
        System.out.println("1. 3 Carrot seeds");
        System.out.println("2. 3 Turnip seeds");
        System.out.println("3. 3 Onion seeds");
        System.out.println("4. 3 Pumpkin seeds");
        System.out.println("5. 3 Potato seeds");
        System.out.println("6. Exit seed shop");

        //store the players choice
        int choice = myObj.nextInt();

        //check to make sure user has enough money for carrot seeds
        if (choice == 1){
            if (player.money - 3*carrot.cost < 0){
                System.out.println("You do not have enough money to buy carrot seeds.");
                System.out.println("You have: " + player.money + "g in your pocket.");
                System.out.println("Carrot seeds cost: " + carrot.cost + "g per seed.");
                return -1;
            }

            else{
                //subtract cost of seeds
                carrot.cost =
                player.money -= 3*carrot.cost;
                //increase inventory
                carrot.inventory += 3;
            }
        }

        //check to make sure user has enough money for turnip seeds
        else if (choice == 2){
            if (player.money - 3*turnip.cost < 0){
                System.out.println("You do not have enough money to buy turnip seeds.");
                System.out.println("You have: " + player.money + "g in your pocket.");
                System.out.println("Turnip seeds cost: " + turnip.cost + "g per seed.");
                return -1;
            }

            else{
                //subtract cost of seeds
                player.money -= 3*turnip.cost;
                //increase inventory
                turnip.inventory += 3;
            }

        }

        //check to make sure user has enough money for onion seeds
        else if (choice == 3){
            if (player.money - 3*onion.cost < 0){
                System.out.println("You do not have enough money to buy onion seeds.");
                System.out.println("You have: " + player.money + "g in your pocket.");
                System.out.println("Onion seeds cost: " + onion.cost + "g per seed.");
                return -1;
            }

            else{
                //subtract cost of seeds
                player.money -= 3*onion.cost;
                //increase inventory
                onion.inventory += 3;
            }
        }

        //check to make sure user has enough money for pumpkin seeds
        else if (choice == 4){
            if (player.money - 3*pumpkin.cost < 0){
                System.out.println("You do not have enough money to buy pumpkin seeds.");
                System.out.println("You have: " + player.money + "g in your pocket.");
                System.out.println("Pumpkin seeds cost: " + pumpkin.cost + "g per seed.");
                return -1;
            }

            else{
                //subtract cost of seeds
                player.money -= 3*pumpkin.cost;
                //increase inventory
                pumpkin.inventory += 3;
            }
        }

        //check to make sure user has enough money for potato seeds
        else if (choice == 5){
            if (player.money - 3*potato.cost < 0){
                System.out.println("You do not have enough money to buy potato seeds.");
                System.out.println("You have: " + player.money + "g in your pocket.");
                System.out.println("Potato seeds cost: " + potato.cost + "g per seed.");
                return -1;
            }

            else{
                //subtract cost of seeds
                player.money -= 3*potato.cost;
                //increase inventory
                potato.inventory += 3;
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

    public void startADay(Player player, seedStore seedStoreObj, cropStore cropStoreObj, generalStore generalStoreObj){
        int numberOfActions = 0;

        //create a variable that keeps track of how many actions player is allowed to do in a day

        //get the morning report
        morningReport(player);

        //weather affects on the day
        //weatherInfluence weatherInflObj = new weatherInfluence(seedTemp);

        //adjust the crop qualities according to weather to start the day off
        for(int row = 0; row < 10; row++){
            for(int col = 0; col < 30; col++){
                Seed seedTemp = new Seed("", "", 0, 0, 0, 0, 0);
                seedTemp = player.FarmMap[row][col];
                weatherInfluence weatherInflObj = new weatherInfluence(seedTemp);
                if(weather == "freezing"){
                    //weatherInfluence weatherInflObj = new weatherInfluence(seedTemp);
                    seedTemp = weatherInflObj.booSnow(seedTemp);
                }
                else if(weather == "rainy"){
                    seedTemp = weatherInflObj.watered(seedTemp);
                }
                else if(weather == "sunny"){
                    seedTemp = weatherInflObj.yaySun(seedTemp);
                }
                player.FarmMap[row][col] = seedTemp;
            }
        }

        //allow player to do the number of actions for the day
        while (numberOfActions < 3){

            //pick from available actions, and store user input in choice
            int choice = availableActions(numberOfActions);

            //player wants to go to plaza
            if (choice == 1){
                System.out.println("Welcome to the plaza!");
                int plazaOption = plazaOptions();

                //add one to numberOfActions
                numberOfActions++;

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
                //TODO: edit these above print outs later on

                System.out.println(player.name + "'s inventory: ");
                for(int s = 0; s < 5; s++){
                    System.out.println(player.seedInventory[s].type + " " + player.seedInventory[s].inventory);
                }
                //options to plant or tend to the seeds
                System.out.println("Please enter what you would like to do on your farm:");
                System.out.println("1. Water your field and harvest fully grown crops");
                System.out.println("2. Plant seeds from your inventory");

                Scanner myObj = new Scanner(System.in);
                int FarmChoice = myObj.nextInt();

                if(FarmChoice == 1){
                    for(int row = 0; row < 10; row ++){
                        for(int col = 0; col < 30; col++){
                            if(player.FarmMap[row][col].growthProgress == player.FarmMap[row][col].growthTotal){
                                for(int i = 0; i < player.seedInventory.length; i++){

                                }
                            }
                        }
                    }
                }
                if(FarmChoice == 1 && weather != "rainy"){
                    //water the plants
                    for(int row = 0; row < 10; row++){
                        for(int col = 0; col < 30; col++){
                            Seed seedTemp = new Seed("", "", 0, 0, 0, 0, 0);
                            seedTemp = player.FarmMap[row][col];
                            weatherInfluence weatherInflObj = new weatherInfluence(seedTemp);
                            seedTemp = weatherInflObj.watered(seedTemp);
                            player.FarmMap[row][col] = seedTemp;
                        }
                    }
                    System.out.println(player.name + "'s crops have been watered for the day!");
                    //add one to numberOfActions
                    numberOfActions++;
                }
                if(FarmChoice == 1 && weather == "rainy"){
                    System.out.println(player.name + "'s crops have already been watered for the day by natural causes! Sadly, you wasted an action.");
                    //add one to numberOfActions
                    numberOfActions++;
                }
                else if(FarmChoice == 2){
                    for(int row = 0; row < 10; row++){
                        for(int col = 0; col < 30; col++){
                            System.out.print(player.FarmMap[row][col].seedImage);
                        }
                        System.out.println("");

                        //add one to numberOfActions
                        numberOfActions++;

                    }
                    //planting all the seeds randomly
                    int totalSeeds = 0;
                    for(int k = 0; k < 5; k++){
                        totalSeeds = totalSeeds + player.seedInventory[k].inventory;
                    }
                    if(totalSeeds == 0){
                        System.out.println("You have no seeds! :(");
                    }
                    else{
                        for(int s = 0; s < 5; s++){
                            //totalSeeds = totalSeeds + player.seedInventory[s].inventory;

                            //create a variable to hold the inventory
                            int inventory = player.seedInventory[s].inventory;

                            for(int j = 0; j < inventory; j++){
                                boolean emptySlot = false;
                                int random_row = 0;
                                int random_col = 0;
                                while(emptySlot == false){
                                    Random rand = new Random();
                                    random_row = rand.nextInt((9 - 0) + 1) + 0;
                                    random_col= rand.nextInt((29 - 0) + 1) + 0;

                                    if(player.FarmMap[random_row][random_col].seedImage == "~"){
                                        emptySlot = true;
                                    }
                                }
                                //now the actual planting part
                                player.FarmMap[random_row][random_col] = player.seedInventory[s];
                                player.seedInventory[s].inventory --;
                            }
                        }
                    }
                    //print out the map after the seeds have been planted
                    for(int row = 0; row < 10; row ++){
                        for(int col = 0; col < 30; col++){
                            System.out.print(player.FarmMap[row][col].seedImage);
                        }
                        System.out.println();
                    }
                }
            }

            //player wants to go fishing
            else if (choice == 3){
                //fishing pole existing check
                int playerFishingPoles = player.objectInventoryCount[0] + player.objectInventoryCount[1] + player.objectInventoryCount[2];
                //get the player and weather objects to fishing
                fishing.getPlayer(player);
                fishing.getWeather(weather);

                System.out.println("Player wants to go fishing at the pond");
                boolean froze = fishing.isFrozen();

                if (froze == true){
                    System.out.println("Pond is frozen - come back to fish when it's warmer.");
                }
                else if(playerFishingPoles == 0){
                    System.out.println("You have no fishing poles :( come back when you buy some!");
                }
                else{
                    //so that the inventory of the player updates
                    player = fishing.reelInCatch();
                    //add one to numberOfActions
                    numberOfActions++;
                }
            }
        }
        System.out.println("Actions for the day: " + numberOfActions + "/3");
        try {
            Thread.sleep(500);
            System.out.println("Farmer " + player.name + " is tired, and going to bed.");
            Thread.sleep(300);
            System.out.println("ZZZZZZZZZZZZZZZZ");
            Thread.sleep(300);
            System.out.println("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
            Thread.sleep(300);
            System.out.println("ZZZZZZZZZZZZZZZZ");
            Thread.sleep(300);
            System.out.println("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
            Thread.sleep(300);
            System.out.println("ZZZZZZZZZZZZZZZZ");
            Thread.sleep(300);
            System.out.println("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
            Thread.sleep(300);
            System.out.println("ZZZZZZZZZZZZZZZZ");
            Thread.sleep(300);
            System.out.println("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
            Thread.sleep(300);

        } catch (Exception ex) {
            // TODO Auto-generated catch block
            ex.printStackTrace();
        }


    }

}
