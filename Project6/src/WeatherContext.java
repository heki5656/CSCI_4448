package Project6.src;
import java.util.*;

public class WeatherContext {
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

    public int executeStrategy(int num1, int num2){
        //return strategy.doOperation(num1, num2);
        return 1;
    }
}

