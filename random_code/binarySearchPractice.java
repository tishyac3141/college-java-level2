package random_code;

import javax.swing.JOptionPane;

public class binarySearchPractice {

    public static void main(String[] args){

        String[] names = {"Alisha", "Austin", "Danna", "Sarah", "Jeanie", "Julie", "Luke"};
        String[] numbers = {"480-569-7841", "602-987-6321", "408-561-2234", "602-982-5413", "480-974-3311", "480-562-7794", "602-784-5623"};


        String name = JOptionPane.showInputDialog(null, "Type in who you would like to call:");
        JOptionPane.showMessageDialog(null, name);
    }
    
}
