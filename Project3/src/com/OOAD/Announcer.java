package com.OOAD;
import java.util.*;

public class Announcer extends Employee{

     public Announcer(String name, Announcer announcer) {
         super(name, announcer);
     }

     public void Announcement(String message){
         System.out.println(message);
     }
}