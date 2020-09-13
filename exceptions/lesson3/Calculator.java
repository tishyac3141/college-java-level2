package exceptions.lesson3;

import javax.swing.JOptionPane;

/**
 * @author: Tishya Chhabra 
 * Date: September 12 2020
 * Class Info: A class that performs a simple division. It has two parameters, numerator
 * and denominator, and has a method called 'calculateDivision()'
 * it specifically throws a 'ZeroInputError' (specified in the package) if the denominator 
 * has a value of 0 which.
 * 
 * main method is included in this class which tests the code; it uses a try-catch
 * block that handles the 'calculateDivision()' method throwing an exception
 * 
 * NOTE: I wasn't sure what you meant by: "If the denominator equals 0, it will pass through 
 * the ZeroInputError."
 * hence, i wrote it so it throws the ZeroInputError if the denominator is 0, and I added
 * the main method to test the code. hopefully that is what you were expecting!
 */
public class Calculator {
    
    private int numerator;
    private int denominator;

    public void calculateDivision() throws ZeroInputError{
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
            calculator.calculateDivision();
        } catch(ZeroInputError e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
}
