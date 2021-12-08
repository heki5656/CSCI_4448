package Project7.src;

public class Seed {
    /*private seedFactory factory;

    public Seed(seedFactory factory){
        this.factory = factory;
    }*/

    String type; //the type of seed
    String seedImage;
    double cost; //the cost of the seed
    double sell_price; //how much the seed sells for after it's harvested
    int inventory; //how much the player has in their inventory of this type of seed
    int growthProgress;
    //double status; //the status of the seed, the fraction of days it has/needs to grow
    int growthTotal; // if the quality hits 3 then it's price increases by 5 g

    public Seed(String type, String seedImage, int cost, int sell_price, int inventory, int growthProgress, int growthTotal){
        this.type = type;
        this.seedImage = seedImage;
        this.cost = cost;
        this.sell_price = sell_price;
        this.growthProgress = growthProgress;
        this.growthTotal = growthTotal;

        //set inventory initally to 0
        inventory = 0;
    }

}
