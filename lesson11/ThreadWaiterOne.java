package lesson11;

/**
 * @author Tishya Chhabra
 * Date: 11/14/2020
 * 
 * A class that has a thread sleep for 20 seconds, then prints when the thread is awake again.
 */

public class ThreadWaiterOne implements Runnable {

    private Thread thread;

    public void start(){
        if(thread == null) thread = new Thread();
    }

    public void run() {
        try {
            thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ThreadWaiterOne is done!");
    }
    
}
