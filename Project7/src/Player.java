package Project7.src;
import java.util.*;

// Seed carrot = new Seed("carrot", "*", 16, 30, 0/8);
// Seed turnip = new Seed("turnip", "*", 10, 20, 0/4);
// Seed onion = new Seed("onion", "*", 16, 30, 0/8);
// Seed pumpkin = new Seed("pumpkin", "*", 12, 25, 0/6);
// Seed potato = new Seed("potato", "*", 10, 20, 0/4);

public class Player {
    String name;
    String farmName;
    int money;
    //int seedInventory; //Maybe move to class Seed
    //player has an array to store all of their seeds
    Seed[] seedInventory = new Seed[5];
    Seed [][]FarmMap = new Seed[10][30];

    //seed generator
    SeedFactory seedCreatorObj = new SeedFactory();

    //the name of the objects the player has
    String[] objectInventory = new String[]{"standard pole", "advanced pole", "deluxe pole", "trash", "common fish", "rare fish",
            "carrot", "turnip", "onion", "pumpkin", "tomato"};
    int[] objectInventoryCount = new int[objectInventory.length + 1];
    int[] objectInventoryPrice = new int []{5, 15, 30, 1, 50, 100, 32, 20, 32, 24, 20};

    public Player(String name, String farmName){
        this.name = name;
        this.farmName = farmName;
        int money = 0;
        //int seedInventory = 0; //Maybe move to class Seed
    }

    public void generateMap(){
        //generating the initial map
        //Seed initialSeed = new Seed("", "~", 0, 0, 0, 0, 0);
        for(int row = 0; row < 10; row++){
            for(int col = 0; col < 30; col++){
                FarmMap[row][col] = seedCreatorObj.createSeed("empty");
            }
        }
    }

}
