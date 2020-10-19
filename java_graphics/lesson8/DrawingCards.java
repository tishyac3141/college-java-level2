package java_graphics.lesson8;

import javax.swing.*;
import java.awt.*;

public class DrawingCards extends JPanel {

    private int value = 0;
    private int numOfCards = 0;
    private final int WIDTH = 680;
    private final int HEIGHT = 340;

    private boolean reset;
    private boolean addCard;

    public DrawingCards(){
        setSize(WIDTH, HEIGHT);
    }

    public void reset(){
        reset = true;
        repaint();
    }

    public void addCard(int value){
        this.value = value;
        addCard = true;
        repaint();
    }


    public void paintComponent(Graphics g){

        if(reset){
            reset = false;
        }
        else if(addCard){
            g.drawRect(WIDTH/numOfCards, HEIGHT/2, 50, 50);
            g.drawString(Integer.toString(value), (WIDTH/numOfCards) + 50, (HEIGHT/2) + 50);
            addCard = false;
        }

        setVisible(true);
    }
    
}
