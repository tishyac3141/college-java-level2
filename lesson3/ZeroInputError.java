package lesson3;

/**
 * @author: Tishya Chhabra 
 * Date: September 12, 2020
 * Class Info: A class that extends the 'Exception' class; specifically made for if 
 * a number is divided by zero; provides a more detailed error message to display
 * if such an operation were to happen.
 */

public class ZeroInputError extends Exception{
    
    private static final long serialVersionUID = 1L;

    public String getMessage() {
        return "Error! Can't divide by zero!";
    }

}
