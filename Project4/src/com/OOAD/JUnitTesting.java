package com.OOAD;
//import org.junit.Test;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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







}

