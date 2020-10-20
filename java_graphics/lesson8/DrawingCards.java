package java_graphics.lesson8;

import javax.swing.*;
import java.awt.*;

/**
 * @author Tishya Chhabra
 * Date: 10/18/2020
 * 
 * Helper class for Blackjack; takes the values and prints them out onto the panel; 
 * according to what the user presses, different things happen
 */

public class DrawingCards extends JPanel {

    //integer array to keep track of all the cards the user has
    private int[] values = new int[40];
    //variable that keeps track of how many cards the user has (and what index to add a card at)
    private int valuesIndex = 0;

    private int WIDTH = 450;
    private int HEIGHT = 450;

    //boolean variables that keep track of what operation needs to be done
    private boolean reset = false;
    private boolean addCard = true;

    public DrawingCards() {
        setSize(WIDTH, HEIGHT);
        setVisible(true);
    }

    //when the 'Blackjack' class calls this method, the variable is set to true so that
    //when the thread enters the 'paintComponent()' method, it can evaluate what to do
    public void reset() {
        reset = true;
        repaint();
    }

    public void addCard(int value) {
        values[valuesIndex] = value;
        valuesIndex++;
        addCard = true;
        repaint();
    }

    //this method is called when 'repaint()' is called
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //if we need to reset...
        if (reset) {
            //then reset all the cards back to 0 (since there are no cards now)
            for (int i = 0; i < values.length; i++) {
                values[i] = 0;
            }
            //reset the index back to 0 as well
            valuesIndex = 0;
            //change the variable back to false since resetting has been complete
            reset = false;
        }
        if (addCard) {
            //since the 'super.paintComponent()' seems to completely repaint the entire screen
            //I have to redraw each "card" everytime the method is called (this also took a 
            //bit to figure out)
            for (int i = 0; i < valuesIndex; i++) {
                int xcord = WIDTH/(valuesIndex - i);
                g.drawString(Integer.toString(values[i]), xcord, 225);
            }

            addCard = false;
            setVisible(true);
        }
    }

}
