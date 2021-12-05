package Project6.src;
import java.util.*;

public class WeatherSingleton{ // lazy instantiation
    private static WeatherSingleton instance = new WeatherSingleton();

    List<String> weather = Arrays.asList("freezing", "sunny", "rainy");
    String status = randomWeatherGenerator(weather);

    Seed carrot = new Seed("carrot", "*", 16, 30, 0/8);
    Seed turnip = new Seed("turnip", "*", 10, 20, 0/4);
    Seed onion = new Seed("onion", "*", 16, 30, 0/8);
    Seed pumpkin = new Seed("pumpkin", "*", 12, 25, 0/6);
    Seed potato = new Seed("potato", "*", 10, 20, 0/4);



    private WeatherSingleton(){}

    public static WeatherSingleton getInstance()
    {
        if (instance == null)
        {
            // if instance is null, initialize
            instance = new WeatherSingleton();
        }
        return instance;
    }

    public String randomWeatherGenerator(List<String> weather){
        Random r = new Random();
        int randomString = r.nextInt(weather.size());
        String chosen = weather.get(randomString);
        return chosen;
    }

    public boolean pondStatus(){
        boolean isFrozen = false;
        if (status == "freezing"){
            isFrozen = true;
        }
        return isFrozen;
    }

    public boolean storeOpenStatus(){
        boolean isOpen = true;
        if (status == "freezing"){
            System.out.println("It is too cold outside, come back another day when the store is open.");
            isOpen = false;
        }
        return isOpen;
    }

    public void farmCropQuality(){
        if (status == "freezing"){
            if (carrot.status > 0){
                carrot.status -= 1;
            }
            if (turnip.status > 0){
                turnip.status -= 1;
            }
            if (onion.status > 0){
                onion.status -= 1;
            }
            if (pumpkin.status > 0){
                pumpkin.status -= 1;
            }
            if (potato.status > 0){
                potato.status -= 1;
            }

            System.out.println("Crop quality is poor due to freezing temperatures.");
        }

        if (status == "rainy"){
            if (carrot.status > 0){
                carrot.status += 1;
            }
            if (turnip.status > 0){
                turnip.status += 1;
            }
            if (onion.status > 0){
                onion.status += 1;
            }
            if (pumpkin.status > 0){
                pumpkin.status += 1;
            }
            if (potato.status > 0){
                potato.status += 1;
            }

            System.out.println("Crop quality is improving since it is raining. We can expect to see crop growth in the near future.");
        }

        if (status == "sunny"){
            if (carrot.status > 0){
                carrot.status += 2;
            }
            if (turnip.status > 0){
                turnip.status += 2;
            }
            if (onion.status > 0){
                onion.status += 2;
            }
            if (pumpkin.status > 0){
                pumpkin.status += 2;
            }
            if (potato.status > 0){
                potato.status += 2;
            }

            System.out.println("Crop quality is at its best!");
        }

    }




}

