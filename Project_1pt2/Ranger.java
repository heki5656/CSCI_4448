import java.util.Scanner;
import java.io.FileWriter;
import java.io.PrintStream;
import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Ranger{

    private static int start_number;
    private static int end_number;

    public Ranger(int first, int last){
        this.start_number = first;
        this.end_number = last;
    }

    public static int getStart_number(){
        return start_number;
    }

    public static void setStart_number(int newNum){
        start_number = newNum;
    }

    public static void setEnd_number(int newNum){
        end_number = newNum;
    }

    public static int getEnd_number(){
        return end_number;
    }

    // read method
    // Sources: https://stackoverflow.com/questions/8707906/error-message-unreported-exception-java-io-ioexception-must-be-caught-or-decla (for try/catch phrases)
    public static char read()
    {
        int min,max;
        boolean isValid = false;
        char status = 'A'; //'Accept', 'Reject', 'End'
        Scanner range = new Scanner(System.in); //scanner object to collect user input

        System.out.println("\nEnter a numeric positive integer range :"); // enter in this format: "min_value max_value"; ex. "1 2"
        String [] a = range.nextLine().split(" "); // add space in between start and end number when inputting

        try {
            min = Integer.parseInt(a[0]); // retrieve start number
        } catch (NumberFormatException nfe) {
            return 'R'; //Reject Range
        }

        try {
            max = Integer.parseInt(a[1]); // retrieve end number
        } catch (NumberFormatException nfe) {
            return 'R';  //Reject Range
        }

        Ranger r = new Ranger(min,max);

        System.out.println("First number is "+r.getStart_number());
        System.out.println("Second number is "+r.getEnd_number());

        if (min > max) // if start number is greater than end number, then reject range
            return 'R'; //Reject Range

        if (min < 0 || max < 0) // if start or end number is negative, then reject range
            return 'R'; //Reject Range

        if (min >= max && (min != 0 && max != 0))
            return 'R'; //Reject Range

        if (min == 0 && max == 0) // if start and end number are both zero, end the program
            return 'E'; //End Program

        // isValid = true;
        setStart_number(min);
        setEnd_number(max);
        return 'A'; //Accept Range
    }

    // method to increase the size of an array
    public static int[] extend(int[] arr){
        int[] newArr = new int[arr.length + 10]; // increase by 10

        for (int i = 0; i < arr.length; i++){
            newArr[i] = arr[i];
        }
        arr = newArr;
        return arr;
    }

    // Random number generator
    // Sources: https://programmerfriend.com/java-random-numbers/
    private static int getRandomInt(int min, int max) {
        int difference = max - min;
        Random random = new Random();
        return random.nextInt(difference + 1) + min;
    }

    // calculate method
    public static void calculate(int min, int max)
    {
        int[] arr = new int[10];
        double total=0.0; // keep track of total for mean and SD calculations
        int count = 0;

        while (arr.length <= 100){ // array size cannot exceed 100
            for (int i = count; i < arr.length; i++) {
                arr[i] = getRandomInt(min,max); // generate numbers randomly within the given accepted range
            }

            System.out.print("\nValues:");
            for (int j = 0; j < arr.length; j++){
                System.out.print(arr[j]); // print out random numbers generated stored in array
                System.out.print(" ");
                total += arr[j];
            }

            double mean = total/arr.length;
            System.out.print("\nMean: ");
            System.out.print(mean); // print mean

            double sum = 0.0;
            System.out.print(" SD: ");
            for (int j = 0; j < arr.length; j++){
                sum += Math.pow((arr[j]-mean),2); //calculate standard deviation
            }
            mean=sum/(arr.length-1);
            double deviation=Math.sqrt(mean);

            System.out.print(deviation+"\n"); // print standard deviation

            mean = 0.0;
            deviation = 0.0;
            total = 0.0;

            count = (arr.length-1) + 1; // increase count to position right after previous array length; ex. 0-9, so count will start at 10 and next array range will be from 10-19
            arr = extend(arr); // increase array size for next iteration using current accepted number range

        }


    }

    // write method
    // Sources: https://www.w3schools.com/java/java_files_create.asp
    // https://stackoverflow.com/questions/8043356/file-write-printstream-append (for the printstream)
    public static void write() throws IOException {
        //Instantiating the File class
        File file = new File("C:\\CU BOULDER\\Junior Year\\OOAD\\Project 1 Part 2\\Results2.txt"); // create file object with given path; title it 'Results2.txt'

        //Instantiating the PrintStream class
        PrintStream stream = new PrintStream(new FileOutputStream(file, true));

        System.setOut(stream);

    }

    // Sources: https://stackoverflow.com/questions/8707906/error-message-unreported-exception-java-io-ioexception-must-be-caught-or-decla (for try/catch phrases)
    public static void main(String[] args){
        boolean continueProgram = true; // program will run as long as set to true
        int counter = 0;

        while (continueProgram){
            char r = read();
            try {
                write();
            }
            catch(IOException e) {
                e.printStackTrace();
            }
            //System.out.println("read " + r);
            if (r == 'A'){ //Accept Range
                calculate(getStart_number(), getEnd_number());
            }
            else if (r == 'R'){ //Reject Range
                System.out.println("Range Rejected. Try again.");
            }
            else{
                System.out.println("Ending Program");
                continueProgram = false; // set to false because program has ended and should not calculate or read any more values
            }
        }
    }
}

