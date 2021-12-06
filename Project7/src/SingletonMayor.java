package Project7.src;
import java.util.*;

public class SingletonMayor{
    private static SingletonMayor mayorAnnouncer;

    private SingletonMayor() {}

    public static SingletonMayor getMayor(){
        if(mayorAnnouncer == null){
            mayorAnnouncer = new SingletonMayor();
        }
        return mayorAnnouncer;
    }
}
