package inheritance.lesson2;

public class Samsung implements Phone {

    @Override
    public void call() {
        System.out.println("Call Samsung");

    }

    @Override
    public void text() {
        // TODO Auto-generated method stub

    }

    @Override
    public void end() {
        System.out.println("End Samsung");

    }

}