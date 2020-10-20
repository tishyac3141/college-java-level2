package java_graphics.lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author Tishya Chhabra 
 * Date: 10/17/2020
 * 
 */

public class Blackjack extends JFrame implements ActionListener {

    BlackjackLogic logic = new BlackjackLogic();

    private JPanel buttons = new JPanel();
    private JButton hit = new JButton("Hit");
    private JButton stay = new JButton("Stay");
    private JButton reset = new JButton("Reset");

    private DrawingCards canvas = new DrawingCards();
    private Container cont = getContentPane();

    private int index;

    public Blackjack() {

        setSize(680, 680);
        cont.setLayout(new BorderLayout());

        buttons.setLayout(new FlowLayout());
        buttons.add(hit);
        buttons.add(stay);
        buttons.add(reset);

        cont.add(buttons, BorderLayout.SOUTH);
        cont.add(canvas, BorderLayout.CENTER);

        stay.addActionListener(this);
        hit.addActionListener(this);
        reset.addActionListener(this);

        int[] startingValues = logic.start();
        for (int i = 0; i < startingValues.length; i++) {
            canvas.addCard(startingValues[i]);
            System.out.println("addCard() called with " + startingValues[i]);
        }

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(hit)) {
            int value = logic.hit();
            if (value == 0) {
                JOptionPane.showMessageDialog(null, "The deck is out of cards! Game over!");
                logic.reset();
                canvas.reset();
            } else {
                canvas.addCard(value);
            }
            setVisible(true);
        }

        else if (e.getSource().equals(stay)) {

            String outcome = logic.stay();

            if (outcome.equals("tie")) {
                JOptionPane.showMessageDialog(null, "It's a tie! Press 'reset' to play again.");
            } else if (outcome.equals("computer")) {
                JOptionPane.showMessageDialog(null, "You lost! Press 'reset' to play again.");
            } else if (outcome.equals("user")) {
                JOptionPane.showMessageDialog(null, "You win! Press 'reset' to play again.");
            } else {
                JOptionPane.showMessageDialog(null, "Nobody won this round. Press 'reset' to play again.");
            }
        }

        else {
            logic.reset();
            canvas.reset();

            JOptionPane.showMessageDialog(null, "Press the 'hit' button twice to get your first two cards.");
        }
    }

    public static void main(String[] args) {
        Blackjack blackjack = new Blackjack();
        blackjack.setVisible(true);
    }
}
