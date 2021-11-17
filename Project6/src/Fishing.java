package Project6.src;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Date;

public class Fishing extends WeatherContext{
    WeatherContext weatherContext;
    Player player;
    int level;
    boolean frozenStatus;

    public boolean isFrozen(){
        if (weatherContext.randomWeatherGenerator(weather) == "freezing"){
            frozenStatus = true;
            System.out.println("Pond is frozen - come back to fish when it's warmer.");
            return frozenStatus;
        }
        return frozenStatus;
    }

    public void reelInCatch(){
        Scanner upgradeObj = new Scanner(System.in);

        System.out.println("Which fishing pole would you like to upgrade to");
        System.out.println("1. Standard");
        System.out.println("2. Advanced");
        System.out.println("3. Deluxe");

        //store the players selection
        int select = upgradeObj.nextInt();

        // if player selects standard pole they don't lose money since they are given the standard fishing pole by default
        if (select == 1){

            // probability of catching a fish
            double fishProbability = Utility.rndFromRange(1, 100);

            if (fishProbability <= 25){
                try {
                    Thread.sleep(7000);
                    System.out.println("Darn -- you reeled in trash using the standard pole, but good news, people like trash so you can sell it for 1g!");
                    //player.money += 1; // increasing money count by 1g since player caught trash
                }
                catch(InterruptedException ex)
                {
                    ex.printStackTrace();
                }
            }

            if (fishProbability <= 50 && fishProbability >= 25){
                try{
                    Thread.sleep(7000);
                    System.out.println("Nice work! You caught a common fish using the standard pole. You can sell this for 10g.");
                    player.money += 10; // increasing money count by 10g since player caught a common fish
                }
                catch(InterruptedException ex)
                {
                    ex.printStackTrace();
                }

            }

            if (fishProbability >= 50){
                try{
                    Thread.sleep(7000);
                    System.out.println("Bravo! You caught a rare fish using the standard pole. It's very hard to catch those. You can sell it for 30g.");
                    player.money += 30; // increasing money count by 30g since player caught a rare fish
                }
                catch(InterruptedException ex)
                {
                    ex.printStackTrace();
                }
            }

        }

        // if player upgrades to advanced pole they have to withdraw some money from their account to pay for it
        else if (select == 2){
            //player.money -= 20;

            // probability of catching a fish
            double fishProbability = Utility.rndFromRange(1, 100);

            if (fishProbability <= 40){
                try{
                    Thread.sleep(7000);
                    System.out.println("Darn -- you reeled in trash using the advanced pole, but good news, people like trash so you can sell it for 1g!");
                    player.money += 1; // increasing money count by 1g since player caught trash
                }
                catch(InterruptedException ex) {
                    ex.printStackTrace();
                }
            }

            if (fishProbability >= 40 && fishProbability <= 75){
                try{
                    Thread.sleep(7000);
                    System.out.println("Nice work! You caught a common fish using the advanced pole. You can sell this for 10g.");
                    player.money += 10; // increasing money count by 10g since player caught a common fish
                }
                catch(InterruptedException ex)
                {
                    ex.printStackTrace();
                }

            }

            if (fishProbability >= 75){
                try{
                    Thread.sleep(7000);
                    System.out.println("Bravo! You caught a rare fish using the advanced pole. It's very hard to catch those. You can sell it for 30g.");
                    player.money += 30; // increasing money count by 30g since player caught a rare fish
                }
                catch(InterruptedException ex)
                {
                    ex.printStackTrace();
                }

            }

        }

        // if player upgrades to deluxe pole they have to withdraw some money from their account to pay for it
        else if (select == 3){
            //player.money -= 35;

            // probability of catching a fish
            double fishProbability = Utility.rndFromRange(1, 100);

            if (fishProbability <= 40){
                try{
                    Thread.sleep(7000);
                    System.out.println("Darn -- you reeled in trash using the deluxe pole, but good news, people like trash so you can sell it for 1g!");
                    player.money += 1; // increasing money count by 1g since player caught trash
                }
                catch(InterruptedException ex)
                {
                    ex.printStackTrace();
                }

            }

            if (fishProbability <= 75 && fishProbability >= 40){
                try{
                    Thread.sleep(7000);
                    System.out.println("Nice work! You caught a common fish using the deluxe pole. You can sell this for 10g.");
                    player.money += 10; // increasing money count by 10g since player caught a common fish
                }
                catch(InterruptedException ex)
                {
                    ex.printStackTrace();
                }

            }

            if (fishProbability <= 75){
                try{
                    Thread.sleep(7000);
                    System.out.println("Bravo! You caught a rare fish using the deluxe pole. It's very hard to catch those. You can sell it for 30g.");
                    player.money += 30; // increasing money count by 30g since player caught a rare fish
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

    }
}
