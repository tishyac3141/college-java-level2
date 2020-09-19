package file_input_output;

import java.io.*;

public class DemoFileClass
{
   public static void main(String[] args) {
      File myFile = new File("Users/tishya/Documents/Programming/Github/college-java-level-2/file_input_output/SomeData.txt");
      
      // To see if this file exists, we can use the exists() method.
      if (myFile.exists())
      {
         System.out.println("Yes, the file exists and it's " +
               myFile.length() + " bytes long.");
      }
      else
         System.out.println("Sorry, but the file does not exist.");
      }
   }