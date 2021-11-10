package Project6.src;
import java.util.*;

public class Announcer extends Player implements Observer{
    SingletonMayor mayor;

    public Announcer(String name) {
        super(name);
    }

    public void Announcement(String message){
        System.out.println("Mayor says: " + message);
    }

}
