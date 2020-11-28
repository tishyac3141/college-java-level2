package final_project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JLottery2 extends JFrame implements ActionListener, ItemListener {

    private JCheckBox[] checkboxes = new JCheckBox[30];
    private JButton submit = new JButton("Submit");
    private JButton reset = new JButton("Reset");
    
    private JMenuBar menu = new JMenuBar();
    private JMenu file = new JMenu("File");
    private JMenuItem about = new JMenuItem("About");

    private final int MAX_SELECTIONS = 6;
    private int numSelected = 0;
    private boolean[] generated = new boolean[30];

    public JLottery2() {

        setSize(650, 650);
        setLayout(new GridLayout(6, 5));
        setJMenuBar(menu);

        menu.add(file);
        file.add(about);
        about.addActionListener(this);

        for (int i = 0; i < checkboxes.length; i++) {
            checkboxes[i] = new JCheckBox(Integer.toString(i + 1));
            checkboxes[i].addItemListener(this);
            add(checkboxes[i]);
            checkboxes[i].setSelected(false);
            generated[i] = false;
        }

        add(submit);
        add(reset);
        submit.addActionListener(this);
        reset.addActionListener(this);

        generateRandom();
        setVisible(true);

    }

    public void itemStateChanged(ItemEvent e) {
        JCheckBox pressed = (JCheckBox) (e.getSource());

        if (pressed.isSelected()) {
            numSelected++;
            if (numSelected == MAX_SELECTIONS) {
                for (int i = 0; i < checkboxes.length; i++) {
                    if (!checkboxes[i].isSelected()) {
                        checkboxes[i].setEnabled(false);
                    }
                }
            }
        } else {
            numSelected--;
            if (numSelected < MAX_SELECTIONS) {
                for (int i = 0; i < checkboxes.length; i++) {
                    checkboxes[i].setEnabled(true);
                }
            }
        }

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(submit)) {
            int numMatching = 0;
            for(int i = 0; i < generated.length; i++){
                if(generated[i] && checkboxes[i].isSelected()) numMatching++;  
            }

            if(numMatching == 6){
                JOptionPane.showMessageDialog(null, "Congratulations! The numbers match!");
            } else {
                JOptionPane.showMessageDialog(null, "Oh no! The numbers do not match!");
            }

        } else if(e.getSource().equals(reset)){
            reset();
        } else if(e.getSource() == about){
            String info = "\nname: Tishya Chhabra \nCourse Number: CIS263AA\nClass 28649\nMEID:2130581";
            JOptionPane.showMessageDialog(null, info);
        }

    }

    public void generateRandom() {
        int tempRandom = 0;
        for (int i = 0; i < 6; i++) {
            if(i == 0){
                tempRandom = ((int) (Math.random() * 30));
                generated[tempRandom - 1] = true;

            } else {
                while(generated[tempRandom - 1]){
                    tempRandom = ((int) (Math.random() * 30));
                }
                generated[tempRandom - 1] = true;
            }
            //System.out.println("tempRandom = " + tempRandom);
        }
    }

    public void reset(){
        for(int i = 0; i < checkboxes.length; i++){
            checkboxes[i].setEnabled(true);
            checkboxes[i].setSelected(false);
        }
        numSelected = 0;
        generateRandom();
    }

}
