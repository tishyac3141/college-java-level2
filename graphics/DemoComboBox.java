   package graphics;
   
   import javax.swing.*;
   import java.awt.*;
   import java.awt.event.*;

   public class DemoComboBox extends JFrame implements ActionListener
   {
      String[] list = {"Cloud Watching", "Drawing", "Camping", "Scuba Diving", "Rock Climbing"};
      JLabel description = new JLabel("What is your favorite hobby?");
      JComboBox hobby = new JComboBox(list);
   	
      public DemoComboBox()
      {
         super("Favorite Hobbies");
         setSize(400, 150);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setLayout(new FlowLayout());
      	
         add(description);
         add(hobby);								// Add the combo box
         hobby.addActionListener(this);	// Add action listener
      	
         setVisible(true);
      }
   	
      public void actionPerformed(ActionEvent e)
      {
         int chosen = hobby.getSelectedIndex();		// Which item in the array is chosen?
         JOptionPane.showMessageDialog(null, "You chose: " + list[chosen]);
      }
      
      public static void main(String[] args)
      {
         DemoComboBox app = new DemoComboBox();
      }
   }