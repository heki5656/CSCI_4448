package com.OOAD;

public class CustomerFactory{
    public Customer createCustomer(String type){
        Customer customer = null;
        if (type.equals("Family Gamer")) {
            customer = new FamilyGamer;
        }
        else if (type.equals("Kid Gamer")) {
            customer = new KidGamer;
        }

        else if (type.equals("Card Gamer")) {
            customer = new CardGamer;
        }

        else if (type.equals("Board Gamer")) {
            customer = new BoardGamer;
        }

        else if (type.equals("Cookie Monster")) {
            customer = new CookieMonster;
        }

        return customer;
    }
}
