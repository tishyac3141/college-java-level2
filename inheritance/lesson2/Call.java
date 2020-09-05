package inheritance.lesson2;

import javax.swing.JOptionPane;

/**
 * @author: Tishya Chhabra 
 * Date: September 4, 2020
 * Class Info: A class that tests the Phone and Person classes by creating instances
 * of them and calling their methods.
 */

public class Call {

    public static void main(String[] args){
        
        //create an array (length 4) of the iPhone + Samsung objects
        Phone[] phones = new Phone[4];
        phones[0] = new Iphone();
        phones[1] = new Samsung();
        phones[2] = new Samsung();
        phones[3] = new Iphone();

        //create an array (length 4) of Person objects
        Person[] people = new Person[4];
        people[0] = new Person("Joe", "555-1234");
        people[1] = new Person("Bob", "555-4444");
        people[2] = new Person("Alice", "555-6565");
        people[3] = new Person("Sally","555-1111");

        //ask the user for the name of the person they would like to call and store it
        //in the variable 'input'
        String input = JOptionPane.showInputDialog("Please enter who you would like to call: Joe, Bob, Alice, or Sally");

        //go through and check if the name matches
        if(input.equals(people[0].getName())){
            phones[0].call(people[0]);
        } 
        else if(input.equals(people[1].getName())){
            phones[1].call(people[1]);
        }
        else if(input.equals(people[2].getName())){
            phones[2].call(people[2]);
        }
        else if(input.equals(people[3].getName())){
            phones[3].call(people[3]);
        }  
        else{ //if it doesn't, show an error message
            JOptionPane.showMessageDialog(null, "You cannot call that person!");
        }
    }
    
}
