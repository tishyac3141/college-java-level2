   package file_input_output;
   
   import java.io.*;
   import java.util.Scanner;

   public class WriteDemo
   {
      public static void main(String[] args)
      {
      
         try
         {
            //the file to write it to
            File myFile = new File("MyQuote.txt");
            //open the file for writing							
            FileOutputStream out = new FileOutputStream(myFile);		
         
            System.out.print("Enter your favorite quote: "); 
            Scanner scanner = new Scanner(System.in);
            String answer = scanner.nextLine();
         
            //now, let's send this quote to the file, character-by-character via the FileOutputStream.
         
            for (int x = 0; x < answer.length(); ++x){
               out.write(answer.charAt(x));
            }
               
            out.close();
         } catch (IOException exc) {
            System.out.println(exc.getMessage());
         }
      }
   }