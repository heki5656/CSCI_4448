package com.OOAD;
import java.util.*;

public class SingletonLazyAnnouncer{
    private static SingletonLazyAnnouncer uniqueLazyAnnouncer;

    private SingletonLazyAnnouncer() {}

    public static SingletonLazyAnnouncer getInstance(){
        if(uniqueLazyAnnouncer == null){
            uniqueLazyAnnouncer = new SingletonLazyAnnouncer();
        }
        return uniqueLazyAnnouncer;
    }
}