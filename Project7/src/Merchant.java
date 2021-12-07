package Project7.src;

public abstract class Merchant {
    private Object String;

    final void openStore(){
        checkWeather((java.lang.String) String);
        sellItem();
        buyItem();
    }

    abstract void buyItem();
    abstract void sellItem();
    //protected abstract void checkWeather();
    void checkWeather(String weatherInput){

    }
}
