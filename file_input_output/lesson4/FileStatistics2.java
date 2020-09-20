package file_input_output.lesson4;

import java.io.*;

/**
 * @author: Tishya Chhabra 
 * Date: September 19 2020
 * Class Info: A class that takes two files with the exact same content, just in two different formats.
 * One is in a .doc format (associated with Word) and the other is in a .txt format (plain text)
 * It takes both of those files and compares their sizes as well as outputs the ratio of the sizes
 * of the two files.
 */

public class FileStatistics2 {

    public static void main(String[] args){
        
        //these are the path names that worked for me specifically; the generic one would not work for me...
        //String pathName1 = "/Users/tishya/Documents/Programming/GitHub/college-java-level2/file_input_output/lesson4/Quote.txt";
        //String pathName2 = "/Users/tishya/Documents/Programming/GitHub/college-java-level2/file_input_output/lesson4/Quote.doc";
        
        String pathName1 = "Quote.txt";
        String pathName2 = "Quote.doc";

        File quote1 = new File(pathName1);
        File quote2 = new File(pathName2);

        System.out.println("The size of the first file is " + quote1.length());
        System.out.println("The size of the second file is " + quote2.length());
        System.out.println("The ratio of sizes betweem the two files is: " + ((double)quote1.length() / quote2.length()));
    }
    
}
