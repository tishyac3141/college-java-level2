package inheritance.lesson2;

import javax.swing.JOptionPane;

public class Call {

    public static void main(String[] args){
        
        Phone[] phones = new Phone[4];
        phones[0] = new Iphone();
        phones[1] = new Samsung();
        phones[2] = new Samsung();
        phones[3] = new Iphone();

        Person[] people = new Person[4];
        people[0] = new Person("Joe", "555-1234");
        people[1] = new Person("Bob", "555-4444");
        people[2] = new Person("Alice", "555-6565");
        people[3] = new Person("Sally","555-1111");

        String input = JOptionPane.showInputDialog("Please enter who you would like to call: Joe, Bob, Alice, or Sally");

        if(input.equals(people[0].getName())){

        } 
        else if(input.equals(people[1].getName())){

        }
        else if(input.equals(people[2].getName())){

        }
        else if(input.equals(people[3].getName())){

        }  
        else{
            JOptionPane.showMessageDialog(null, "You cannot call that person!");
        }
    }
    
}
