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

    String[] listOfNames = { "Bob", "Sally", "Mike", "Alice", "Tom" };
    int counter = 0;
    JButton button = new JButton(listOfNames[counter]);
    

    public Name() {
        super("Name Picker!");
        setSize(680, 420);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setLayout(new GridBagLayout());
        
        button.setToolTipText("Click to get a new name!");
        button.addActionListener(this);
        add(button);
        
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(counter == listOfNames.length - 1){
            counter = 0;
        } else {
            counter++;
        }

        button.setText(listOfNames[counter]);

    }

    public static void main(String[] args){
        Name name = new Name();
    }

}
