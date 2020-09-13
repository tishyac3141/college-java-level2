package exceptions.lesson3;

import javax.swing.JOptionPane;

public class ThrowArrayException{

    public static void main(String[] args){

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

        String input = JOptionPane.showInputDialog("Please enter the index and we'll give you a name: ");
        int index = Integer.parseInt(input);

        try{
            JOptionPane.showMessageDialog(null, names[index]);
        } catch(ArrayIndexOutOfBoundsException exception){
            JOptionPane.showMessageDialog(null, "That was not a valid index!");
        }
    }

}