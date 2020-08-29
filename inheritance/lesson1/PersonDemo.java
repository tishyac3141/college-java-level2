package inheritance.lesson1;

import java.util.Scanner;

public class PersonDemo {
    public static void main(String[] args) {

        Person person = new Person();
        Student student = new Student();

        String name;
        int age;
        int id;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the person: ");
        name = scanner.next();
        person.setName(name);

        System.out.println("Enter the age of the person: ");
        age = scanner.nextInt();
        person.setAge(age);

        System.out.println("The person " + person.getName() + " is " + person.getAge() + " years old!");

        System.out.println("Enter the name of the student: ");
        name = scanner.next();
        student.setName(name);

        System.out.println("Enter the age of the student: ");
        age = scanner.nextInt();
        student.setAge(age);

        System.out.println("Enter the id number of the student: ");
        id = scanner.nextInt();
        student.setStudentId(id);

        System.out.println("The student " + student.getName() + " is " + student.getAge() + " years old."
                + " Their student ID is " + student.getStudentId() + ".");

        scanner.close();

    }

}