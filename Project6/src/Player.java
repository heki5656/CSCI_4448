package Project6.src;

public class Player {
    String name;
    String farmName;
    double money;
    int seedInventory; //Maybe move to class Seed

    public Player(String name, String farmName){
        this.name = name;
        this.farmName = farmName;
        double money = 0;
        int seedInventory = 0; //Maybe move to class Seed
    }
}