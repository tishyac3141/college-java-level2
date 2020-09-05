package inheritance.lesson2;

/**
 * @author: Tishya Chhabra 
 * Date: September 4, 2020
 * Class Info: An interface that outlines the functionalities of a phone; includes being
 * able to call, text, and end the call.
 */
public interface Phone {

    public void call(Person person);

    public void text();

    public void end();
}