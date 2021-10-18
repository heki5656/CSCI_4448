package com.OOAD;

public class CustomerFactory{
    String customerType = "";
    String customerName = "";
    public Customer createCustomer(String type){
        //System.out.println("In Factory");
        Customer customer = null;

        if (type.equals("Family Gamer")) {
            //System.out.println("Factory is making a family gamer");
            customerType = "Family Gamer";
            customer = new FamilyGamer();
        }

        else if (type.equals("Kid Gamer")) {
            //System.out.println("Factory is making a kid gamer");
            customerType = "Kid Gamer";
            customer = new KidGamer();
            
        }

        else if (type.equals("Card Gamer")) {
            //System.out.println("Factory is making a card gamer");
            customerType = "Card Gamer";
            customer = new CardGamer();
            
        }

        else if (type.equals("Board Gamer")) {
            //System.out.println("Factory is making a board gamer");
            customerType = "Board Gamer";
            customer = new BoardGamer();
        }

        else if (type.equals("Cookie Monster")) {
            //System.out.println("Factory is making a cookie monster");
            customerType = "Cookie Monster";
            customer = new CookieMonster();
        }

        return customer;
    }
}
