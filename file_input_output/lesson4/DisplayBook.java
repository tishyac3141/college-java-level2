package file_input_output.lesson4;

import java.io.*;
import java.util.*;

public class DisplayBook {

    public static void main(String[] args){

        String pathname = "/Users/tishya/Documents/Programming/GitHub/college-java-level2/file_input_output/lesson4/Boox.txt";
        File bookFile = new File(pathname);

        try{
            FileInputStream inStream = new FileInputStream(bookFile);
            int letter = inStream.read();
            while(letter != -1){
                System.out.print((char) letter);
                letter = inStream.read();
            }

            inStream.close();

        } catch(IOException exception){

            try{
                File newBookFile = new File("/Users/tishya/Documents/Programming/GitHub/college-java-level2/file_input_output/lesson4/newBookFile.txt");
                FileOutputStream outStream = new FileOutputStream(newBookFile);

                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter your favorite book title: "); 
                String title = scanner.nextLine();

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
