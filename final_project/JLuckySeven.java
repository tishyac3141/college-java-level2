package final_project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author Tishya Chhabra 
 * Date: 11/25/2020
 * 
 * A java implementation of a popular card game! play against the computer and try
 * to click on the correct combination of buttons to successfully get rid of all of them!
 * 
 * Scroll down to the bottom to find the main() method and run the code.
 * 
 * basic logic: there is an array that keeps track of the button's values as well as
 * whether that value has already been picked or not (with either a 1 or 0)
 * 
 */

public class JLuckySeven extends JPanel implements ActionListener {

    private JFrame frame = new JFrame();

    private int[][] values = new int[7][2];
    private JButton[] buttons = new JButton[7];

    private JButton needToPress;
    private boolean press = false;

    private JLabel tally = new JLabel("Number of games won: 0\nNumber of Games lost: 0");
    private JPanel forTally = new JPanel();

    private int losses = 0;
    private int wins = 0;
    private int numPressed = 0;
    private boolean isReset = false;

    public JLuckySeven() {
        this.setSize(650, 400);
        this.setLayout(new FlowLayout());

        frame.setSize(650, 400);
        frame.setLayout(new GridLayout(2, 1));

        for (int i = 0; i < values.length; i++) {
            if (i < 3) {
                values[i][0] = values.length - i;
            } else {
                values[i][0] = i - 2;
            }

            values[i][1] = 0;

            buttons[i] = new JButton(Integer.toString(i + 1));
            this.add(buttons[i]);
            buttons[i].addActionListener(this);
        }

        frame.add(this, 0, 0);
        forTally.add(tally);
        frame.add(forTally, 1, 0);

        this.setVisible(true);
        frame.setVisible(true);
    }

    //in here, the buttons are removed, or all of them are put back on if the game is reset
    public void paintComponent(Graphics g) {

        if (isReset) {
            for (int i = 0; i < buttons.length; i++) {
                if (values[i][1] == 0)
                    this.remove(buttons[i]);
            }
            for (int i = 0; i < buttons.length; i++) {
                this.add(buttons[i]);
            }

            isReset = false;

        } else {
            for (int i = 0; i < buttons.length; i++) {
                if (values[i][1] == 1) {
                    this.remove(buttons[i]);
                }
            }
        }
        tally.setText("Number of games won: " + wins + "   Number of games lost: " + losses);

        frame.setVisible(true);
        this.setVisible(true);
    }

    //resets everything + shows the information about the author
    public void reset() {
        press = false;
        needToPress = null;

        JOptionPane.showMessageDialog(null,
                "Name: Tishya Chhabra \nCourse Number: CIS263AA\nClass 28649\nMEID: 2130581");

        for (int i = 0; i < values.length; i++) {
            buttons[i].setText(Integer.toString(i + 1));
            values[i][1] = 0;
        }
        isReset = true;
        numPressed = 0;
        repaint();
    }

    //checks whether or not the user clicked a button who's position had already been drawn
    public void correctOrIncorrect(int value) {
        JOptionPane.showMessageDialog(null, "The value is: " + value);
        if (values[value - 1][1] == 1) {
            JOptionPane.showMessageDialog(null, "You lost!");
            losses++;
            reset();
            repaint();
        } else {
            String suffix;
            if (value == 1)
                suffix = "st";
            else if (value == 2)
                suffix = "nd";
            else if (value == 3)
                suffix = "rd";
            else
                suffix = "th";
            JOptionPane.showMessageDialog(null,
                    "In order to proceed, you'll need to press the " + value + suffix + " button.");
            press = true;
        }
    }

    //gets the value of that button
    public int getValue(Object pressed) {
        int value = 0;
        for (int i = 0; i < buttons.length; i++) {
            if (pressed.equals(buttons[i])) {
                buttons[i].setText(Integer.toString(values[i][0]));
                values[i][1] = 1;
                value = values[i][0];
                needToPress = buttons[value - 1];
                break;
            }
        }
        return value;
    }

    //called when a button is pressed
    public void actionPerformed(ActionEvent e) {
        Object pressed = e.getSource();
        int value = 0;

        if (numPressed == 7) {
            JOptionPane.showMessageDialog(null, "You won!");
            wins++;
        }

        if (press) {
            if (pressed.equals(needToPress)) {
                value = getValue(pressed);
                correctOrIncorrect(value);

                press = false;
                numPressed++;

            } else {
                JOptionPane.showMessageDialog(null, "Wrong button!");
            }
        } else {
            value = getValue(pressed);
            correctOrIncorrect(value);
            numPressed++;
        }

    }

    public static void main(String[] args) {
        JLuckySeven seven = new JLuckySeven();
    }

}
