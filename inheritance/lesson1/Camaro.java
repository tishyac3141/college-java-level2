package inheritance.lesson1;

public class Camaro extends Car {
    private int speed;

    public Camaro(String make, String model) {
        super(make, model);
    }

    public void setSpeed(int newSpeed) {
        speed = newSpeed;
    }

    public int getSpeed() {
        return speed;
    }
}