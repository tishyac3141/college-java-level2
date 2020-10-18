package java_graphics.lesson7;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * @author Tishya Chhabra
 * Date: October 10, 2020
 * Class Info: A very very basic implementation of the game Battleship! The user can click through
 * the tiles (in this case JButtons) and try to sink a ship, and if they do, they win! When
 * they click on a 'tile' or button, then it will be exposed whether or not a ship was there,
 * 0 being a ship was not a 1 being a ship was!
 */

public class Battleship extends JFrame implements MouseListener{

    //creating the basic components: the layout (6x6) and the content pane
    private Container cont = getContentPane();
    private GridLayout layout = new GridLayout(6, 6);
    //creatng a 2-dimensional array of JButtons for ease
    private JButton[][] grid = new JButton[6][6];
    //setting a count variable to keep track of how many 'parts of the ship' have been hit so far
    private int count = 0;
    //the random variable for which row will be the one with the 'ship' 
    private int row = (int)(Math.random() * 6);

    public Battleship(){

        //setting the basic properties: size, layout manager, and background color (blue like ocean!)
        setSize(680, 680);
        cont.setLayout(layout);
        cont.setBackground(Color.BLUE);

        //iterating through the array and creating JButtons, as well as adding the correct
        //mouse listener for them and adding them to the content pane
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                grid[j][i] = new JButton();
                grid[j][i].addMouseListener(this);
                cont.add(grid[j][i]);
            }
        }
    }
    
    //this method is called when any of the buttons are clicked in the frame
    public void mouseClicked(MouseEvent e) {
        //getting the actual component, in this case button, that was clicked
        Component clicked = (e.getComponent());

        //iterating through the array and finding the exact button that was clicked
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[j][i].equals(clicked)){
                    //if it is the corresponding button and it's horizontal position is
                    //equal to the random row we've defined at the top as where the 'ship'
                    //is, then the text of the button will be set to 1
                    //count will be incrememnted to accurately reflect what has happened
                    if(i == row){
                        if(!(grid[j][i].getText().equals("1"))) count++;
                        grid[j][i].setText("1");
                    //otherwise, the text is set to 0, since it was not a Hit
                    } else {
                        grid[j][i].setText("0");
                    }
                }
            }
        }
        //setting it to visible so that the user can see
        setVisible(true);

        //if the count is 6, since one row is 6 units long, then that means the user sunk a ship
        //and the game is over; the count is reset and the row is redefined in case
        //I would want to furhter implement the game starting over
        if(count == 6){
            JOptionPane.showMessageDialog(null, "You sunk a ship! Game over! ");
            count = 0;
            row = (int)(Math.random() * 6);
        }
        

    }

     //these next set of methods are required to be implemented in order to be a MouseListener
     public void mousePressed(MouseEvent e) { }
     public void mouseReleased(MouseEvent e) { }
     public void mouseEntered(MouseEvent e) { }
     public void mouseExited(MouseEvent e) { }

     //main method so we can test the code!
    public static void main(String[] args){
        Battleship ship = new Battleship();
        ship.setVisible(true);
    }
     

}