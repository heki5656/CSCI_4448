package Project7.src;
import java.util.*;

/*
    if it is raining, the store prices increase by 3 g
    if it is snowing, the store prices increase by 4 g
    if it is sunny, the store prices decrease by
 */
public abstract class Merchant {
    //private Object String;
    String weather;
    int sellSeedNum;

    final void openStore(){
        checkWeather(weather);
        //generateGoods();
        sellItem();
        buyItem(sellSeedNum);
    }

    void buyItem(int sellSeedIn){ sellSeedNum = sellSeedIn; };
    abstract void sellItem();
    //protected abstract void checkWeather();
    void checkWeather(String weatherInput){
        weather = weatherInput;
    }
    /*void generateGoods(){
        Random rand = new Random();
        int ranNum;
        ranNum = rand.nextInt((4 - 0) + 1) + 0;
        // Seed carrot = new Seed("carrot", "*", 16, 30, 0/8); 0
        // Seed turnip = new Seed("turnip", "*", 10, 20, 0/4); 1
        // Seed onion = new Seed("onion", "*", 16, 30, 0/8); 2
        // Seed pumpkin = new Seed("pumpkin", "*", 12, 25, 0/6); 3
        // Seed potato = new Seed("potato", "*", 10, 20, 0/4); 4

        //maybe make a store inventory of the crop and seeds?
    }*/

}

class seedStore extends Merchant{
    int carrotPrice = 16;
    int turnipPrice = 10;
    int onionPrice = 16;
    int pumpkinPrice = 12;
    int potatoPrice = 10;

    @Override
    void buyItem(int seedIn) {

    }
    @Override
    void sellItem() {

    }
}

//only buys crops from the player, doesn't sell any crops
class cropStore extends Merchant{
    @Override
    void buyItem(int seedIn) {


    }

    @Override
    void sellItem() {

    }
}

//will I include this or not idk
class generalStore extends Merchant{
    @Override
    void buyItem(int seedIn) {

    }

    @Override
    void sellItem() {

    }
}
