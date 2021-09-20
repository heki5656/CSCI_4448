public class Store{
    protected String[] damageContainer = {""}; // not sure about this

    public void pickEmployee(){ //https://www.codegrepper.com/code-examples/java/how+to+select+a+random+element+from+an+array+in+java
        String[] employeeName = {"Burt", "Ernie"};
        Random r = new Random();
        int randomEmployee = r.nextInt(arr.length);
        System.out.println(arr[randomEmployee]);
    }
}