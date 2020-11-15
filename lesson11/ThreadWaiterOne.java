package lesson11;

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
