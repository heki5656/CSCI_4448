package com.OOAD;
//import org.junit.Test;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.extension.TestWatcher;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
        //Cashier cashier = new Cashier("Burt",);

        //assertNotNull(cashier);

    }




}

