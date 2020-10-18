package java_graphics.lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author Tishya Chhabra
 * Date: 10/17/2020
 * Class description: A class with a button that when clicked will
 * flip the triangle on the screen!
 */

public class Triangle extends JPanel implements ActionListener{

    //creating the button as well as variable to keep track of whether
    //or not it's been flipped
    private JButton flip = new JButton("Flip!");
    boolean isFlipped = false;

    public Triangle(){
        //setting the size of the JPanel
        setSize(500, 500);        
        
        //adding the button to the panel and adding the correct
        //actionListener for the button
        add(flip);
        flip.addActionListener(this);

        //calling repaint() so that the triangle is drawn on the screen
        repaint();
    }

    public void paintComponent(Graphics g){
        //calling the superclass' method
        super.paintComponent(g);

        //if it is flipped, then accordingly drawing the triangle back to 
        //the original position
        if(isFlipped){
            g.drawPolygon(new int[] {350, 150, 250}, new int[] {200, 200, 400}, 3);
        } else {
            g.drawPolygon(new int[] {250, 150, 350}, new int[] {200, 400, 400}, 3);
        }
    }

    //called when the button is pressed
    public void actionPerformed(ActionEvent e) {
        //updating the variable and then calling repaint() so that
        //the triangle's position is updated accordingly
        isFlipped = !isFlipped;
        repaint();
    }

    public static void main(String[] args){
        //making a JFrame to put our 'Triangle' class in and setting it visible
        JFrame frame = new JFrame();
        frame.setSize(500, 500);
        Triangle triangle = new Triangle();
        frame.add(triangle);
        frame.setVisible(true);
    }

    
}
