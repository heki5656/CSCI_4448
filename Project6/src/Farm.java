package Project6.src;
import java.util.Scanner;

public class Farm {
    String map = "[.............]"; //TODO NEED TO IMPLEMENT MAP

    public Farm(){
        //create the mayor (observer)
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
        System.out.println("Farm Map: " + map);
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
                System.out.println("Player wants to go to the plaza");
            }

            //player wants to tend to their farm
            else if (choice == 2){
                System.out.println("Player wants to tend to their farm");
            }

            //player wants to go fishing
            else if (choice == 3){
                System.out.println("Player want to go fishing at the pond");
            }
        }

    }


}