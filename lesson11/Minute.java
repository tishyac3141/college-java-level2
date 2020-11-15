package lesson11;

public class Minute implements Runnable {

    private Thread thread;
    private int counter = 0;

    public void start() {
        if (thread == null)
            thread = new Thread();
    }

    public void run() {
        while (true) {
            try {
                thread.sleep(60000);
                counter++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(counter + " minutes have passed");
        }

    }

}
