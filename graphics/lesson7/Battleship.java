package graphics.lesson7;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Battleship extends JFrame{

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

    public static void main(String[] args){
        Battleship ship = new Battleship();
    }

}