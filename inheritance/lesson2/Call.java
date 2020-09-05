package inheritance.lesson2;

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
    }
    
}
