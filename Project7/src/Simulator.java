package Project7.src;

//Mostly took from Bruce Montgomery
public class Simulator {
    public void run(int days) {

        //create a new Farm object
        Farm farm = new Farm();

        //create a Player object, and setUp the name and farm name for player in farm.setUp()
        Player player = farm.setUp();

        //player money tracker to see if they keep the farm or not
        int playerMoney = 0;

        //instantiate the fishing object
        Fishing fishingObj = new Fishing();
        
        //instantiate a weather object
        WeatherSingleton weatherOb = null;
        weatherOb = weatherOb.getInstance();

        //create the merchant stores
        seedStore seedStoreObj = new seedStore();
        cropStore cropStoreObj = new cropStore();
        generalStore generalStoreObj = new generalStore();

        //run for n days
        for (int day = 1; day <= days; day++) {
            //create a random weather for the day 
            String weather = weatherOb.randomWeatherGenerator();
            farm.getWeather(weather);
            fishingObj.getWeather(weather);

            //generate the produce store items for the day
            /*seedStoreObj.generateGoods();
            cropStoreObj.generateGoods();*/

            System.out.println("--- Starting Day " + day);

            //start a day on the farm
            farm.startADay(player, seedStoreObj, cropStoreObj, generalStoreObj);
            if(day == days){
                playerMoney = player.money;
            }
        }

        if(playerMoney >= 500){
            System.out.print("Yay! You earned enough money to keep your farm!");
        }
        else{
            System.out.print("Oh no... you didn't earn enough money to keep your farm :( bye...");
        }
    }
}
