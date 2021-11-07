package Project6.src;

public class Simulator {
    public void run(int days) {

        //run for n days
        for (int day = 1; day <= days; day++) {

            System.out.println("--- Starting Day " + day);

            //check if first day
            if (day == 1){

                //go to the first day in farm, to get everything set up
                farm.firstDay();

                System.out.println("This is your first day.");
            }


        }
    }
}
