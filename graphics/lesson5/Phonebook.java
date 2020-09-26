package graphics.lesson5;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Phonebook extends JFrame implements ActionListener {

    String[] listOfNames = { "Bob", "Sally", "Mike", "Alice", "Tom" };
    String[] numbers = {"480-123-5689", "254-897-6354", "610-897-4321", "480-569-7413", "480-632-5541"};
    JLabel label = new JLabel("Who would you like to call?");
    JComboBox names = new JComboBox(listOfNames);

    public Phonebook(){
        super("Phonebook");
        setSize(480, 320);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setResizable(true);

        names.addActionListener(this);

        add(label);
        add(names);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        int position = names.getSelectedIndex();
        JOptionPane.showMessageDialog(null, listOfNames[position] + "'s number is " + numbers[position]);
    }

    public static void main(String[] args){
        Phonebook phonebook = new Phonebook();
    }
    
}
