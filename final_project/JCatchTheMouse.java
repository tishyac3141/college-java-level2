package final_project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalTime;

/**
 * @author: Tishya Chhabra 
 * Date: 11/28/2020
 * 
 * A graphics program that tests your clicking skills! try to click the x ten times as 
 * fast and as accurately as you can!
 * 
 * Scroll down to find the main() method and run the code.
 */

public class JCatchTheMouse extends JFrame implements ActionListener {

    private Container cont = this.getContentPane();
    private GridLayout layout = new GridLayout(8, 6);
    private JButton[][] buttons = new JButton[8][6];

    private int numOfHits = 0;
    private double numOfClicks = 1.0;
    private JButton currentX = new JButton();

    private int startInSeconds;

    public JCatchTheMouse() {
        setSize(650, 650);
        setLayout(layout);

        LocalTime time = LocalTime.now();
        startInSeconds = (time.getMinute() * 60) + time.getSecond();


        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[0].length; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].addActionListener(this);
                cont.add(buttons[i][j]);
            }
        }
        resetX();
        setVisible(true);

    }

    //putting the x in a new random spot for the user to click
    public void resetX() {
        int row = (int) (Math.random() * 7);
        int column = (int) (Math.random() * 5);

        currentX.setText("");

        currentX = buttons[row][column];
        currentX.setText("X");
    }

    //checks if the user clicked the correct button or not
    public boolean isCorrect(JButton pressed) {
        if (pressed.equals(currentX)) {
            numOfHits++;
            return true;
        } else {
            return false;
        }
    }

    //gets the timestamp of how long the user took to get ten correct
    public String getTimeStamp(){
        LocalTime endTime = LocalTime.now();
        int endInSeconds = (endTime.getMinute() * 60) + endTime.getSecond();

        int minutes = (endInSeconds - startInSeconds)/60;
        int seconds = (endInSeconds - startInSeconds)%60;
                
        String totalTime;
        if(minutes == 0){
            totalTime = minutes + ":" + seconds + " seconds";
        } else {
            totalTime = minutes + ":" + seconds + " minutes";
        }

        return totalTime;
    }

    //called when the a button is pressed; bulk of action happens here
    public void actionPerformed(ActionEvent e) {
        numOfClicks++;
        if (isCorrect((JButton) (e.getSource()))) {
            JOptionPane.showMessageDialog(null, "Nice job! You hit the correct one!");
            
            //if they've clicked 10 times ACCURATELY, then the message is displayed with their
            //accuracy as well has how long they took
            if (numOfHits == 10){
                double percentage = ((numOfHits / (numOfClicks - 1)) * 100.0);
                String totalTime = getTimeStamp();
                
                JOptionPane.showMessageDialog(null,
                        "Congratulations! You correctly hit 10 with an accuracy of " + String.format("%.2f", percentage) + "% in " + totalTime);

                //resetting the timestamp in case they want to try again
                startInSeconds = (LocalTime.now().getMinute() * 60) + LocalTime.now().getSecond();
            }
            resetX();
        } else {
            JOptionPane.showMessageDialog(null, "Oh no! You missed! Try again.");
        }

    }

    public static void main(String[] args) {
        JCatchTheMouse mouse = new JCatchTheMouse();
    }

}
