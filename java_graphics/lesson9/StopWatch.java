package java_graphics.lesson9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StopWatch extends JFrame implements ActionListener{

    private boolean isStart = false;
    

    private JButton start = new JButton("Start");
    private JButton stop = new JButton("Stop");
    private JLabel time = new JLabel("00:00");

    public StopWatch(){
        setSize(400, 400);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        time.setFont(new Font("Times New Roman", Font.PLAIN, 28));
        add(start);
        add(stop);
        add(time);

        start.addActionListener(this);
        start.addActionListener(this);
    }

    public void start(){

    }

    public void stop(){

    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(start)){
            if(isStart){
                JOptionPane.showMessageDialog(null, "You already started the clock!");
            } else {
                isStart = true;
                start();
            }
        } else {
            isStart = false;
            stop();
        }

    }

    public static void main(String[] args){
        StopWatch stopwatch = new StopWatch();
        stopwatch.setVisible(true);
    }

    
}