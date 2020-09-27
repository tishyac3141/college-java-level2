package graphics.lesson5;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class BobBurger extends JFrame implements ItemListener {

    JLabel label = new JLabel("What would you like to order?");
    JCheckBox burger = new JCheckBox("Burger", false);
    JCheckBox lettuce = new JCheckBox("Lettuce", false);
    JCheckBox cheese = new JCheckBox("Cheese", false);
    JCheckBox pickles = new JCheckBox("Pickles", false);
    JCheckBox soda = new JCheckBox("Soda", false);
    JCheckBox small = new JCheckBox("Small", false);
    JCheckBox medium = new JCheckBox("Medium", false);
    JCheckBox large = new JCheckBox("Large", false);

    public BobBurger(){
        super("Order some food!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        label.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        burger.addItemListener(this);
        lettuce.addItemListener(this);
        cheese.addItemListener(this);
        pickles.addItemListener(this);
        soda.addItemListener(this);
        small.addItemListener(this);
        medium.addItemListener(this);
        large.addItemListener(this);

        add(burger);
        add(lettuce);
        add(cheese);
        add(pickles);
        add(small);
        add(soda);
        add(small);
        add(medium);
        add(large);
    }


    public void itemStateChanged(ItemEvent e) {
       

    }

    public static void main(String[] args){

    }


}
