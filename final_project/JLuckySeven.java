package final_project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author Tishya Chhabra Date: 11/25/2020
 */

public class JLuckySeven extends JFrame implements ActionListener {

    private int losses = 0;
    private boolean isReset = false;

    private int[][] values = new int[7][2];
    private JButton[] buttons = new JButton[7];

    private JLabel tally = new JLabel();

    public JLuckySeven() {
        setSize(650, 400);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        for (int i = 0; i < values.length; i++) {
            if (i < 3) {
                values[i][0] = values.length - i;
            } else {
                values[i][0] = i - 2;
            }

            values[i][1] = 0;

            buttons[i] = new JButton(Integer.toString(i + 1));
            this.add(buttons[i]);
            buttons[i].addActionListener(this);
        }

        tally.setText("");
        this.setVisible(true);

    }

    public void reset() {
        for (int i = 0; i < values.length; i++) {
            values[i][1] = 0;
            this.remove(buttons[i]);
        }
        for(int i = 0; i < buttons.length; i++){
            this.add(buttons[i]);
        }
    }

    public void actionPerformed(ActionEvent e) {
        Object pressed = e.getSource();
        int value = 0;
        this.remove((JButton)(pressed));

        for (int i = 0; i < buttons.length; i++) {
            if (pressed.equals(buttons[i])) {
                //this.remove(buttons[i]);
                values[i - 1][1] = 1;
                value = values[i - 1][0];
                break;
            }
        }

        if(values[value - 1][1] == 1){
            JOptionPane.showMessageDialog(null, "You lost!");
            reset();
        }

    }

}
