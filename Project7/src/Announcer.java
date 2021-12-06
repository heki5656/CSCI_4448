package Project7.src;
import java.util.*;

//the announcer shouldn't extend the player
public class Announcer implements Observer{
    SingletonMayor mayor;

    public Announcer(String name) {

    }

    public void Announcement(String message){
        System.out.println("Mayor says: " + message);
    }

}
