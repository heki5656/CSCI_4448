package com.OOAD;
//import org.junit.Test;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.extension.TestWatcher;

import static org.junit.jupiter.api.Assertions.*;

//@ExtendWith(TestResultLoggerExtension.class)
public class JUnitTesting {
    @Test
    public void testStoreObjectInstantiates(){
        Store store = new Store();

        assertNotNull(store);

    }

    @Test
    public void testCustomerObjectInstantiates(){
        Customer customer = new Customer();

        assertNotNull(customer);

    }

    @Test
    public void testAnnouncerObjectInstantiates(){
        Announcer announcer = new Announcer("Lazy Guy");

        assertNotNull(announcer);

    }

    @Test
    public void testCashierObjectInstantiates(){
        Cashier cashier = new Cashier("Burt",10,new BurtStacks());

        assertNotNull(cashier);

    }

    @Test
    public void testDemonstratorObjectInstantiates(){
        Demonstrator demonstrator = new Demonstrator("Jim");

        assertNotNull(demonstrator);

    }

    @Test
    public void testGameObjectInstantiates(){
        Game game = new Game("Candyland");

        assertNotNull(game);

    }

    @Test
    public void testSimulatorObjectInstantiates(){
        Simulator simulator = new Simulator();

        assertNotNull(simulator);

    }
    
    
    @Test
    public void testGameInventory(){
        Game games = new Game("Sorry");

        assertEquals(games.countInventory, 3);
    }

    @Test
    public void testDropOffCookies(){

        Store store = new Store();
        Baker baker = new Baker("Bill");
        baker.dropOffCookies(1, store);

        assertEquals(store.cookie.inventory, 12);
    }

    //this test is checking being the max amount of customers in a day is 10, and the max amount of cookies
    //each customer can buy is 3, that when 5 packages of cookies are delivered (4 are dropped off in this test
    //one is dropped off in the startADay function) that there are 60 cookies, if the max customers(10) and
    //all bought the max cookies(3) then there should be >= 30 cookies at the end of the day
    @Test
    public void testMaxNumberOfCookiesBought(){
        Store store = new Store();
        Baker baker = new Baker("Bill");
        baker.dropOffCookies(4, store);
        store.startADay(1);
        assertTrue(store.cookie.inventory >= 30);
    }

    //this test is checking being that the min amount of customers is 1, and every customer buys 1-3 cookies
    //that at least 1 cookie is bought in a day
    @Test
    public void testMinNumberOfCookiesBought(){
        Store store = new Store();
        store.startADay(1);
        assertTrue(store.cookie.inventory < 12);
    }

    @Test
    public void testCustomerFactory(){
        CustomerFactory factory = new CustomerFactory();
    }

    @Test
    public void testFamilyGamer(){
        CustomerFactory factory = new CustomerFactory();
        factory.createCustomer("Family Gamer");
        assertNotNull(factory);
    }

    @Test
    public void cookiePrice(){
        Cookie cookie = new Cookie();
        assertEquals(cookie.price, 3.00);
    }

    @Test
    public void testNumberOfGames(){
        Store store = new Store();
        store.startADay(1);
        assertEquals(store.games.size(), 12);
    }

}

