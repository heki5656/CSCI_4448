import java.util.*;

//creation of the game class, and declaring attributes that each game would have in common such as having a name and cost even though it may be different for each game
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

//all of the following are subclass declarations of all the different kinds of game categories there are since there are different types of games
//all of them would generally have the same sizes despite being different games except card games which would be smaller as they would typically only have 
//the cards and instructions instead of a full on set such as a board
class familyGame extends Game{

}

class kidsGame extends Game{

}

class cardGame extends Game{
    int length = 5;
    int width = 4;
    int height = 2;
}

class boardGame extends Game{

}
