package file_input_output;

import java.io.*;
import java.nio.file.*;

public class huh {

    public static void main(String[] args){
        //maybe this could work?
        String javahome = System.getenv("JAVA_HOME");
        System.out.println("JavaHome = " + javahome);
        String path = System.getenv("PATH");
        System.out.println("Path = " + path);
        
        try {
            Path directoryPath = Paths.get(javahome);
            Files.createDirectories(directoryPath);
            System.out.println("Directory is created!");

            String pathName = directoryPath + "/RandomFile.txt";
            File myFile = new File(pathName);

            if(myFile.exists()){
                System.out.println("Here is some information about the file. The file's  name is: " + myFile.getName() + 
                ". The size of the file is " + myFile.length() + ". The time at which it was last modified is " + 
                myFile.lastModified() + ".");
            } else {
                System.out.println("That file does not exist!");
            }
        } catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    
}
