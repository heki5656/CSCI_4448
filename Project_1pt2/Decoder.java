import java.util.Arrays;
import java.io.IOException;
import java.io.File;
import java.io.PrintStream;

public class Decoder{
    static void decode(){
        //declaring the array for the ascii values we are determining the nature of
        int[] asciiArray = new int[]{66,114,117,99,101,32,83,97,121,115,32,72,105,33,7,9,50,48,49,57};

        //for loop checks for the different kinds of cases of each value in the array
        //note: getting the ascii character of the table values is just converting the integer to a char type
        //the different if statements are for the different ranges given for the different ascii values since the
        //majority are in certain ranges but also for something like special characters they're in a number of different
        //ranges which require us to do more than one kind of is statements for all of them
        for(int i = 0; i < asciiArray.length; i++){
            //white space ascii values
            if((asciiArray[i] >= 0) && (asciiArray[i] <= 32)){
                System.out.println("Code: " + asciiArray[i] + "   Type: White Space   " + "ASCII Char: " + (char)asciiArray[i]);
            }
            //special character ascii values (first two sets)
            else if(((asciiArray[i] >= 33) && (asciiArray[i] <= 47)) || ((asciiArray[i] >= 58) && (asciiArray[i] <= 64))){
                System.out.println("Code: " + asciiArray[i] + "   Type: Special Character   " + "ASCII Char: " + (char)asciiArray[i]);
            }
            //second set of special characters
            else if(((asciiArray[i] >= 91) && (asciiArray[i] <= 96)) || ((asciiArray[i] >= 123) && (asciiArray[i] <= 126))){
                System.out.println("Code: " + asciiArray[i] + "   Type: Special Character   " + "ASCII Char: " + (char)asciiArray[i]);
            }
            //integer values
            else if((asciiArray[i] >= 48) && (asciiArray[i] <= 57)){
                System.out.println("Code: " + asciiArray[i] + "   Type: Digit   " + "ASCII Char: " + (char)asciiArray[i]);
            }
            //capital letters
            else if((asciiArray[i] >= 65) && (asciiArray[i] <= 90)){
                System.out.println("Code: " + asciiArray[i] + "   Type: Upper Case Letters   " + "ASCII Char: " + (char)asciiArray[i]);
            }
            //lower case letters
            else if((asciiArray[i] >= 97) && (asciiArray[i] <= 122)){
                System.out.println("Code: " + asciiArray[i] + "   Type: Lower Case Letters   " + "ASCII Char: " + (char)asciiArray[i]);
            }
            else{
                return;
            }

        }
    }
}
