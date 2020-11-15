package lesson11;

/**
 * @author Tishya Chhabra
 * Date: 11/14/2020
 * 
 * A class that creates instances of ThreadWaiterOne and ThreadWaiterTwo.
 */

public class ThreadTester {

    public static void main(String[] args){
        Thread thread1 = new Thread(new ThreadWaiterOne());
        Thread thread2 = new Thread(new ThreadWaiterTwo());

        thread1.start();
        thread2.start();
    }
    
}
