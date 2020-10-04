package graphics.lesson6;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class BorderLocation extends JFrame implements ActionListener{
    
    private Container cont = getContentPane();
    private JButton northButton = new JButton();
    private JButton eastButton = new JButton();
    private JButton southButton = new JButton();
    private JButton westButton = new JButton();
    private JButton centerButton = new JButton();

    public BorderLocation(){
        cont.setLayout(new BorderLayout());
        setSize(300, 250);

        northButton.addActionListener(this);
        southButton.addActionListener(this);
        westButton.addActionListener(this);
        eastButton.addActionListener(this);
        centerButton.addActionListener(this);

        cont.add(northButton, BorderLayout.NORTH);
        cont.add(southButton, BorderLayout.SOUTH);
        cont.add(eastButton, BorderLayout.EAST);
        cont.add(westButton, BorderLayout.WEST);
        cont.add(centerButton, BorderLayout.CENTER);

    }

    public void actionPerformed(ActionEvent e) {
        Object clicked = e.getSource();
        if(clicked.equals(centerButton)){
            JOptionPane.showMessageDialog(null, "Center!!");
        } 
        else if(clicked.equals(northButton)){
            JOptionPane.showMessageDialog(null, "North!");
        }
        else if(clicked.equals(southButton)){
            JOptionPane.showMessageDialog(null, "South!");
        }
        else if(clicked.equals(eastButton)){
            JOptionPane.showMessageDialog(null, "East!");
        }
        else if(clicked.equals(westButton)){
            JOptionPane.showMessageDialog(null, "West!");
        }
    }

    public static void main(String[] args){
        BorderLocation bloc = new BorderLocation();
        bloc.setVisible(true);
    }

}
