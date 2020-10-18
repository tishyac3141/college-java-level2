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

        repaint();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        if(isFlipped){
            g.drawPolygon(new int[] {460, 220, 340}, new int[] {200, 200, 400}, 3);
        } else {
            g.drawPolygon(new int[] {340, 220, 460}, new int[] {200, 400, 400}, 3);
        }
    }

    public void actionPerformed(ActionEvent e) {
        isFlipped = !isFlipped;
        repaint();
    }

    public static void main(String[] args){
        JFrame frame = new JFrame();
        frame.setSize(680, 680);
        Triangle triangle = new Triangle();
        frame.add(triangle);
        frame.setVisible(true);
    }

    
}
