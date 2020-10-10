package graphics.lesson7;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Battleship extends JFrame implements MouseListener{    

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Container cont = getContentPane();
    private GridLayout layout = new GridLayout(6, 6);
    private JButton[][] grid = new JButton[6][6];

    public Battleship(){

        setSize(680, 680);
        cont.setLayout(layout);

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                grid[j][i] = new JButton();
                cont.add(grid[j][i]);
            }
        }

        setVisible(true);
    }
    
    public void mouseClicked(MouseEvent e) {
        Component clicked = e.getComponent();

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[j][i].equals(clicked)){
                    System.out.println("true!");
                    if(i == 2){
                        grid[j][i].setText("1");
                    } else {
                        grid[j][i].setText("0");
                    }
                }
            }
        }

    }

    public void mousePressed(MouseEvent e) { }
    public void mouseReleased(MouseEvent e) { }
    public void mouseEntered(MouseEvent e) { }
    public void mouseExited(MouseEvent e) { }
    public void mouseDragged(MouseEvent e) { }
    public void mouseMoved(MouseEvent e) { }

    public static void main(String[] args){
        Battleship ship = new Battleship();
    }

    

    

}