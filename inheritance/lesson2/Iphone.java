package inheritance.lesson2;

public class Iphone implements Phone {

    @Override
    public void call(Person person) {
        System.out.println("Call Iphone " + person.getNumber());

    }

    @Override
    public void text() {
    }

    @Override
    public void end() {
        System.out.println("End Iphone");

    }

}