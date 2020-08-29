package inheritance.lesson1;

public class SmartCar extends Car {

    private boolean isCharging;

    public SmartCar(String make, String model) {
        super(make, model);
    }

    public void setIsCharging(boolean charging) {
        isCharging = charging;
    }

    public boolean getIsCharging() {
        return isCharging;
    }

}