package java_graphics.lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author Tishya Chhabra 
 * Date: 10/17/2020
 * 
 * THINGS TO NOTE:
 *   a) I split the drawing the actual "card" and the actual logic into different classes
 *      for the sake of organization and ease... hopefully that's okay. 
 *   b) I did not draw rectangles to show cards because I was not able to figure out
 *      the math in time so that the cards would be evenly spaced each time the user pressed hit... 
 *      I think I was just too tired to figure it out.
 *   c) When the user clicks reset, they have to click 'hit' twice in order to get their
 *      first two cards; this is because I tried to completely reset AND deal 2 cards
 *      but for some reason that would not work :(
 * 
 * CLass Info: a basic implementation of the game blackjack using Java! play against the
 * computer in this tantalizing game of chance. 
 * Uses two helper classes: BlackjackLogic and DrawingCards in order to efficiently implement
 * the logic of the game. Using multiple JPanels and BorderLayout, buttons are on the bottom right
 * to take a card, finish the game, and reset to play another round. On the center of the screen,
 * the user's cards will be revealed.       
 * 
 */

public class Blackjack extends JFrame implements ActionListener {

    //creating the logic class (see it for details)
    BlackjackLogic logic = new BlackjackLogic();

    //creating a seperate panel where the jbuttons will reside so that multiple buttons
    //can be in one section of the borderLayout (this took me a bit to figure out)
    private JPanel buttons = new JPanel();
    //creating all three jButtons
    private JButton hit = new JButton("Hit");
    private JButton stay = new JButton("Stay");
    private JButton reset = new JButton("Reset");

    private DrawingCards canvas = new DrawingCards();
    private Container cont = getContentPane();

    public Blackjack() {

        setSize(680, 680);
        cont.setLayout(new BorderLayout());

        //making the special jPanel for the buttons have flowLayout so the buttons are 
        //side-by-side
        buttons.setLayout(new FlowLayout());
        buttons.add(hit);
        buttons.add(stay);
        buttons.add(reset);

        cont.add(buttons, BorderLayout.SOUTH);
        cont.add(canvas, BorderLayout.CENTER);

        stay.addActionListener(this);
        hit.addActionListener(this);
        reset.addActionListener(this);

        //when the game starts, the user starts with 2 cards. we take the array
        //returned by logic with the 2 values and pass it into the drawingCards
        //method so that they are drawn on the screen and the user knows what cards they have
        int[] startingValues = logic.start();
        for (int i = 0; i < startingValues.length; i++) {
            canvas.addCard(startingValues[i]);
        }

        setVisible(true);
    }

    //called when any of the three buttons are hit
    public void actionPerformed(ActionEvent e) {

        //if 'hit' is pressed, that means the user wants another card
        if (e.getSource().equals(hit)) {
            //we get the value of the new card by calling the 'hit()' method of logic
            int value = logic.hit();
            //if the value is 0, that means the full deck of cards has been used
            if (value == 0) {
                JOptionPane.showMessageDialog(null, "The deck is out of cards! Game over!");
                logic.reset();
                canvas.reset();
            } else {
                //pass in that value to our drawingCards method so that it's drawn on the screen
                canvas.addCard(value);
            }
            setVisible(true);
        }

        //if 'stay' is pressed, that means the user is done with the game and wants to know the results
        else if (e.getSource().equals(stay)) {

            //to get the outcome, we call the 'stay()' method of logic
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
        //at this point, the only other button that could've been pressed is 'reset'
        else {
            logic.reset();
            canvas.reset();

            //extra message because my code wouldn't work so the user has to press 'hit' twice
            //to get their first 2 cards
            JOptionPane.showMessageDialog(null, "Press the 'hit' button twice to get your first two cards.");
        }
    }

    public static void main(String[] args) {
        Blackjack blackjack = new Blackjack();
        blackjack.setVisible(true);
    }
}
