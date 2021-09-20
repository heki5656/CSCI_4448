import java.util.*;

public class Store {
    protected String[] damageContainer = {""}; // not sure about this
    List employeeList = new List<Employee>;

    public void createEmployee(String name){
        Employee employee = new Employee("Burt");
        employeeList.add(employee);
        Employee employee = new Employee("Ernie");
        employeeList.add(employee);
    }

    public void pickEmployee(){ //https://www.codegrepper.com/code-examples/java/how+to+select+a+random+element+from+an+array+in+java
        double rangeMin = 0.0f;
        double rangeMax = 1.0f;
        Random r = new Random();
        double createdRanNum = rangeMin + (rangeMax - rangeMin) * r.nextDouble();

        if (createdRanNum < 0.5){
            employeeList.get(0); // get Burt
        }

        if (createdRanNum >= 0.5){
            employeeList.get(1); // get Ernie
        }

//        String[] employeeName = {"Burt", "Ernie"};
//        Random r = new Random();
//        int randomEmployee = r.nextInt(employeeName.length);
//        System.out.println(employeeName[randomEmployee]);
    }
}



public class Employee{
 //name attribute for each instance of a class
    String Name;

    public Employee(String name){
        Name = name;
    }
}

// List of games in store, cashier has reference to store, cashier can access games
public class Cashier extends Employee { // Example of Inheritance
    //Employee employee = new Employee();

    Store store = new Store();
    Cashier cashier = new Cashier(store); // make reference of Store class?

    public static void arriveAtStore(){
        System.out.println(store.pickEmployee(), "the cashier has arrived at the store on Day ", day_number);
    }

    public static void vacuumStore(){
        System.out.println(store.pickEmployee(), " vacuumed the store");

    }

    public static void stackGame(){

    }

    public static void openStore(){

    }

    public static void orderGame(){

    }

    public static void closeStore(){
        System.out.println(employee.pickEmployee(), " is leaving and closed the store");
    }

    public void countMoney(){

    }
}