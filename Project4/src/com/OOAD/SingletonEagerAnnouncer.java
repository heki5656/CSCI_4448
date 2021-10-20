package com.OOAD;
import java.util.*;

public class SingletonEagerAnnouncer{
    private static SingletonEagerAnnouncer uniqueEagerAnnouncer;

    private SingletonEagerAnnouncer() {}

    public static SingletonEagerAnnouncer getInstance(){
        if(uniqueEagerAnnouncer == null){
            uniqueEagerAnnouncer = new SingletonEagerAnnouncer();
        }
        return uniqueEagerAnnouncer;
    }
}