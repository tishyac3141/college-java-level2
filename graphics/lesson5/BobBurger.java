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
    JCheckBox small = new JCheckBox("Small Soda", false);
    JCheckBox medium = new JCheckBox("Medium Soda", false);
    JCheckBox large = new JCheckBox("Large Soda", false);

    public BobBurger(){
        super("Order some food!");
        setSize(680, 420);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        label.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        burger.addItemListener(this);
        doubleBurger.addItemListener(this);
        lettuce.addItemListener(this);
        cheese.addItemListener(this);
        pickles.addItemListener(this);
        small.addItemListener(this);
        medium.addItemListener(this);
        large.addItemListener(this);

        button.addActionListener(this);

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

        setVisible(true);
    }


    public void itemStateChanged(ItemEvent e) { }

    public void actionPerformed(ActionEvent e) {
        if(burger.isSelected()){
            cost += 5;
        } 
        if(doubleBurger.isSelected()){
            cost += 7;
        }
        if(lettuce.isSelected()){
            cost += 0.10;
        }
        if(cheese.isSelected()){
            cost += 0.10;
        }
        if(pickles.isSelected()){
            cost += 0.10;
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
    }

    public static void main(String[] args){
        BobBurger burgers = new BobBurger();
    }

}
