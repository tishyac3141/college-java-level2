package inheritance.lesson1;

import java.util.Scanner;

public class AnimalDemo {

    public static void main(String[] args) {

        Animal animal = new Animal();
        Bear bear = new Bear();
        Shark shark = new Shark();

        Scanner scanner = new Scanner(System.in);
        String choice;

        System.out.println("Enter the age of your animal:");
        animal.setAge(scanner.nextInt());

        System.out.println("Enter the size of your animal in pounds: ");
        animal.setSize(scanner.nextInt());

        System.out.println("Enter the food your animal eats: ");
        animal.setFood(scanner.next());

        System.out.println("Your animal is " + animal.getAge() + " years old and weighs " + animal.getSize()
                + " pounds. " + "Your animal eats " + animal.getFood() + ".");

        System.out.println("Enter the age of your bear:");
        bear.setAge(scanner.nextInt());

        System.out.println("Enter the size of your bear in pounds: ");
        bear.setSize(scanner.nextInt());

        System.out.println("Enter the food your bear eats: ");
        bear.setFood(scanner.next());

        System.out.println("Is your bear hibernating? Type Y for yes and N for no: ");
        choice = scanner.next().strip();
        if (choice.equals("Y")) {
            bear.setIsHibernating(true);
        } else {
            bear.setIsHibernating(false);
        }

        System.out.println("Your bear is " + bear.getAge() + " years old and weighs " + bear.getSize() + " pounds. "
                + "Your bear eats " + animal.getFood() + ".");
        System.out.println("Is your bear hibernating? The answer is " + bear.getIsHibernating() + ".");

        System.out.println("Enter the age of your shark:");
        shark.setAge(scanner.nextInt());

        System.out.println("Enter the size of your shark in pounds: ");
        shark.setSize(scanner.nextInt());

        System.out.println("Enter the food your shark eats: ");
        shark.setFood(scanner.next());

        System.out.println("Is your shark in water? Type Y for yes and N for no: ");
        choice = scanner.next().strip();
        // System.out.println("choice = " + choice);
        if (choice.equals("Y")) {
            shark.setIsInWater(true);
        } else {
            shark.setIsInWater(false);
        }

        System.out.println("Your shark is " + shark.getAge() + " years old and weighs " + shark.getSize() + " pounds. "
                + "Your shark eats " + animal.getFood() + ".");
        System.out
                .println("Is your shark in water? Hopefully they are, but the answer is " + shark.getIsInWater() + ".");
    }

}
