package com.OOAD;

public class CustomerFactory{
    public Customer createCustomer(String type){
        System.out.println("In Factory");
        Customer customer = null;

        if (type.equals("Family Gamer")) {
            System.out.println("Factory is making a family gamer");
            customer = new FamilyGamer();
        }

        else if (type.equals("Kid Gamer")) {
            System.out.println("Factory is making a kid gamer");
            customer = new KidGamer();
            
        }

        else if (type.equals("Card Gamer")) {
            System.out.println("Factory is making a card gamer");
            customer = new CardGamer();
            
        }

        else if (type.equals("Board Gamer")) {
            System.out.println("Factory is making a board gamer");
            customer = new BoardGamer();
        }

        else if (type.equals("Cookie Monster")) {
            System.out.println("Factory is making a cookie monster");
            customer = new CookieMonster();
        }

        return customer;
    }
}
