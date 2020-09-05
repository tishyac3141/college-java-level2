package inheritance.lesson2;

/**
 * @author: Tishya Chhabra 
 * Date: September 4, 2020
 * Class Info: A basic class that serves as a Person; includes two data fields, one
 * for the person's name and for their phone number and overrides the toString() method
 * to return those pieces of information; data is initialized in constructor and the
 * class includes getters for the fields.
 */

public class Person {

    private String name;
    private String phoneNumber;

    //constructor
    public Person(String newName, String newNumber) {
        name = newName;
        phoneNumber = newNumber;
    }

    public String toString() {
        return name + ", " + phoneNumber;
    }

    public String getName(){
        return name;
    }

    public String getNumber(){
        return phoneNumber;
    }
}