package file_input_output.lesson4;

import java.io.File;

/**
 * @author: Tishya Chhabra 
 * Date: September 19 2020
 * Class Info: A class that takes an existing file, and checks if it exists, and if it does,
 * prints out some statistics about that file, like what its name is, what its size is, and when
 * it was last modified. If the file does not exist, it tells the user.s
 */

public class FileStatistics {
    
    public static void main(String[] args){
        
        //this is the path that works for me; the generic one does not work for me for some reason... 
        //String pathName = "/Users/tishya/Documents/Programming/GitHub/college-java-level2/file_input_output/lesson4/RandomFile.txt";
        
        String pathName = "RandomFile.txt";
        File myFile = new File(pathName);

        if(myFile.exists()){
            System.out.println("Here is some information about the file. The file's  name is: " + myFile.getName() + 
            ". The size of the file is " + myFile.length() + ". The time at which it was last modified is " + 
            myFile.lastModified() + ".");
        } else {
            System.out.println("That file does not exist!");
        }
        
    }

}
