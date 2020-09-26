package graphics.lesson5;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Name extends JFrame implements ActionListener{

    String[] listOfNames = { "Bob", "Sally", "Mike", "Alice", "Tom" };
    int counter = 0;
    JButton button = new JButton(listOfNames[counter]);
    

    public Name() {
        super("Name Picker!");
        setSize(680, 420);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setLayout(new FlowLayout());
        
        button.setToolTipText("Click to get a new name!");
        button.addActionListener(this);
        add(button);
        
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(counter == 4){
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
