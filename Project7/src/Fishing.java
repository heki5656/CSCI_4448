package Project7.src;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Date;

public class Fishing{
    String weather;
    Player playerObj = null;
    //Farm farm = new Farm();
    //Player player = new Player("Mary", "Mary's Farm");
    int level;
    boolean frozenStatus = false;

    public void getPlayer(Player playerInput){
        playerObj = playerInput;
    }

    public void getWeather(String weatherInput){
        weather = weatherInput;
    }

    public boolean isFrozen(){
        if (weather == "freezing"){
            frozenStatus = true;
            System.out.println("Pond is frozen - come back to fish when it's warmer.");
            return frozenStatus;
        }
        System.out.println("The pond is not frozen today!");
        frozenStatus = false;
        return frozenStatus;
    }

    public Player reelInCatch(){
        Scanner upgradeObj = new Scanner(System.in);

        System.out.println("Which fishing pole would you like to use:");
        System.out.println("1. Standard" + playerObj.objectInventoryCount[0]); //cost: 5g
        System.out.println("2. Advanced (takes 1.4x time to catch something)" + playerObj.objectInventoryCount[1]); //cost: 15g
        System.out.println("3. Deluxe (takes 1.8x time to catch something)" + playerObj.objectInventoryCount[2]); //cost: 30g
        //only shows what fishing poles they have

        //store the players selection
        int select = upgradeObj.nextInt();

        // if player selects standard pole they don't lose money since they are given the standard fishing pole by default
        if (select == 1 && playerObj.objectInventoryCount[0] !=0){

            // probability of catching a fish
            double fishProbability = Utility.rndFromRange(1, 100);

            if (fishProbability < 25){
                try {
                    Thread.sleep(5000);
                    System.out.println("Darn -- you reeled in trash using the standard pole, but good news, people like trash so you can sell it for 1g!");
                    //player.money += 1; // increasing money count by 1g since player caught trash
                    playerObj.objectInventoryCount[3] ++;
                }
                catch(InterruptedException ex)
                {
                    ex.printStackTrace();
                }
            }

            if (fishProbability <= 75 && fishProbability >= 25){
                try{
                    Thread.sleep(5000);
                    System.out.println("Nice work! You caught a common fish using the standard pole. You can sell this for 50g.");
                    //playerObj.money += 50; // increasing money count by 50g since player caught a common fish
                    playerObj.objectInventoryCount[4] ++;
                }
                catch(InterruptedException ex)
                {
                    ex.printStackTrace();
                }

            }

            if (fishProbability > 75){
                try{
                    Thread.sleep(5000);
                    System.out.println("Bravo! You caught a rare fish using the standard pole. It's very hard to catch those. You can sell it for 100g.");
                    //playerObj.money += 100; // increasing money count by 100g since player caught a rare fish
                    playerObj.objectInventoryCount[5] ++;
                }
                catch(InterruptedException ex)
                {
                    ex.printStackTrace();
                }
            }

        }

        // if player upgrades to advanced pole they have to withdraw some money from their account to pay for it
        else if (select == 2 && playerObj.objectInventoryCount[1] !=0){
            //player.money -= 30;

            // probability of catching a fish
            double fishProbability = Utility.rndFromRange(1, 100);

            if (fishProbability <= 15){
                try{
                    Thread.sleep(7000);
                    System.out.println("Darn -- you reeled in trash using the advanced pole, but good news, people like trash so you can sell it for 1g!");
                    //playerObj.money += 1; // increasing money count by 1g since player caught trash
                    playerObj.objectInventoryCount[3] ++;
                }
                catch(InterruptedException ex) {
                    ex.printStackTrace();
                }
            }

            if (fishProbability > 15 && fishProbability <= 65){
                try{
                    Thread.sleep(7000);
                    System.out.println("Nice work! You caught a common fish using the advanced pole. You can sell this for 50g.");
                    //playerObj.money += 10; // increasing money count by 10g since player caught a common fish
                    playerObj.objectInventoryCount[4] ++;
                }
                catch(InterruptedException ex)
                {
                    ex.printStackTrace();
                }

            }

            if (fishProbability > 65){
                try{
                    Thread.sleep(7000);
                    System.out.println("Bravo! You caught a rare fish using the advanced pole. It's very hard to catch those. You can sell it for 100g.");
                    //playerObj.money += 30; // increasing money count by 30g since player caught a rare fish
                    playerObj.objectInventoryCount[5] ++;
                }
                catch(InterruptedException ex)
                {
                    ex.printStackTrace();
                }

            }

        }

        // if player upgrades to deluxe pole they have to withdraw some money from their account to pay for it
        else if (select == 3 && playerObj.objectInventoryCount[2] !=0){
            //playerObj.money -= 35;

            // probability of catching a fish
            double fishProbability = Utility.rndFromRange(1, 100);

            if (fishProbability <= 5){
                try{
                    Thread.sleep(9000);
                    System.out.println("Darn -- you reeled in trash using the deluxe pole, but good news, people like trash so you can sell it for 1g!");
                    //player.money += 1; // increasing money count by 1g since player caught trash
                    playerObj.objectInventoryCount[3] ++;
                }
                catch(InterruptedException ex)
                {
                    ex.printStackTrace();
                }

            }

            if (fishProbability <= 60 && fishProbability > 5){
                try{
                    Thread.sleep(9000);
                    System.out.println("Nice work! You caught a common fish using the deluxe pole. You can sell this for 50g.");
                    //player.money += 10; // increasing money count by 10g since player caught a common fish
                    playerObj.objectInventoryCount[4] ++;
                }
                catch(InterruptedException ex)
                {
                    ex.printStackTrace();
                }

            }

            if (fishProbability > 60){
                try{
                    Thread.sleep(9000);
                    System.out.println("Bravo! You caught a rare fish using the deluxe pole. It's very hard to catch those. You can sell it for 100g.");
                    //player.money += 30; // increasing money count by 30g since player caught a rare fish
                    playerObj.objectInventoryCount[5] ++;
                }
                catch(InterruptedException ex)
                {
                    ex.printStackTrace();
                }
            }
        }

        else{
            while (select < 1 || select > 3){
                System.out.println("Invalid input. Please select a number between 1 and 3 from the following options:");
                System.out.println("Which fishing pole would you like to upgrade to");
                System.out.println("1. Standard");
                System.out.println("2. Advanced");
                System.out.println("3. Deluxe");
                select = upgradeObj.nextInt();
            }
        }
        return playerObj;
    }
}
