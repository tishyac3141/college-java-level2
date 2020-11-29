package final_project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author: Tishya Chhabra Date: 11/27/2020
 * 
 * A fun game of chance! Choose 6 random numbers and see if you win the lottery.
 * Depending on how many numbers match, you'll win a certain amount of money!
 * There's also an about menu option, where you can find information about the author.
 * 
 * Scroll down to the bottom for the main method to run it!
 */

public class JLottery2 extends JFrame implements ActionListener, ItemListener {

    private JCheckBox[] checkboxes = new JCheckBox[30];
    private JButton submit = new JButton("Submit");
    private JButton reset = new JButton("Reset");

    private JMenuBar menu = new JMenuBar();
    private JMenu file = new JMenu("File");
    private JMenuItem about = new JMenuItem("About");

    private final int MAX_SELECTIONS = 6;
    private int numSelected = 0;
    private boolean[] generated = new boolean[30];

    public JLottery2() {

        setSize(650, 650);
        setLayout(new GridLayout(6, 5));
        setJMenuBar(menu);

        menu.add(file);
        file.add(about);
        about.addActionListener(this);

        for (int i = 0; i < checkboxes.length; i++) {
            checkboxes[i] = new JCheckBox(Integer.toString(i + 1));
            checkboxes[i].addItemListener(this);
            add(checkboxes[i]);
            checkboxes[i].setSelected(false);
            generated[i] = false;
        }

        add(submit);
        add(reset);
        submit.addActionListener(this);
        reset.addActionListener(this);

        generateRandom();
        setVisible(true);

    }

    //this method is called when the a checkbox is selected
    //if 6 checkboxes are selected, then the rest will be disabled, limiting the user
    //to only choose up to 6 numbers
    public void itemStateChanged(ItemEvent e) {
        JCheckBox pressed = (JCheckBox) (e.getSource());

        if (pressed.isSelected()) {
            numSelected++;
            if (numSelected == MAX_SELECTIONS) {
                for (int i = 0; i < checkboxes.length; i++) {
                    if (!checkboxes[i].isSelected()) {
                        checkboxes[i].setEnabled(false);
                    }
                }
            }
        } else {
            numSelected--;
            if (numSelected < MAX_SELECTIONS) {
                for (int i = 0; i < checkboxes.length; i++) {
                    checkboxes[i].setEnabled(true);
                }
            }
        }

    }

    //this method is called when the user clicks the 'submit' method
    //hence, this is where the checking takes place; depending on how many numbers match,
    //the user will win some amount of money
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(submit)) {
            int numMatching = 0;
            String generatedNumber = "";
            String userNumber = "";

            //going through and compiling how many match as well as what numebers the user 
            //selected and what were generated so that both can be shown for the user to see
            for (int i = 0; i < generated.length; i++) {
                if (generated[i] && checkboxes[i].isSelected()) {
                    numMatching++;
                    generatedNumber += Integer.toString(i + 1) + " ";
                    userNumber += Integer.toString(i + 1) + " ";
                } else if (checkboxes[i].isSelected()) {
                    userNumber += Integer.toString(i + 1) + " ";
                } else if(generated[i]){
                    generatedNumber += Integer.toString(i + 1) + " ";
                }

            }
            JOptionPane.showMessageDialog(null,
                    "The number you made was: " + userNumber + "\nThe lottery number was: " + generatedNumber);

            //depending on how many match, the user wins either $100, $10,000, $50,000 or $1,000,000
            if (numMatching == 6) {
                JOptionPane.showMessageDialog(null, "Congratulations! The numbers match! You made $1,000,000!");
            } else if (numMatching == 5) {
                JOptionPane.showMessageDialog(null, "Congratulations! 5 of the numbers match! You made $50,000!");
            } else if (numMatching == 4) {
                JOptionPane.showMessageDialog(null, "Congratulations! 4 of the numbers match! You made $10,000!");
            } else if (numMatching == 3) {
                JOptionPane.showMessageDialog(null, "Congratulations! 3 of the numbers match! You made $100!");
            } else {
                JOptionPane.showMessageDialog(null, "Oh no! No numbers match! You made no money.");
            }

        } else if (e.getSource().equals(reset)) {
            reset();
        } else if (e.getSource() == about) {
            String info = "\nname: Tishya Chhabra \nCourse Number: CIS263AA\nClass 28649\nMEID:2130581";
            JOptionPane.showMessageDialog(null, info);
        }

    }

    //this method generates random numbers; there is an array, which holds either true or false
    //if the element at that position is true, that means that number is generated and is part of
    //the sequence of numbers
    public void generateRandom() {
        int tempRandom = 0;
        for (int i = 0; i < 6; i++) {
            if (i == 0) {
                tempRandom = ((int) (Math.random() * 30) + 1);
                generated[tempRandom - 1] = true;

            } else {
                while (generated[tempRandom - 1]) {
                    tempRandom = ((int) (Math.random() * 30) + 1);
                }
                generated[tempRandom - 1] = true;
            }
            //System.out.println("tempRandom = " + tempRandom);
        }
    }

    //this method is called when the user presses the reset button so they can play another round
    public void reset() {
        for (int i = 0; i < checkboxes.length; i++) {
            checkboxes[i].setEnabled(true);
            checkboxes[i].setSelected(false);
            generated[i] = false;
        }
        numSelected = 0;
        generateRandom();
    }

    //run this to see it in action!
    public static void main(String[] args) {
        JLottery2 lottery = new JLottery2();
    }

}
