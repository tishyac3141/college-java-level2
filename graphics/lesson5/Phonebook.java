package graphics.lesson5;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*; 

/**
 * @author: Tishya Chhabra 
 * Date: September 26 2020
 * Class Info: A class that allows the user to choose, from a dropdown, a 
 * person, and the program will display their phone number.
 */

public class Phonebook extends JFrame implements ActionListener {

    //creating the list of names
    String[] listOfNames = { "Bob", "Sally", "Mike", "Alice", "Tom" };
    //creating the list of phone numbers that correspond
    String[] numbers = {"480-123-5689", "254-897-6354", "610-897-4321", "480-569-7413", "480-632-5541"};
    
    //creating the label with instructions as well as the drop-down
    JLabel label = new JLabel("Who would you like to call?");
    JComboBox names = new JComboBox(listOfNames);

    public Phonebook(){
        //setting the title of the JFrame
        super("Phonebook");
        //setting size, layout, and making sure that the program exits when closed
        setSize(480, 320);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setResizable(true);

        //adding the correct event listener for the drop down
        names.addActionListener(this);

        //adding the label and drop down to the JFrame
        add(label);
        add(names);

        //making the JFrame visible
        setVisible(true);
    }

    //this is the method that's called when the item is selected
    public void actionPerformed(ActionEvent e) {
        int position = names.getSelectedIndex();
        //displays the number that corresponds to the name they chose
        JOptionPane.showMessageDialog(null, listOfNames[position] + "'s number is " + numbers[position]);
    }

    public static void main(String[] args){
        //instantiating the class
        Phonebook phonebook = new Phonebook();
    }
    
}
