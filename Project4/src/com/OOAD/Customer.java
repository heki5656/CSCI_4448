package com.OOAD;

public class Customer {

    public Customer(){
        //System.out.println("Creating a customer");

    }
}

class FamilyGamer extends Customer{

    public FamilyGamer() {
        super();
        //System.out.println("Family gamer");

    }
}

class KidGamer extends Customer{
    public KidGamer() {
        super();
        //System.out.println("Kid gamer");

    }
}

class CardGamer extends Customer{
    public CardGamer() {
        super();
        //System.out.println("Card gamer");
    }
  
}

class BoardGamer extends Customer{
    public BoardGamer() {
        super();
        //System.out.println("Board gamer");

    }
}

class CookieMonster extends Customer{
    public CookieMonster() {
        super();
        //System.out.println("Cookie Monster");
    }
}