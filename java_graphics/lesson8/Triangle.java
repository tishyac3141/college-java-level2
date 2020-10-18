package java_graphics.lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Triangle extends JPanel implements ActionListener{

    private JButton flip = new JButton("Flip!");
    boolean isFlipped = false;

    public Triangle(){
        setSize(680, 680);        

        add(flip);
        flip.addActionListener(this);

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }

    public void actionPerformed(ActionEvent e) {

    }

    
}
