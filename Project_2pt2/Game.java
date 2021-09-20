import java.util.*;

public class Game{
    //should have different attributes for the name and prices of the games
    //having subclasses of the different types of game categories
//    public void setName(){
//        String name = "";
//    }
    String name = "";
    int cost = (int) Math.floor(Math.random()*(100-5+1)+5);
    int length = 10;
    int width = 8;
    int height = 2;
    int shelfPosition = 0;
    int inventoryAmount = 3;
    int numSold = 0;
}

class familyGame extends Game{

}

class kidsGame extends Game{

}

class cardGame extends Game{

}

class boardGame extends Game{

}