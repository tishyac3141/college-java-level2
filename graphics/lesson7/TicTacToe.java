package graphics.lesson7;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class TicTacToe extends JFrame implements MouseListener {

    private GridLayout layout = new GridLayout(3, 3);
    private Container cont = getContentPane();
    private JButton[][] grid = new JButton[3][3];
    private boolean[][] game = new boolean[3][3];
    private int count = 0;

    public TicTacToe() {
        cont.setLayout(layout);
        setSize(680, 680);
        addMouseListener(this);

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[j][i] = new JButton();
                grid[j][i].addMouseListener(this);
                add(grid[j][i]);

                game[j][i] = false;
            }
        }

    }

    public void mouseClicked(MouseEvent e) {
        Component clicked = e.getComponent();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[j][i].equals(clicked)) {
                    if (!game[j][i]) {
                        grid[j][i].setText("X");
                        game[j][i] = true;
                        count += 2;
                    }
                }

            }
        }
        if (count <= 8) {
            int row = (int) (Math.random() * 3);
            int col = (int) (Math.random() * 3);

            while (game[row][col]) {
                row = (int) (Math.random() * 3);
                col = (int) (Math.random() * 3);
            }

            grid[row][col].setText("O");
            game[row][col] = true;

        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (j != 0 && j != grid.length - 1) {

                    JButton row1 = grid[j - 1][i];
                    JButton row2 = grid[j][i];
                    JButton row3 = grid[j + 1][i];

                    if (row1.getText().equals("X") && row2.getText().equals("X") && row3.getText().equals("X")) {
                        JOptionPane.showMessageDialog(null, "You won!");
                    } else if (row1.getText().equals("O") && row2.getText().equals("O") && row3.getText().equals("O")) {
                        JOptionPane.showMessageDialog(null, "Oh no! You lost!");
                    }
                }
                if (i != 0 && i != grid.length - 1) {

                    JButton row1 = grid[j][i - 1];
                    JButton row2 = grid[j][i];
                    JButton row3 = grid[j][i + 1];

                    if (row1.getText().equals("X") && row2.getText().equals("X") && row3.getText().equals("X")) {
                        JOptionPane.showMessageDialog(null, "You won!");
                    } else if (row1.getText().equals("O") && row2.getText().equals("O") && row3.getText().equals("O")) {
                        JOptionPane.showMessageDialog(null, "Oh no! You lost!");
                    }
                }
            }
        }

        if(count > 8){
            JOptionPane.showMessageDialog(null, "Game over!");
        }

        setVisible(true);

    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public static void main(String[] args) {
        TicTacToe ttt = new TicTacToe();
        ttt.setVisible(true);
    }
}