package inheritance.lesson2;

/**
 * Author: Tishya Chhabra 
 * Date: September 4, 2020
 * Class Info: A class that tests the functionality of the 'Person' class, specifically
 * the toString() method.
 */

public class TestPerson {

    public static void main(String[] args) {
     
        //create an arry of Person objects and populate it
        Person[] people = new Person[5];
        people[0] = new Person("Kelly", "480-123-4876");
        people[1] = new Person("Arjun", "267-872-0813");
        people[2] = new Person("Lupe", "162-764-9174");
        people[3] = new Person("Ha-Eun", "353-982-1834");
        people[4] = new Person("Bob", "174-947-0925");

        //iterate through the whole array and call each object's toString() method
        for(int i = 0; i < people.length; i++){
            System.out.println(people[i].toString());
        }
    }
}