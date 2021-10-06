package com.OOAD;
import java.util.*;

public class Announcer extends Employee implements Observer{

    public Announcer(String name) {
        super(name);
    }

    public void Announcement(String message){
        System.out.println("Guy says: " + message);
    }
}