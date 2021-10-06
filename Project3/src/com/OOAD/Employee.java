package com.OOAD;
import java.util.*;

public abstract class Employee {
    String name;
    String message;
    Announcer announcer;
    public Employee(String name, Announcer announcer) {
        this.name = name;
        //giving reference to announcer to the employees
        this.announcer = announcer;
    }
    public void arriveAtStore(int day) {

        //System.out.println(name+" has arrived on day "+day);
        message = name+" has arrived on day "+day;
        //this.announcer(name, message);  need to call a method
        this.announcer.Announcement(message); /* COMMENT THIS OUT IN ORDER TO RUN */
    }
    public void leaveTheStore(int day) {

        System.out.println(name+" has left on day "+day);
    }
}

