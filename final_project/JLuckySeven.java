package final_project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author Tishya Chhabra
 * Date: 11/25/2020
 */

public class JLuckySeven extends JPanel implements ActionListener{

    int[][] values = new int[7][2];

    JButton card1 = new JButton("1");
    JButton card2 = new JButton("2");
    JButton card3 = new JButton("3");
    JButton card4 = new JButton("4");
    JButton card5 = new JButton("5");
    JButton card6 = new JButton("6");
    JButton card7 = new JButton("7");

    private JFrame frame = new JFrame();

    public JLuckySeven(){
        for(int i = 0; i < values[0].length; i++){
            if(i < 3){
                values[i][0] = values[0].length - i;
            } else {
                values[i][0] = i - 2;
            }

            values[i][1] = 0;

            System.out.println(values[i][0]);
        }
        setSize(650, 400);
        setLayout(new FlowLayout());
        setAlignmentX(Component.CENTER_ALIGNMENT);

        this.add(card1);
        this.add(card2);
        this.add(card3);
        this.add(card4);
        this.add(card5);
        this.add(card6);
        this.add(card7);

        card1.addActionListener(this);
        card2.addActionListener(this);
        card3.addActionListener(this);
        card4.addActionListener(this);
        card5.addActionListener(this);
        card6.addActionListener(this);
        card7.addActionListener(this);

        frame.setSize(650, 400);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.setLocationRelativeTo(null);

        this.setVisible(true);
        frame.setVisible(true);

    }

    
    public void actionPerformed(ActionEvent e) {
        Object pressed = e.getSource();

        if(pressed.equals(card1)){

        } else if(pressed.equals(card2)) {

        } else if(pressed.equals(card3)) {

        } else if(pressed.equals(card4)) {

        } else if(pressed.equals(card5)) {

        } else if(pressed.equals(card6)) {

        } else if(pressed.equals(card7)) {

        } else{
            System.out.println("none of the buttons were pressed");
        }

    }
    
}
