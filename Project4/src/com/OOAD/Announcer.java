package com.OOAD;
import java.util.*;

public class Announcer extends Employee implements Observer{
    SingletonLazyAnnouncer lazy;
    SingletonEagerAnnouncer eager;

    public Announcer(String name) {
        super(name);
    }

    public void announcerPersonality(SingletonLazyAnnouncer lazyAnnouncer, SingletonEagerAnnouncer eagerAnnouncer){
        lazy = lazyAnnouncer;
        eager = eagerAnnouncer;
    }

    public void Announcement(String message){
        if(lazy != null){
            System.out.println("Lazy Guy says: " + message);
        }
        else if(eager != null){
            System.out.println("Eager Guy says: " + message);
        }
    }

}