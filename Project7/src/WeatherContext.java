package Project6.src;
import java.util.*;

public class WeatherContext { // weather interface will be separately implemented to accommodate the needed functions shown on the uml diagram.
    //private WeatherStrategy strategy;
    //String[] weather = {"freezing", "sunny", "windy", "rainy"};
    List<String> weather = Arrays.asList("freezing", "sunny", "rainy");

    public String randomWeatherGenerator(List<String> weather){
        Random r = new Random();
        int randomString = r.nextInt(weather.size());
        String chosen = weather.get(randomString);
        return chosen;
    }

//    public void setWeather(String weather){
//        this.weather = weather;
//    }
//
//    public String getWeather(){
//        return weather;
//    }

//    public WeatherContext(WeatherStrategy strategy){
//        this.strategy = strategy;
//    }

    public int executeStrategy(){
        //return strategy.completeOperation();
        return 1;
    }
}

