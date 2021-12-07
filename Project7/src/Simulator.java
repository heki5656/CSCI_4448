package Project7.src;

//Mostly took from Bruce Montgomery
public class Simulator {
    public void run(int days) {

        //create a new Farm object
        Farm farm = new Farm();

        //create a Player object, and setUp the name and farm name for player in farm.setUp()
        Player player = farm.setUp();

        //instantiate the fishing object
        Fishing fishingObj = new Fishing();
        
        //instantiate a weather object
        WeatherSingleton weatherOb = null;
        weatherOb = weatherOb.getInstance();

        //create the merchant stuff

        //run for n days
        for (int day = 1; day <= days; day++) {
            //create a random weather for the day 
            String weather = weatherOb.randomWeatherGenerator();
            farm.getWeather(weather);
            fishingObj.getWeather(weather);

            System.out.println("--- Starting Day " + day);

            //start a day on the farm
            farm.startADay(player);


        }
    }
}
