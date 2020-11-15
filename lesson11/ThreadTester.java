package lesson11;

public class ThreadTester {

    public static void main(String[] args){
        Thread thread1 = new Thread(new ThreadWaiterOne());
        Thread thread2 = new Thread(new ThreadWaiterTwo());

        thread1.start();
        thread2.start();
    }
    
}
