package lesson11;

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
