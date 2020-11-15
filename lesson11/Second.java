package lesson11;
/**
 * @author Tishya Chhabra
 * Date: 11/14/2020
 * 
 * A class that keeps track of time and prints out how many seconds
 * have elapsed every second.
 */

public class Second implements Runnable {

    private Thread thread;
    private int counter = 0;

    public void start() {
        if (thread == null)
            thread = new Thread();
    }

    public void run() {
        while(true){
            try {
                thread.sleep(1000);
                counter++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(counter + " seconds have elapsed");
        }
        

    }
    
}
