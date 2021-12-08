package Project7.src;

/*
    Seed carrot = new Seed("carrot", "*", 16, 32, 0, 0, 6);
    Seed turnip = new Seed("turnip", "*", 10, 20, 0, 0, 4);
    Seed onion = new Seed("onion", "*", 16, 32, 0, 0, 6);
    Seed pumpkin = new Seed("pumpkin", "*", 12, 24, 0, 0, 5);
    Seed potato = new Seed("potato", "*", 10, 20, 0, 0, 6);
 */

public class SeedFactory {

    public Seed createSeed(String type){
        Seed tempSeed = null;

        if(type == "empty"){
            tempSeed = new emptySeed();
        }
        else if(type == "carrot"){
            tempSeed = new carrotSeed();
        }
        else if(type == "turnip"){
            tempSeed = new turnipSeed();
        }
        else if(type == "onion"){
            tempSeed = new onionSeed();
        }
        else if(type == "pumpkin"){
            tempSeed = new pumpkinSeed();
        }
        else if(type == "potato"){
            tempSeed = new potatoSeed();
        }
        else{
            tempSeed = new emptySeed();
        }
        return tempSeed;
    }
}
