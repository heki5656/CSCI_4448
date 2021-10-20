package com.OOAD;

// An original artwork by Bruce Montgomery = September 2021

public class Main {

    // How many days in a run?
    final static int NUMBER_OF_DAYS = 30;

    public static void main(String[] args) {
        //Call the simulator to run for that many days
        Simulator simulator = new Simulator();
        System.out.println("Starting simulator for "+NUMBER_OF_DAYS+" days");
        simulator.run(NUMBER_OF_DAYS);
        
        // ------- Testing Demonstrator Command Stuff ----------
//         Cashier cashier = new Cashier("Burt",10,new BurtStacks());
//         Demonstrator demonstrator = new Demonstrator("Jake");
//         Command com = new DemonstratorOnCommand();
//         //DemonstratorOnCommand dem = new DemonstratorOnCommand(demonstrator);
//         cashier.setCommand(com);
//         cashier.invoke();
    }
}
