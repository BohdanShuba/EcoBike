package ua.shuba.ecobike.model;

import java.util.Objects;

public class Speedelec extends AbstractBike{

    private int maxSpeed;
    private int batteryCapacity;

    @Override
    public String toString() {
        return BikeType.SPEEDELEC.getName() + " " + getBrand() + " with " + batteryCapacity + " mAh battery and " + hasLights() + "head/tail light.\n" +
                "Price: " + getPrice() + " euros.";
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!super.equals(o) || getClass() != o.getClass()) return false;
        Speedelec speedelec = (Speedelec) o;
        return getMaxSpeed() == speedelec.getMaxSpeed() &&
                getBatteryCapacity() == speedelec.getBatteryCapacity();
    }

    @Override
    public int hashCode() {
        return Objects.hash(maxSpeed, batteryCapacity);
    }
}
