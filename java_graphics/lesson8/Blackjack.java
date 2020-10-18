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
    private JButton stay = new JButton("Stay");
    private JButton reset = new JButton("Reset");

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


        setLayout(new BorderLayout());
        add(hit, BorderLayout.PAGE_END);
        add(stay, BorderLayout.PAGE_END);
        add(reset, BorderLayout.PAGE_END);

        stay.addActionListener(this);
        hit.addActionListener(this);
        reset.addActionListener(this);

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }

    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args){
        Blackjack blackjack = new Blackjack();
    }

}
