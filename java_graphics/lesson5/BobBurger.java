package java_graphics.lesson5;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 * @author: Tishya Chhabra 
 * Date: September 26 2020
 * Class Info: A class that allows the user to order some food. It uses Java Swing
 * Components, like JFrame, JButton, JCheckBox, and Button Group, to display
 * the various options of ordering a burger, double burger, some additional 
 * items for the burger, as well as a small, medium, or large soda. Once the user
 * makes a selection and clicks 'Done', the program will output how much the final
 * cost is.
 */

public class BobBurger extends JFrame implements ItemListener, ActionListener {

    //initializing the cost
    double cost = 0;

    //creating the label as well as the done button
    JLabel label = new JLabel("What would you like to order?");
    JButton button = new JButton("Done");

    //creating the initial checkboxes for the burgers
    JCheckBox burger = new JCheckBox("Burger", false);
    JCheckBox doubleBurger = new JCheckBox("Double Burger", false);
    
    //creating the checkboxes for the additional items for the burger(s)
    //as well as the button group, which allows the user to only choose
    //one of the three items
    JCheckBox lettuce = new JCheckBox("Lettuce", false);
    JCheckBox cheese = new JCheckBox("Cheese", false);
    JCheckBox pickles = new JCheckBox("Pickles", false);
    ButtonGroup group = new ButtonGroup();

    //creating the checkboxes for the soda
    JCheckBox small = new JCheckBox("Small Soda", false);
    JCheckBox medium = new JCheckBox("Medium Soda", false);
    JCheckBox large = new JCheckBox("Large Soda", false);

    public BobBurger(){
        //initializing the JFrame by giving it a title, making sure the
        //program exits entirely when closed, and setting the layout so that
        //each individual item is displayed nicely
        super("Order some food!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        label.setFont(new Font("Times New Roman", Font.PLAIN, 18));

        //adding the three "topping" checkboxes to the group so that they
        //are mutually exclusive
        group.add(lettuce);
        group.add(cheese);
        group.add(pickles);

        //adding the label, all the checkboxes and the button to the JFrame
        add(label);
        add(burger);
        add(doubleBurger);
        add(lettuce);
        add(cheese);
        add(pickles);
        add(small);
        add(small);
        add(medium);
        add(large);
        add(button);

        //adding the correct event listener for each checkbox + button
        burger.addItemListener(this);
        doubleBurger.addItemListener(this);
        lettuce.addItemListener(this);
        cheese.addItemListener(this);
        pickles.addItemListener(this);
        small.addItemListener(this);
        medium.addItemListener(this);
        large.addItemListener(this);

        button.addActionListener(this);

    }

    public void itemStateChanged(ItemEvent e) { 
        //alternatively, the adding up of the cost that is done in actionPerformed 
        //could be done in this method using the 'getStateChange()' method 
        //to see if something was selected or deselected and then accordingly
        //use the 'getItem()' method to get the object and increase the cost from there

        //i chose to do it in actionPerformed just because I felt the code would be a
        //little shorter
    }

    //this is the method that is called when the button is pressed
    public void actionPerformed(ActionEvent e) {
        //go through each checkbox, and if it's selected, then add the
        //cost of that item to the total price of the order
        if(burger.isSelected()){
            cost += 5;
        } 
        if(doubleBurger.isSelected()){
            cost += 7;
        }
        if(lettuce.isSelected()){
            cost += 0.25;
        }
        if(cheese.isSelected()){
            cost += 0.25;
        }
        if(pickles.isSelected()){
            cost += 0.25;
        }
        if(small.isSelected()){
            cost += 1.5;
        }
        if(medium.isSelected()){
            cost += 2;
        }
        if(large.isSelected()){
            cost += 3;
        }
        //tell the user how much they have to pay for the order
        JOptionPane.showMessageDialog(null, "The final total is $" + cost);
        //resetting the cost so when someone else makes a new order, it does
        //not take in the previous order's cost
        cost = 0.0;
    }

    public static void main(String[] args){
        //instantiating the class and making the JFrame visible
        BobBurger burgers = new BobBurger();
        burgers.setSize(245, 200);
        burgers.setVisible(true);
    }

}
