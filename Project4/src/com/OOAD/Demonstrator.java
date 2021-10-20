package com.OOAD;

public class Demonstrator extends Employee{

    public static Object demonstrator;

    public Demonstrator(String name) {
        super(name);
    }

    public String demonstrate() {
        return " is demonstrating";
    }

    public String recommend() {

        return " is recommending";
    }

    public String explain() {

        return "is explaining";
    }

}
