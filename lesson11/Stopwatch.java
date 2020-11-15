package lesson11;

public class Stopwatch {

    public static void main(String[] args){
        Thread thread1 = new Thread(new Second());
        Thread thread2 = new Thread(new Minute());

        thread1.start();
        thread2.start();

    }
    
}
