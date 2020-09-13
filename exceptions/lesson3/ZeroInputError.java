package exceptions.lesson3;

public class ZeroInputError extends Exception{
    
    public String getMessage(){
        return "Error! Can't divide by zero!";
    }

}
