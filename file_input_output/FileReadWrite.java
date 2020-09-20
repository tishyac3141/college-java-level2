package file_input_output;

import java.io.*;

public class FileReadWrite
{
   public static void main(String[] args)
   {
      String pathname = "/Users/tishya/Documents/Programming/GitHub/college-java-level2/file_input_output/SomeData.txt";
      File myFile = new File(pathname);
      if (myFile.exists()) {
         System.out.println(myFile.getName() + " exists");
         System.out.println("The file is " + myFile.length() + " bytes long.");
         
         if (myFile.canRead())
            System.out.println("Ok to read");
         else
            System.out.println("Not ok to read");
         	
         if (myFile.canWrite())
            System.out.println("Ok to write");
         else
            System.out.println("Not ok to write");
      }
      else
         System.out.println("File does not exist");
      }
   }
