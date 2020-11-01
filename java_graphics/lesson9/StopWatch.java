package java_graphics.lesson9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author Tishya Chhabra
 * Date: 10/31/2020
 * 
 * A basic implementation of a stopwatch! with a start and stop button, when
 * the start button is pressed, the program keep tracks of how much time has elapsed 
 * and when the stop button is pressed, it displays how much time passsed.
 * Note: due to thread issues, I could not make it so that the time elapsed
 * is constantly being updated, but I know it would be possible with multithreading.
 */

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

        //setting the alignment + adding a nice border to the JPanel
        setAlignmentX(Component.CENTER_ALIGNMENT);
        setBorder(BorderFactory.createTitledBorder("Stopwatch"));

        start.addActionListener(this);
        stop.addActionListener(this);

        frame.setSize(400, 400);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        //this is something cool I found: if 'null' is passed into this method,
        //then the frame will pop up in the center of the screen
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }

    public void paintComponent(Graphics g) {
        //going through and depending on how much time has elapsed,
        //displaying it in the proper format (for ex, if only seconds have passed, then
        //having the "0:" in front of the number)
        
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
        //a message is shown so that the user knows the time actually started, since
        //my program does not update the time elapsed in real time
        JOptionPane.showMessageDialog(null, "Your time has started! Press 'Stop' to see how much time has elapsed.");
        timeStamp = System.currentTimeMillis();
        display();
    }

    public void display(){
        //updating how much time has passed before repainting
        elapsedTime = (double)((System.currentTimeMillis() - timeStamp) / 1000.0); 
        repaint();
    }

    //this method is called whenever either of the buttons is pressed
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