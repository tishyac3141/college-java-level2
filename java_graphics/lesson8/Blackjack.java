package java_graphics.lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author Tishya Chhabra
 * Date: 10/17/2020
 */

public class Blackjack extends JFrame implements ActionListener {
    
    private int cards[] = new int[52];
    private boolean whichCard[] = new boolean[52];
    private int count = 0;
    
    private int[] userValues = new int[26];
    private int userCount = 0;
    private int userIndex = 0;
    
    private int[] computerValues = new int[26];
    private int computerCount = 0;
    private int computerIndex = 0;

    private JButton hit = new JButton("Hit");
    private JButton stay = new JButton("Stay");
    private JButton reset = new JButton("Reset");

    private DrawingCards canvas = new DrawingCards();

    private int index; 

    public Blackjack(){
        for(int i = 0; i < 9; i++){
            cards[i] = i + 2;
            cards[i + 9] = i + 2;
            cards[i + 18] = i + 2;
            cards[i + 27] = i + 2;
        }

        for(int i = 0; i < 4; i++){
            cards[i + 36] = 10;
            cards[i + 40] = 10;
            cards[i + 44] = 10;
            cards[i + 48] = 11;
        }

        for(int i = 0; i < whichCard.length; i++){
            whichCard[i] = false;
        }

        setLayout(new BorderLayout());
        setSize(680, 680);
        add(hit, BorderLayout.SOUTH);
        add(stay, BorderLayout.SOUTH);
        add(reset, BorderLayout.SOUTH);
        add(canvas, BorderLayout.CENTER);

        stay.addActionListener(this);
        hit.addActionListener(this);
        reset.addActionListener(this);


        for(int i = 0; i < 4; i++){
            index = (int)(Math.random() * 52);

            if(i < 2){
                while(!whichCard[index]){
                    index = (int)(Math.random() * 52);
                }
                userValues[userIndex] = cards[index];
                whichCard[index] = true;
                canvas.addCard(userValues[userIndex]);
                userCount += userValues[userIndex];
                userIndex++;
            } else {
                while(!whichCard[index]){
                    index = (int)(Math.random() * 52);
                }
                computerValues[computerIndex] = cards[index];
                whichCard[index] = true;
                computerCount += computerValues[computerIndex];
                computerIndex++;
            }
           
        }

        count += 4;

    }


    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(hit)){ 
            if(count == 52){
                JOptionPane.showMessageDialog(null, "The deck has no more cards! Game over! Click 'stay' to reset.");
            }

            while(!whichCard[index] && count < 52){
                index = (int)(Math.random() * 52);
            }
            userValues[userIndex] = cards[index];
            whichCard[index] = true;
            canvas.addCard(userValues[userIndex]);
            userCount += userValues[userIndex];
            userIndex++;

            if(computerCount < 21){
                while(!whichCard[index] && count < 52){
                    index = (int)(Math.random() * 52);
                }
                computerValues[computerIndex] = cards[index];
                whichCard[index] = true;
                computerCount += computerValues[computerIndex];
                computerIndex++;
            }
            
            
        } 

        else if(e.getSource().equals(stay)){

            if(computerCount == 21 && userCount == 21){
                JOptionPane.showMessageDialog(null, "It's a tie!");;
            }
            else if(computerCount == 21){
                JOptionPane.showMessageDialog(null, "You lost!");
            }
            else if(userCount == 21){
                JOptionPane.showMessageDialog(null, "You win!");
            }
            else {
                JOptionPane.showMessageDialog(null, "Nobody won this round.");
            }
        }

        else{
            for(int i = 0; i < whichCard.length; i++){
                whichCard[i] = false;
            }
            for(int i = 0; i < userValues.length; i++){
                userValues[i] = 0;
            }
            for(int i = 0; i < computerValues.length; i++){
                computerValues[i] = 0;
            }
            userCount = 0;
            computerCount = 0;
            canvas.reset();
        }
    }

    public static void main(String[] args){
        Blackjack blackjack = new Blackjack();
        blackjack.setVisible(true);
    }
}
