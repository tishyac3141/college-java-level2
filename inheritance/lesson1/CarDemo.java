package inheritance.lesson1;

import java.util.Scanner;

public class CarDemo {
    public static void main(String[] args) {
        Car car = new Car("Toyota", "Camry");
        Camaro camaro = new Camaro("Camaro", "Chevy");
        SmartCar smartCar = new SmartCar("Smart", "Electric");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the make of the car: ");
        car.setMake(scanner.next());

        System.out.println("Enter the model of the car: ");
        car.setModel(scanner.next());

        System.out.println("The car's make is " + car.getMake() + " and the car's model is " + car.getModel() + ".");

        System.out.println("Enter the speed of your Camaro car: ");
        camaro.setSpeed(scanner.nextInt());

        System.out.println("The Camaro car can drive up to " + camaro.getSpeed() + " miles per hour!");

        System.out.println("Is your electric car charging? Type Y for yes and N for no: ");
        String choice = scanner.next();
        if (choice.equals("Y")) {
            smartCar.setIsCharging(true);
        } else {
            smartCar.setIsCharging(false);
        }

        System.out.println("Is your electric car currently charging? The answer is " + smartCar.getIsCharging() + ".");

        scanner.close();

    }

}