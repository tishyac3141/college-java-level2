package java_graphics.lesson9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author Tishya Chhabra
 * Date: 10/30/2020
 * 
 * 
 */

public class Vote extends JFrame implements ActionListener{

    private JButton cand1 = new JButton("Candidate 1");
    private JButton cand2 = new JButton("Candidate 2");
    private JButton results = new JButton("See Results");

    private int numForCand1 = 0;
    private int numForCand2 = 0;

    public Vote(){

        setSize(680, 400);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(cand1);
        add(cand2);
        add(results);

        cand1.addActionListener(this);
        cand2.addActionListener(this);
        results.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        Object pressed = e.getSource();

        if(pressed.equals(cand1)){
            numForCand1++;
            JOptionPane.showMessageDialog(null, "You voted for " + cand1.getText());

            String message = "Votes for Candidate 1: " + numForCand1 + "\n" + "Votes for Candidate 2: " + numForCand2;
            JOptionPane.showMessageDialog(null, message);

        } else if(pressed.equals(cand2)){
            numForCand2++;
            JOptionPane.showMessageDialog(null, "You voted for " + cand2.getText());

            String message = "Votes for Candidate 1: " + numForCand1 + "\n" + "Votes for Candidate 2: " + numForCand2;
            JOptionPane.showMessageDialog(null, message);

        } else if(pressed.equals(results)){
            String message = "Votes for Candidate 1: " + numForCand1 + "\n" + "Votes for Candidate 2: " + numForCand2;
            JOptionPane.showMessageDialog(null, message);
        }

    }

    public static void main(String[] args){
        Vote vote = new Vote();
        vote.setVisible(true);
    }
    
}
