package graphics.lesson5;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * @author: Tishya Chhabra 
 * Date: September 26 2020
 * Class Info: A class that allows the user to click on a button, and each 
 * time they click on the button, it displays a different name.
 */

public class Name extends JFrame implements ActionListener{

    //list of the names
    String[] listOfNames = { "Bob", "Sally", "Mike", "Alice", "Tom" };
    //variable to keep track of which name from the array is being outputed
    int counter = 0;
    //creating the button
    JButton button = new JButton(listOfNames[counter]);
    
    public Name() {
        //creating the JFrame and passing in the title
        super("Name Picker!");
        //setting the size of the frame and making sure it completely exits
        //when closing, as well as setting the layout so it overflows nicely
        setSize(680, 420);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setLayout(new GridBagLayout());
        
        //i was testing out the tool tip text here 
        button.setToolTipText("Click to get a new name!");
        
        //adding the correct event listener to the button
        button.addActionListener(this);
        //adding the button to the frame
        add(button);
        
        //making it visible
        setVisible(true);
    }

    //this is the method that is called when the button is pressed
    public void actionPerformed(ActionEvent e) {
        //making sure that if the last name in the list is displayed,
        //then it will restart and display the first name in the list
        if(counter == listOfNames.length - 1){
            counter = 0;
        } else {
            counter++;
        }
        //resetting the button text to the new name
        button.setText(listOfNames[counter]);

    }

    public static void main(String[] args){
        //instantiating the class
        Name name = new Name();
    }

}
