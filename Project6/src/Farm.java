package Project6.src;
import java.util.Scanner;

public class Farm {

    public Farm(){
        //create the mayor (observer)

        //create the farm map


    }

    //set up the players farm
    public void firstDay(){
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object

        System.out.println("Welcome to Stardew Horizon Simulator.");

        System.out.println("Enter your farmers name: ");
        String name = myObj.nextLine();

        System.out.println("Enter your farm name: ");
        String farmName = myObj.nextLine();

        //create a new player object
        Player player = new Player(name, farmName);

        System.out.println("Welcome farmer " + player.name);
        System.out.println("You have arrived at " + player.farmName);

    }


}