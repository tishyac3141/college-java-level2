package file_input_output;

import java.io.*;

public class DisplayQuote
{
   public static void main(String[] args)
   {	
      try {
         //specify which file to use
         File text = new File("Quote.txt");
         //open the file							
         FileInputStream in = new FileInputStream(text);			
         	
         int letter;
         //read each letter from the stream
         while ((letter = in.read()) != -1) 							
         {
            System.out.print((char)letter);
         }
         //close the file
         in.close();															
      }
         catch (IOException exc)
         {
            System.out.println("Oops!  Can't display file.");
         }
      }
   }