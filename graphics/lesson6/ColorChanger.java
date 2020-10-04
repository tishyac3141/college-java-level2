package graphics.lesson6;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * @author: Tishya Chhabra 
 * Date: October 3, 2020
 * Class Info: A class that allows the user to click on a button, and each 
 * time they click on the button, the color changes in one of the four regions
 * (NORTH, SOUTH, EAST, and WEST)
 */

public class ColorChanger extends JFrame implements ActionListener{

    //creating the main button
    private Container cont = getContentPane();
    private JButton centerButton = new JButton("Click me!");
    
    //creating JPanels that will be put in each region so we can:
    //  the regions will exist (since each region needs a component in it otherwise it will not show)
    //  resize the region so that they're actually visible
    private JPanel panel1 = new JPanel();
    private JPanel panel2 = new JPanel();
    private JPanel panel3 = new JPanel();
    private JPanel panel4 = new JPanel();

    public ColorChanger(){
        //setting the layout and size of the frame
        setLayout(new BorderLayout());
        setSize(450, 450);

        //adding the correct action listener
        centerButton.addActionListener(this);
        //resizing the panels so that they can be seen clearly
        panel1.setPreferredSize(new Dimension(120, 120));
        panel2.setPreferredSize(new Dimension(120, 120));
        panel3.setPreferredSize(new Dimension(120, 120));
        panel4.setPreferredSize(new Dimension(120, 120));

        //adding the panels and buttons in their respective regions
        cont.add(centerButton, BorderLayout.CENTER);
        cont.add(panel1, BorderLayout.NORTH);
        cont.add(panel2, BorderLayout.SOUTH);
        cont.add(panel3, BorderLayout.EAST);
        cont.add(panel4, BorderLayout.WEST);
    }

    //this method is called when the center button is clicked
    public void actionPerformed(ActionEvent e) {
        //generating random numbers for which region's bg color will be changed AND
        //what color it will be changed to
        int region = (int)(4 * Math.random());
        int randomColor = (int)(10 * Math.random());
        Color color = Color.WHITE;

        //going through and depending on what number is generated, setting the 'color'
        //variable to a color
        if(randomColor == 0){
            color = Color.GREEN;
        }
        else if(randomColor == 1){
            color = Color.BLUE;
        }
        else if(randomColor == 2){
            color = Color.YELLOW;
        }
        else if(randomColor == 3){
            color = Color.RED;
        }
        else if(randomColor == 4){
            color = Color.LIGHT_GRAY;
        }   
        else if(randomColor == 5){
            color = Color.MAGENTA;
        }
        else if(randomColor == 6){
            color = Color.CYAN;
        }
        else if(randomColor == 7){
            color = Color.PINK;
        }
        else if(randomColor == 8){
            color = Color.BLACK;
        }
        else if(randomColor == 9){
            color = Color.ORANGE;
        }
        else if(randomColor == 10){
            color = Color.WHITE;
        }

        //going through and depending on what random number was generated, the background color
        //of a specific region is set to the randomly chosen color
        if(region == 0){
            panel1.setBackground(color);
        }
        else if(region == 1){
            panel2.setBackground(color);
        }
        else if(region == 2){
            panel3.setBackground(color);
        } 
        else{
            panel4.setBackground(color);
        }

    }

    //creating and instance of the class and setting it to visible so we can see the program work!
    public static void main(String[] args){
        ColorChanger changer = new ColorChanger();
        changer.setVisible(true);
    }
    
}
