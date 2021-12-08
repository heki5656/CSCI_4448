package Project7.src;

/*
    Seed carrot = new Seed("carrot", "*", 16, 32, 0, 0, 6);
    Seed turnip = new Seed("turnip", "*", 10, 20, 0, 0, 4);
    Seed onion = new Seed("onion", "*", 16, 32, 0, 0, 6);
    Seed pumpkin = new Seed("pumpkin", "*", 12, 24, 0, 0, 5);
    Seed potato = new Seed("potato", "*", 10, 20, 0, 0, 6);
 */

public class Seed {
    String type; //the type of seed
    String seedImage;
    int cost; //the cost of the seed
    int sell_price; //how much the seed sells for after it's harvested
    int inventory; //how much the player has in their inventory of this type of seed
    int growthProgress;
    //double status; //the status of the seed, the fraction of days it has/needs to grow
    int growthTotal; // the total growth time

    // String type, String seedImage, int cost, int sell_price, int inventory, int growthProgress, int growthTotal
    public Seed(){

    }

}

class emptySeed extends Seed{
    public emptySeed(){
        super();
        type = ""; //the type of seed
        seedImage = "~";
        cost = 0; //the cost of the seed
        sell_price = 0; //how much the seed sells for after it's harvested
        inventory = 0; //how much the player has in their inventory of this type of seed
        growthProgress = 0;
        //double status; //the status of the seed, the fraction of days it has/needs to grow
        growthTotal = 0; //the total growth time
    }
}

//Seed carrot = new Seed("carrot", "*", 16, 32, 0, 0, 6);
class carrotSeed extends Seed {
    public carrotSeed() {
        super();
        type = "carrot"; //the type of seed
        seedImage = "*";
        cost = 16; //the cost of the seed
        sell_price = 32; //how much the seed sells for after it's harvested
        inventory = 0; //how much the player has in their inventory of this type of seed
        growthProgress = 0;
        //double status; //the status of the seed, the fraction of days it has/needs to grow
        growthTotal = 6; //the total growth time
    }
}

//Seed turnip = new Seed("turnip", "*", 10, 20, 0, 0, 4);
class turnipSeed extends Seed {
    public turnipSeed() {
        super();
        type = "turnip"; //the type of seed
        seedImage = "*";
        cost = 10; //the cost of the seed
        sell_price = 20; //how much the seed sells for after it's harvested
        inventory = 0; //how much the player has in their inventory of this type of seed
        growthProgress = 0;
        //double status; //the status of the seed, the fraction of days it has/needs to grow
        growthTotal = 4; //the total growth time
    }
}

//Seed onion = new Seed("onion", "*", 16, 32, 0, 0, 6);
class onionSeed extends Seed {
    public onionSeed() {
        super();
        type = "onion"; //the type of seed
        seedImage = "*";
        cost = 16; //the cost of the seed
        sell_price = 32; //how much the seed sells for after it's harvested
        inventory = 0; //how much the player has in their inventory of this type of seed
        growthProgress = 0;
        //double status; //the status of the seed, the fraction of days it has/needs to grow
        growthTotal = 6; //the total growth time
    }
}

//Seed pumpkin = new Seed("pumpkin", "*", 12, 24, 0, 0, 5);
class pumpkinSeed extends Seed {
    public pumpkinSeed() {
        super();
        type = "pumpkin"; //the type of seed
        seedImage = "*";
        cost = 12; //the cost of the seed
        sell_price = 24; //how much the seed sells for after it's harvested
        inventory = 0; //how much the player has in their inventory of this type of seed
        growthProgress = 0;
        //double status; //the status of the seed, the fraction of days it has/needs to grow
        growthTotal = 5; //the total growth time
    }
}

//Seed potato = new Seed("potato", "*", 10, 20, 0, 0, 6);
class potatoSeed extends Seed {
    public potatoSeed() {
        super();
        type = "potato"; //the type of seed
        seedImage = "*";
        cost = 10; //the cost of the seed
        sell_price = 20; //how much the seed sells for after it's harvested
        inventory = 0; //how much the player has in their inventory of this type of seed
        growthProgress = 0;
        //double status; //the status of the seed, the fraction of days it has/needs to grow
        growthTotal = 6; //the total growth time
    }
}






