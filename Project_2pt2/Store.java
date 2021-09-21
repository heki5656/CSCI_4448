import java.util.Arrays;
import java.io.IOException;
import java.util.*;
//import java.util.ArrayList;
//import java.util.Random;
//import java.util.List;

public class Store{
    protected String[] damageContainer = {""}; // not sure about this
    List<Employee> employeeList = new ArrayList<Employee>();

    public void createEmployee(){
        Employee employee1 = new Employee("Burt");
        employeeList.add(employee1);
        Employee employee2 = new Employee("Ernie");
        employeeList.add(employee2);
    }

    public Employee pickEmployee(){ //https://www.codegrepper.com/code-examples/java/how+to+select+a+random+element+from+an+array+in+java
        createEmployee();
        double rangeMin = 0.0f;
        double rangeMax = 1.0f;
        //Employee getEmployee = null;
        Random r = new Random();
        double createdRanNum = rangeMin + (rangeMax - rangeMin) * r.nextDouble();

        if (createdRanNum < 0.5){
            return employeeList.get(0); // get Burt
            //return getEmployee;
        }

        if (createdRanNum >= 0.5){
            return employeeList.get(1); // get Ernie
            //return getEmployee;
        }

        return null;
    }

    public void gameVals(){
        //implementing the family game objects
        Game famGame1 = new familyGame();
        famGame1.name = "Monopoly";
        famGame1.shelfPosition = 1;
        gameList.add(famGame1);
        Game famGame2 = new familyGame();
        famGame1.name = "Clue";
        famGame1.shelfPosition = 2;
        gameList.add(famGame2);
        Game famGame3 = new familyGame();
        famGame1.name = "Life";
        famGame1.shelfPosition = 3;
        gameList.add(famGame3);

        //implementing the kids game objects
        Game kidsGame1 = new kidsGame();
        kidsGame1.name = "Mousetrap";
        kidsGame1.shelfPosition = 4;
        gameList.add(kidsGame1);
        Game kidsGame2 = new kidsGame();
        kidsGame2.name = "Candyland";
        kidsGame2.shelfPosition = 5;
        gameList.add(kidsGame2);
        Game kidsGame3 = new kidsGame();
        kidsGame3.name = "Connect Four";
        kidsGame3.shelfPosition = 6;
        gameList.add(kidsGame3);

        //implementing the card game objects
        Game cardGame1 = new cardGame();
        cardGame1.name = "Magic";
        cardGame1.shelfPosition = 7;
        gameList.add(cardGame1);
        Game cardGame2 = new cardGame();
        cardGame2.name = "Pokemon";
        cardGame2.shelfPosition = 8;
        gameList.add(cardGame2);
        Game cardGame3 = new cardGame();
        cardGame3.name = "Netrunner";
        cardGame3.shelfPosition = 9;
        gameList.add(cardGame3);

        //implementing the board game objects
        Game boardGame1 = new boardGame();
        boardGame1.name = "Catan";
        boardGame1.shelfPosition = 10;
        gameList.add(boardGame1);
        Game boardGame2 = new boardGame();
        boardGame2.name = "Risk";
        boardGame2.shelfPosition = 11;
        gameList.add(boardGame2);
        Game boardGame3 = new boardGame();
        boardGame3.name = "Gloomhaven";
        boardGame3.shelfPosition = 12;
        gameList.add(boardGame3);
    }

    public void dayStimulation(){

    }
}
