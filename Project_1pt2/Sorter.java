/* OOA/D Project 1 part 2
    Coding part 1
    To do:
        reads a string from the console input
        sorts the letters in the string into alphabetic order
        prints the sorted string to the console output
    program ends if a null string is submitted as an input and capture the output to a Results1.txt file
*/
import java.util.Scanner;
import java.util.Arrays;
import java.io.IOException;
import java.io.File;

public class Sorter{
    static void read(){
        /*
            source: used tutorialpoint of syntax ways to read input from the console
         */
        //takes in an input from the console for a name
        System.out.println("Enter name: ");
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();

        if(name != ""){
            System.out.println("Input string: " + name);
            //lets sort method use the variable name
            sort(name);
        }
        else{
            //ends method if the name is an empty string or nothing was typed
            return;
        }

    }

    static void sort(String name){
        /*
            source: used geekforgeeks website on sorting string for java to learn the sort
            function as well as how to use it
            also used it for the upper casing as well as converting to character array syntax
         */
        //turns the string name into an array of characters
        String nameUpper = name.toUpperCase();
        //System.out.println(nameUpper);
        char nameArr[] = nameUpper.toCharArray();
        //sorting function to sort the character array alphabtically
        Arrays.sort(nameArr);
        name = "";
        for(int i = 0; i < nameArr.length; i++)
        {
            name += nameArr[i];
        }
        write(name);
    }

    static void write(String name){

        System.out.println(name);
    }
}



