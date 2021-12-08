package Project7.src;
import java.util.*;

public class cropDecorator {
    //Seed seedStash;
    public cropDecorator(Seed seedObj){
        //seedStash = seedStashInput;
    }
}

class weatherInfluence extends cropDecorator{
    Seed seedObj;
    public weatherInfluence(Seed seedObj){
        super(seedObj);
        this.seedObj = seedObj;

    }
    public Seed watered(Seed seedObj){
        if((seedObj.growthProgress != seedObj.growthTotal) && (seedObj.type !=""))
            seedObj.growthTotal++;
        return seedObj;
    }
    public Seed booSnow(Seed seedObj){
        if(seedObj.growthProgress >=2 && seedObj.type !=""){
            seedObj.growthTotal --;
        }
        return seedObj;
    }
    public Seed yaySun(Seed seedObj){
        if ((seedObj.growthProgress < seedObj.growthTotal -1) && (seedObj.type !="")){
            seedObj.growthTotal += 2;
        }
        return seedObj;
    }
}

class cropStoreChanges extends cropDecorator{
    Seed seedObj;
    public cropStoreChanges(Seed seedObj) {
        super(seedObj);
        this.seedObj = seedObj;
    }

}
