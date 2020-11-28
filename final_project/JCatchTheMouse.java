package final_project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JCatchTheMouse extends JFrame implements ActionListener {

    private Container cont = this.getContentPane();
    private GridLayout layout = new GridLayout(8, 6);
    private JButton[][] buttons = new JButton[8][6];

    private int numOfHits = 0;
    private double numOfClicks = 1.0;
    private JButton currentX = new JButton();

    public JCatchTheMouse(){
        setSize(650, 650);
        setLayout(layout);

        for(int i = 0; i < buttons.length; i++){
            for(int j = 0; j < buttons[0].length; j++){
                buttons[i][j] = new JButton();
                buttons[i][j].addActionListener(this);
                cont.add(buttons[i][j]);
            }
        }
        resetX();
        setVisible(true);

    } 
    
    public void resetX(){
        int row = (int)(Math.random()*7);
        int column = (int)(Math.random()*5);

        currentX.setText("");

        currentX = buttons[row][column];
        currentX.setText("X");
    }

    public boolean isCorrect(JButton pressed){
          if(pressed.equals(currentX)){
              numOfHits++;
              return true;
          } else {
              return false;
          }
    }

    public void actionPerformed(ActionEvent e) {
        numOfClicks++;
        if(isCorrect((JButton)(e.getSource()))){
            JOptionPane.showMessageDialog(null, "Nice job! You hit the correct one!");
            double percentage = ((numOfHits/(numOfClicks - 1)) * 100.0);
            if(numOfHits == 10) JOptionPane.showMessageDialog(null, "Congratulations! You correctly hit 10 with an accuracy of " + percentage + "%."
                                                              + "\nname: Tishya Chhabra \nCourse Number: CIS263AA\nClass 28649\nMEID:2130581");
            resetX();
        } else {
            JOptionPane.showMessageDialog(null, "Oh no! You missed! Try again.");
        }

    }

    

}
