package java_graphics.lesson8;

import javax.swing.*;
import java.awt.*;

public class DrawingCards extends JPanel {

    private int[] values = new int[40];
    private int valuesIndex = 0;

    private int WIDTH = 450;
    private int HEIGHT = 450;

    private boolean reset = false;
    private boolean addCard = true;

    public DrawingCards() {
        setSize(WIDTH, HEIGHT);
        setVisible(true);
    }

    public void reset() {
        reset = true;
        repaint();
    }

    public void addCard(int value) {
        values[valuesIndex] = value;
        valuesIndex++;
        addCard = true;
        repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (reset) {
            for (int i = 0; i < values.length; i++) {
                values[i] = 0;
            }
            valuesIndex = 0;
            reset = false;
        }
        if (addCard) {
            for (int i = 0; i < valuesIndex; i++) {
                System.out.println("values[i] = " + values[i]);
                int xcord = WIDTH/(valuesIndex - i);

                //g.drawRect(xcord, 10, 150, 250);
                g.drawString(Integer.toString(values[i]), xcord, 225);
            }

            addCard = false;
            setVisible(true);
        }
    }

}
