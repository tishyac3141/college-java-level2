package graphics.lesson6;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ColorChanger extends JFrame implements ActionListener{

    private Container cont = getContentPane();
    private JButton centerButton = new JButton("Click me!");
    
    private JPanel panel1 = new JPanel();
    private JPanel panel2 = new JPanel();
    private JPanel panel3 = new JPanel();
    private JPanel panel4 = new JPanel();

    public ColorChanger(){
        setLayout(new BorderLayout());
        setSize(450, 450);

        centerButton.addActionListener(this);
        panel1.setPreferredSize(new Dimension(120, 120));
        panel2.setPreferredSize(new Dimension(120, 120));
        panel3.setPreferredSize(new Dimension(120, 120));
        panel4.setPreferredSize(new Dimension(120, 120));

        cont.add(centerButton, BorderLayout.CENTER);
        cont.add(panel1, BorderLayout.NORTH);
        cont.add(panel2, BorderLayout.SOUTH);
        cont.add(panel3, BorderLayout.EAST);
        cont.add(panel4, BorderLayout.WEST);
    }

    public void actionPerformed(ActionEvent e) {
        int region = (int)(4 * Math.random());
        int randomColor = (int)(10 * Math.random());
        Color color = Color.WHITE;

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

    public static void main(String[] args){
        ColorChanger changer = new ColorChanger();
        changer.setVisible(true);
    }
    
}
