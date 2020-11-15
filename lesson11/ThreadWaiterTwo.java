package lesson11;

/**
 * @author Tishya Chhabra
 * Date: 11/14/2020
 * 
 * * A class that has a thread sleep for 5 seconds, then prints when the thread is awake again.
 */

public class ThreadWaiterTwo implements Runnable{

    private Thread thread;

    public void start(){
        if(thread == null) thread = new Thread();
    }

    public void run() {
        try {
            thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ThreadWaiterTwo is done!");
    }
    
}
