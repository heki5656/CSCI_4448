package Project6.src;

public class Player {
    String name;
    String farmName;
    double money;
    int seedInventory; //Maybe move to class Seed
    Seed [][]FarmMap = new Seed[10][30];

    public Player(String name, String farmName){
        this.name = name;
        this.farmName = farmName;
        double money = 0;
        int seedInventory = 0; //Maybe move to class Seed
    }

    public void generateMap(){
        //generating the initial map
        Seed initialSeed = new Seed("", "~", 0.00, 0.00, 0);
        for(int row = 0; row < 10; row++){
            for(int col = 0; col < 30; col++){
                FarmMap[row][col] = initialSeed;
            }
        }
    }

}