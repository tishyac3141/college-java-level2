package java_graphics.lesson8;

import javax.swing.*;

import java_graphics.lesson6.BorderLocation;

import java.awt.*;
import java.awt.event.*;

public class Blackjack extends JPanel implements ActionListener {
    
    private int cards[] = new int[52];
    private boolean whichCard[] = new boolean[52];
    private int index;
    
    private JButton hit = new JButton("Hit");
    private boolean newCard = false;
    private JButton stay = new JButton("Stay");
    private boolean gameOver = false;
    private JButton reset = new JButton("Reset");
    private boolean resetting = false;

    private int width = 680;
    private int count = 2;

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
        add(hit, BorderLayout.PAGE_END);
        add(stay, BorderLayout.PAGE_END);
        add(reset, BorderLayout.PAGE_END);

        stay.addActionListener(this);
        hit.addActionListener(this);
        reset.addActionListener(this);

        repaint();

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        if(resetting){

        } 
        else if(gameOver){

        } 
        else if(newCard){
            
        }
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(hit)){ 
            newCard = true;
            gameOver = false;
            resetting = false;
        } 
        else if(e.getSource().equals(stay)){
            gameOver = true;
            newCard = false;
            resetting = false;
        }
        else{
            for(int i = 0; i < whichCard.length; i++){
                whichCard[i] = false;
            }
            resetting = true;
            newCard = false;
            gameOver = false;
        }

        repaint();
    }

    public static void main(String[] args){
        Blackjack blackjack = new Blackjack();
    }

}
