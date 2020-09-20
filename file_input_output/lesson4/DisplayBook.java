package file_input_output.lesson4;

import java.io.*;
import java.util.*;

/**
 * @author: Tishya Chhabra 
 * Date: September 19 2020
 * Class Info: A class that does one of two things; if a file exists with a person's favorite book
 * title in it, then it takes that file and outputs the contents of that file for the user to see.
 * If the file does not exist, then it prompts the user to input their favorite book titile
 * and saves it in a simple text file.
 * 
 * I did not include a Book text file on purpose to test both functionalities.
 */

public class DisplayBook {

    public static void main(String[] args){

        //this is the path that worked for me specifically; the generic one would not work for me...
        //String pathname = "/Users/tishya/Documents/Programming/GitHub/college-java-level2/file_input_output/lesson4/Boox.txt";
        
        String pathname = "Book.txt";
        File bookFile = new File(pathname);

        //encompassed in a try-catch block so that if the file does not exist, it will
        //catch the exception and prompt the user for their book title
        try{
            FileInputStream inStream = new FileInputStream(bookFile);
            int letter = inStream.read();
            //takes the letter, converts it into a character, and prints it one by one for 
            //the user to see (as long as there are characters to read)
            while(letter != -1){
                System.out.print((char) letter);
                letter = inStream.read();
            }

            inStream.close();

        } catch(IOException exception){

            //also encompassed in a try-catch block in case something goes wrong
            try{
                
                //this is the path that worked for me specifically (so that it was in the lesson4 folder)
                //File newBookFile = new File("/Users/tishya/Documents/Programming/GitHub/college-java-level2/file_input_output/lesson4/newBookFile.txt");
                
                File newBookFile = new File("newBookFile.txt");
                FileOutputStream outStream = new FileOutputStream(newBookFile);

                //need a new Scanner to take user input for their favorite book title
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter your favorite book title: "); 
                String title = scanner.nextLine();

                //iterates through the entire string and writes each character one by one into the 
                //specified file
                for (int x = 0; x < title.length(); ++x){
                    outStream.write(title.charAt(x));
                 }
                    
                 System.out.println("The title has been saved!");
                 outStream.close();
                 scanner.close();

            } catch(IOException exception2){
                System.out.println(exception2.getMessage());
            }
        }
        
    }
    
}
