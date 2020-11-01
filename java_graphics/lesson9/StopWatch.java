package java_graphics.lesson9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StopWatch extends JPanel implements ActionListener{

    private long timeStamp;
    private double elapsedTime;

    private JFrame frame = new JFrame();
    private JButton start = new JButton("Start");
    private JButton stop = new JButton("Stop");
    private JLabel time = new JLabel("00:00");

    public StopWatch(){
        setSize(300, 300);
        setLayout(new FlowLayout());

        time.setFont(new Font("Times New Roman", Font.PLAIN, 28));
        add(start);
        add(stop);
        add(time);

        setAlignmentX(Component.CENTER_ALIGNMENT);
        setBorder(BorderFactory.createTitledBorder("Stopwatch"));

        start.addActionListener(this);
        stop.addActionListener(this);

        frame.setSize(400, 400);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }

    public void paintComponent(Graphics g) {
        if(elapsedTime >= 60){
            if(elapsedTime >= 3600){
                int hours = (int)(elapsedTime/3600);
                int minutes = (int)(elapsedTime%60);
                int seconds = (int)(elapsedTime%3600);
                
                String message = String.valueOf(hours) + ":" + String.valueOf(minutes) + ":" + String.valueOf(seconds);
                time.setText(message);
                
            } else {
                int minutes = (int)(elapsedTime/60);
                
                if(minutes <= 9){
                    String message = "0:0" + String.valueOf(minutes);
                    time.setText(message);
                } else {
                    String message = "0:" + String.valueOf(minutes);
                    time.setText(message);
                }
                
            }
        } else {
            int seconds = (int)(elapsedTime%60);
            if(seconds <= 9){
                time.setText("0:0" + seconds);
            } else {
                time.setText("0:" + seconds);
            }
            
        }

    }

    public void start(){
        JOptionPane.showMessageDialog(null, "Your time has started! Press 'Stop' to see how much time has elapsed.");
        timeStamp = System.currentTimeMillis();
        display();
    }

    public void display(){
        elapsedTime = (double)((System.currentTimeMillis() - timeStamp) / 1000.0); 
        repaint();
    }

    public void actionPerformed(ActionEvent e) {
        Object pressed = e.getSource();
        if(pressed.equals(start)){
            start();
        } else {
            display();
        }
    }

    public static void main(String[] args){
        StopWatch stopwatch = new StopWatch();
        stopwatch.setVisible(true);
    }
    
}