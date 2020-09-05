package inheritance.lesson2;

/**
 * @author: Tishya Chhabra 
 * Date: September 4, 2020
 * Class Info: A basic class that implements the 'Phone' interface; what makes it unique
 * is that it specifically prints "Calling iPhone" when the 'call()' method is called
 */

public class Iphone implements Phone {

    @Override
    public void call(Person person) {
        System.out.println("Calling iPhone number " + person.getNumber());

    }

    @Override
    public void text() {
    }

    @Override
    public void end() {
        System.out.println("End iPhone");

    }

}