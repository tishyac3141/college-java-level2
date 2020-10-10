package graphics.lesson7;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Battleship extends JFrame implements MouseListener{

    private Container cont = getContentPane();
    private GridLayout layout = new GridLayout(6, 6);
    private JButton[][] grid = new JButton[6][6];
    private int count = 0;
    private int row = (int)(Math.random() * 6);

    public Battleship(){

        setSize(680, 680);
        cont.setLayout(layout);
        cont.setBackground(Color.CYAN);

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                grid[j][i] = new JButton();
                grid[j][i].addMouseListener(this);
                cont.add(grid[j][i]);
            }
        }

        setVisible(true);
    }
    
    public void mouseClicked(MouseEvent e) {

        Component clicked = (e.getComponent());

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[j][i].equals(clicked)){
                    if(i == row){
                        if(!(grid[j][i].getText().equals("1"))) count++;
                        grid[j][i].setText("1");
                    } else {
                        grid[j][i].setText("0");
                    }
                }
            }
        }

        setVisible(true);

        if(count == 6){
            JOptionPane.showMessageDialog(null, "You sunk a ship! Game over! ");
            count = 0;
            row = (int)(Math.random() * 6);
        }
        

    }

    public void mousePressed(MouseEvent e) {  }
    public void mouseReleased(MouseEvent e) {  }
    public void mouseEntered(MouseEvent e) {  }
    public void mouseExited(MouseEvent e) {  }
    public void mouseDragged(MouseEvent e) {  }
    public void mouseMoved(MouseEvent e) {  }

    public static void main(String[] args){
        Battleship ship = new Battleship();
    }
     

}