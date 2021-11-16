package Project6.src;

public class Seed {
    String type; //the type of seed
    String seedImage;
    double cost; //the cost of the seed
    double sell_price; //how much the seed sells for after it's harvested
    int inventory; //how much the player has in their inventory of this type of seed
    double status; //the status of the seed, the fraction of days it has/needs to grow

    public Seed(String type, String seedImage, double cost, double sell_price, int status){
        this.type = type;
        this.seedImage = seedImage;
        this.cost = cost;
        this.sell_price = sell_price;
        this.status = status;

        //set inventory initally to 0
        inventory = 0;
    }

}
