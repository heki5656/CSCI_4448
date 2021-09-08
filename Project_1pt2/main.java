//main class to run the Sorter class
//main class to run Decoder class

public class main{
    public static void main(String args[]){
        //Read();
        Sorter obj = new Sorter();
        //call method for the Sorter class
        //System.out.println("hiiiii"); this was used to test if main ran
        obj.read();

        //call to the method in the Decoder class
        Decoder obj1 = new Decoder();
        obj1.decode();

    }
}

