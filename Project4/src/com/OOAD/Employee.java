package com.OOAD;
import java.util.*;

public abstract class Employee {
    String name;
    String message;
    //Announcer announcer;
    Observer observer;
    public Employee(String name) {
        this.name = name;
    }
}

