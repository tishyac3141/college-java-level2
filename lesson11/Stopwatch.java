package lesson11;

/**
 * @author Tishya Chhabra
 * Date: 11/14/2020
 * 
 * A class that creates instanes of the minute and seconds classes; a super basic
 * implementation of a stopwatch.
 */

public class Stopwatch {

    public static void main(String[] args){
        Thread thread1 = new Thread(new Second());
        Thread thread2 = new Thread(new Minute());

        thread1.start();
        thread2.start();

    }
    
}
