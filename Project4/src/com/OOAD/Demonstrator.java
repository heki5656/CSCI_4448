package com.OOAD;

public class Demonstrator extends Employee{

    public static Object demonstrator;

    public Demonstrator(String name) {
        super(name);
    }

    public void demonstrate() {
        System.out.println("Demonstrating");
    }

    public void recommend() {
        System.out.println("Recommending");
    }

    public void explain() {
        System.out.println("Explaining");
    }

}
