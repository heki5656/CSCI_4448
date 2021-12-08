package Project7.src;

public class Mayor implements Observer {

    @Override
    public void Announcement(String message) {
        System.out.println("Mayor announced: " + message);
    }
}
