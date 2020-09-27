package graphics.lesson5;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class BobBurger extends JFrame implements ItemListener, ActionListener {

    double cost = 0;

    JLabel label = new JLabel("What would you like to order?");
    JButton button = new JButton("Done");

    JCheckBox burger = new JCheckBox("Burger", false);
    JCheckBox doubleBurger = new JCheckBox("Double Burger", false);
    
    JCheckBox lettuce = new JCheckBox("Lettuce", false);
    JCheckBox cheese = new JCheckBox("Cheese", false);
    JCheckBox pickles = new JCheckBox("Pickles", false);
    ButtonGroup group = new ButtonGroup();

    JCheckBox small = new JCheckBox("Small Soda", false);
    JCheckBox medium = new JCheckBox("Medium Soda", false);
    JCheckBox large = new JCheckBox("Large Soda", false);

    public BobBurger(){
        super("Order some food!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        label.setFont(new Font("Times New Roman", Font.PLAIN, 18));

        group.add(lettuce);
        group.add(cheese);
        group.add(pickles);

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

    public void actionPerformed(ActionEvent e) {
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
        JOptionPane.showMessageDialog(null, "The final total is $" + cost);
        cost = 0.0;
    }

    public static void main(String[] args){
        BobBurger burgers = new BobBurger();
        burgers.setSize(245, 200);
        burgers.setVisible(true);
    }

}
