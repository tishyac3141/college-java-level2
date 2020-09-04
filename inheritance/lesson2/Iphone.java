package inheritance.lesson2;

public class Iphone implements Phone {

    @Override
    public void call() {
        System.out.println("Call Iphone");

    }

    @Override
    public void text() {
        // TODO Auto-generated method stub

    }

    @Override
    public void end() {
        System.out.println("End Iphone");

    }

}