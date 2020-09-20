package file_input_output.lesson4;

import java.io.File;

public class FileStatistics {
    
    public static void main(String[] args){
        String pathName = "/Users/tishya/Documents/Programming/GitHub/college-java-level2/file_input_output/lesson4/RandomFile.txt";
        File myFile = new File(pathName);

        System.out.println("Here is some information about the file. The file's  name is: " + myFile.getName() + ". "
        + " The size of the file is " + myFile.length() + ". The time at which it was last modified is " + 
        myFile.lastModified() + ".");
    }

}
