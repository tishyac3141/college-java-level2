package graphics.lesson7;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * @author Tishya Chhabra
 * Date: October 10, 2020
 * Class Info: A basic implementation of the game TicTacToe! Uses the GridLayout Manager and
 * JButtons for the main graphical components of the game. The user clicks a button and it will be
 * marked with an 'X'; immediately, the computer will put it's 'O' down for a super fun game!
 * The user will be notified as soon as they win or lose the game!
 */

public class TicTacToe extends JFrame implements MouseListener {

    //establishing the layout (a 3x3 grid) and content pane
    private GridLayout layout = new GridLayout(3, 3);
    private Container cont = getContentPane();
    //2-dimensional array of JButtons for ease of control
    private JButton[][] grid = new JButton[3][3];
    //a 2-dimensional array that keeps track if a specific button (or tile) has been marked
    private boolean[][] game = new boolean[3][3];
    //a variabe to keep track of how many 'tiles' on the 'game board' have been makred
    private int count = 0;

    public TicTacToe() {
        //basic things: setting the layout and size and adding the overall MouseListener for the frame
        cont.setLayout(layout);
        setSize(680, 680);
        addMouseListener(this);

        //iterating through the 2-dimensional array and creating JButtons to fill each part
        //of the 3x3 grid, adding the mouseListener for each button, and also making each 
        //element in 'game' false since none of the 'tiles' have been marked yet
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[j][i] = new JButton();
                grid[j][i].addMouseListener(this);
                add(grid[j][i]);

                game[j][i] = false;
            }
        }
    }

    //this method is called when the user clicks on any of the buttons
    public void mouseClicked(MouseEvent e) {
        //getting the actual component that was clicked and storing it
        Component clicked = e.getComponent();

        //iterating through the array, finding which button was clicked and setting the
        //text of that button to an 'X'; also marking the corresponding position in 
        //'game' as true since that position has been marked

        //incrementing the count since, with the user and the 'computer', a position has
        //been marked on the 'board'
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[j][i].equals(clicked)) {
                    if (!game[j][i]) {
                        grid[j][i].setText("X");
                        game[j][i] = true;
                        count++;
                    }
                }

            }
        }
        //making sure that only if the number of positions that have been marked
        //is less than 8 (out of 9), then the computer will also mark a position
        //(since if 9 positions have been marked, then the game is over!)
        if (count <= 8) {
            //getting a random number between 0 and 2 for the position to mark
            int row = (int) (Math.random() * 3);
            int col = (int) (Math.random() * 3);

            //since 'game' stores whether or not a position has already been marked
            //as long as it is true, as in it has been marked, generate a new random
            //number until it finds a combination that hasn't been marked
            while (game[row][col]) {
                row = (int) (Math.random() * 3);
                col = (int) (Math.random() * 3);
            }

            //with that position determined, set the text to 'O' and mark it in 
            //'game' as true since that place has been marked; incrememnt the count
            grid[row][col].setText("O");
            game[row][col] = true;
            count++;

        }

        //this next part checks if the user has won, computer has won, or if the game is over
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                //making sure that j is not 0 or the length-1 to avoid an
                //ArrayIndexOutOfBounds Exception
                if (j != 0 && j != grid.length - 1) {
                    //incrememnting through the whole array, we start by going through a column
                    //to see if a column all has the same text (X or O)
                    JButton row1 = grid[j - 1][i];
                    JButton row2 = grid[j][i];
                    JButton row3 = grid[j + 1][i];

                    //if each of the buttons in the column has the text X, that means the user
                    //has won, and that is displayed using JOptionPane
                    if (row1.getText().equals("X") && row2.getText().equals("X") && row3.getText().equals("X")) {
                        JOptionPane.showMessageDialog(null, "You won!");
                    
                    //otherwise, if the buttons in the column all have the text 'O', that means
                    //the user lost, and that is displayed using JOptionPane as well
                    } else if (row1.getText().equals("O") && row2.getText().equals("O") && row3.getText().equals("O")) {
                        JOptionPane.showMessageDialog(null, "Oh no! You lost!");
                    }
                }
                //making sure that i is not 0 or the length-1 to avoid an
                //ArrayIndexOutOfBounds Exception
                if (i != 0 && i != grid.length - 1) {

                    //once again, going through and storing the buttons in the row this time, not column
                    JButton row1 = grid[j][i - 1];
                    JButton row2 = grid[j][i];
                    JButton row3 = grid[j][i + 1];

                    //if all the buttons in the row have the text 'X', then that means
                    //the user won, and they are notified with the JOptionPane message
                    if (row1.getText().equals("X") && row2.getText().equals("X") && row3.getText().equals("X")) {
                        JOptionPane.showMessageDialog(null, "You won!");

                    //otherwise, if the buttons in the row all have the text 'O', then that means
                    //the 'computer' has won, and the user is notified with a JOptionPane message
                    } else if (row1.getText().equals("O") && row2.getText().equals("O") && row3.getText().equals("O")) {
                        JOptionPane.showMessageDialog(null, "Oh no! You lost!");
                    }
                }
            }
        }
        //we know that if the count is over 8 at this point, that means all the positions
        //have been marked and the game is officially over
        if(count > 8){
            JOptionPane.showMessageDialog(null, "Game over!");
        }
        //setting it visible so the user can see everything happen1
        setVisible(true);

    }

    //these next set of methods are required to be implemented in order to be a MouseListener
    public void mousePressed(MouseEvent e) { }
    public void mouseReleased(MouseEvent e) { }
    public void mouseEntered(MouseEvent e) { }
    public void mouseExited(MouseEvent e) { }


    //main method to run + test code
    public static void main(String[] args) {
        TicTacToe ttt = new TicTacToe();
        ttt.setVisible(true);
    }
}