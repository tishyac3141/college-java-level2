package final_project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author Tishya Chhabra Date: 11/25/2020
 */

public class JLuckySeven extends JPanel implements ActionListener {

    private int losses = 0;
    private boolean isReset = false;

    private int[][] values = new int[7][2];
    private JButton[] buttons = new JButton[7];

    private JFrame frame = new JFrame();
    private JLabel tally = new JLabel();

    public JLuckySeven() {
        setSize(650, 400);
        setLayout(new FlowLayout());
        setAlignmentX(Component.CENTER_ALIGNMENT);

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

        frame.setSize(650, 400);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.setLocationRelativeTo(null);

        this.setVisible(true);
        frame.setVisible(true);

    }

    public void paintComponent(Graphics g) {

        if (isReset) {
            isReset = false;
        } else {
            frame.removeAll();
            for (int i = 0; i < values.length; i++) {
                if (values[i][0] == 0) {
                    this.add(buttons[i]);
                    buttons[i].addActionListener(this);
                }
            }
        }

        this.setVisible(true);
        frame.setVisible(true);
    }

    public void draw(int index, JButton pressed) {
        int value = values[index][0];
        values[index][1] = 1;

        pressed.setText(Integer.toString(value));

        if (values[value - 1][1] == 1) {
            losses++;
            JOptionPane.showMessageDialog(null, "You lost!");
            isReset = true;
            reset();
        }

        repaint();
    }

    public void reset() {
        for (int i = 0; i < values.length; i++) {
            values[i][1] = 0;
        }
    }

    public void actionPerformed(ActionEvent e) {
        Object pressed = e.getSource();

        for (int i = 0; i < buttons.length; i++) {
            if (pressed.equals(buttons[i])) {
                draw(i, buttons[i]);
                // break;
            }
        }

    }

}
