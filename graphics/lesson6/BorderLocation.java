package graphics.lesson6;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * @author: Tishya Chhabra 
 * Date: October 3, 2020
 * Class Info: A class that allows the user to click on a button, and each 
 * time they click on the button, the region that button is in is displayed.
 */

public class BorderLocation extends JFrame implements ActionListener{
    
    private Container cont = getContentPane();
    //creating each button
    private JButton northButton = new JButton();
    private JButton eastButton = new JButton();
    private JButton southButton = new JButton();
    private JButton westButton = new JButton();
    private JButton centerButton = new JButton();

    public BorderLocation(){
        //setting the layout to BorderLayout so that the content is arranged in 5 regions
        cont.setLayout(new BorderLayout());
        setSize(300, 250);

        //adding the appropriate actionListener so that when the button is clicked,
        //the corresponding region is displayed
        northButton.addActionListener(this);
        southButton.addActionListener(this);
        westButton.addActionListener(this);
        eastButton.addActionListener(this);
        centerButton.addActionListener(this);

        //adding each button to their respective regions
        cont.add(northButton, BorderLayout.NORTH);
        cont.add(southButton, BorderLayout.SOUTH);
        cont.add(eastButton, BorderLayout.EAST);
        cont.add(westButton, BorderLayout.WEST);
        cont.add(centerButton, BorderLayout.CENTER);
    }

    //this method is called when a button is clicked
    public void actionPerformed(ActionEvent e) {
        //getting which button was clicked
        Object clicked = e.getSource();
        //going through and checking which exact button was clicked and
        //displaying the region using JOptionPane
        if(clicked.equals(centerButton)){
            JOptionPane.showMessageDialog(null, "Center!!");
        } 
        else if(clicked.equals(northButton)){
            JOptionPane.showMessageDialog(null, "North!");
        }
        else if(clicked.equals(southButton)){
            JOptionPane.showMessageDialog(null, "South!");
        }
        else if(clicked.equals(eastButton)){
            JOptionPane.showMessageDialog(null, "East!");
        }
        else if(clicked.equals(westButton)){
            JOptionPane.showMessageDialog(null, "West!");
        }
    }

    //creating an instance of the class and setting it to visible so we can see
    //the program work!
    public static void main(String[] args){
        BorderLocation bloc = new BorderLocation();
        bloc.setVisible(true);
    }

}
