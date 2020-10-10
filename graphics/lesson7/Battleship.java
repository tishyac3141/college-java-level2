package graphics.lesson7;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Battleship extends JFrame implements MouseListener{    

    private Container cont = getContentPane();
    private GridLayout layout = new GridLayout(6, 6);
    private JButton[][] grid = new JButton[6][6];

    public Battleship(){

        setSize(680, 680);
        cont.setLayout(layout);
        addMouseListener(this);

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                grid[j][i] = new JButton();
                cont.add(grid[j][i]);
            }
        }

        setVisible(true);
    }
    
    public void mouseClicked(MouseEvent e) {

        Component clicked = (e.getComponent());
        //System.out.println(clicked);

        for(int i = 0; i < grid.length; i++){
            //System.out.println("i = " + i);
            for(int j = 0; j < grid[0].length; j++){
                //System.out.println("j = " + j);
                //System.out.println(grid[j][i]);

                if(grid[j][i].equals(clicked)){
                    if(i == 2){
                        grid[j][i].setText("1");
                    } else {
                        grid[j][i].setText("0");
                    }
                }
            }
        }
        
        setVisible(true);

    }

    public void mousePressed(MouseEvent e) { System.out.println("mousePressed()"); }
    public void mouseReleased(MouseEvent e) { System.out.println("mouseReleased()"); }
    public void mouseEntered(MouseEvent e) { System.out.println("mouseEntered()"); }
    public void mouseExited(MouseEvent e) { System.out.println("mouseExited()"); }
    public void mouseDragged(MouseEvent e) { System.out.println("mouseDragged()"); }
    public void mouseMoved(MouseEvent e) { System.out.println("mouseMoved()"); }

    public static void main(String[] args){
        Battleship ship = new Battleship();
    }

    

    

}