package exceptions.lesson3;

import javax.swing.JOptionPane;

public class Calculator {
    
    private int numerator;
    private int denominator;

    public void calculate() throws ZeroInputError{
        String num1 = JOptionPane.showInputDialog("Enter the first number: ");
        String num2 = JOptionPane.showInputDialog("Enter the second number: ");

        numerator = Integer.parseInt(num1);
        denominator = Integer.parseInt(num2);
        
        if(denominator == 0){
            throw new ZeroInputError();
        } else{
            JOptionPane.showMessageDialog(null, "Your answer is: " + (numerator/denominator));
        }
    }

    public static void main(String[] args){
        Calculator calculator = new Calculator();
        
        try{
            calculator.calculate();
        } catch(ZeroInputError e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
}
