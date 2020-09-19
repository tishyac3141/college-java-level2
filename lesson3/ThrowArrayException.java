package lesson3;

import javax.swing.JOptionPane;

/**
 * @author: Tishya Chhabra 
 * Date: September 12, 2020
 * Class Info: A basic class that practices using the 'try-catch' block; prompts the user for
 * the index of the person's name they would like to know and catches the 'IndexOutOfBounds'
 * exception so the user knows that they provided an invalid index.
 */

public class ThrowArrayException{

    public static void main(String[] args){

        //array of possible names
        String[] names = new String[10];
        names[0] = "Johnny";
        names[1] = "Julie";
        names[2] = "Sarah";
        names[3] = "Jeanie";
        names[4] = "Luke";
        names[5] = "Danna";
        names[6] = "Rika";
        names[7] = "Cristina";
        names[8] = "Austin";
        names[9] = "Alisha";

        //simple input that asks for the index
        String input = JOptionPane.showInputDialog("Please enter the index and we'll give you their name: ");
        int index = Integer.parseInt(input);

        //tries to access the element at that index but catches the exception thrown if
        //that index is invalid
        try{
            JOptionPane.showMessageDialog(null, names[index]);
        } catch(ArrayIndexOutOfBoundsException exception){
            JOptionPane.showMessageDialog(null, "That was not a valid index!");
        }
    }

}