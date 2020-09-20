package file_input_output.lesson4;

import java.io.*;

public class FileStatistics2 {

    public static void main(String[] args){
        String pathName1 = "/Users/tishya/Documents/Programming/GitHub/college-java-level2/file_input_output/lesson4/Quote.txt";
        String pathName2 = "/Users/tishya/Documents/Programming/GitHub/college-java-level2/file_input_output/lesson4/Quote.doc";
        File quote1 = new File(pathName1);
        File quote2 = new File(pathName2);

        System.out.println("The size of the first file is " + quote1.length());
        System.out.println("The size of the second file is " + quote2.length());
        System.out.println("The ratio of sizes betweem the two files is: " + (quote1.length() / quote2.length()));
    }
    
}
