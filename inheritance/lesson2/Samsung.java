package inheritance.lesson2;

public class Samsung implements Phone {

    @Override
    public void call(Person person) {
        System.out.println("Call Samsung number " + person.getNumber());

    }

    @Override
    public void text() {
    }

    @Override
    public void end() {
        System.out.println("End Samsung");

    }

}