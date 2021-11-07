package Project6.src;

//Mostly took from Bruce Montgomery
public class Simulator {
    public void run(int days) {

        //create a new Farm object
        Farm farm = new Farm();

        //create a Player object, and setUp the name and farm name for player in farm.setUp()
        Player player = farm.setUp();


        //run for n days
        for (int day = 1; day <= days; day++) {

            System.out.println("--- Starting Day " + day);

            //start a day on the farm
            farm.startADay(player);


        }
    }
}
