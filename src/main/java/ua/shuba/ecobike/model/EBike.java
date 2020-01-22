package ua.shuba.ecobike.model;

public class EBike extends Speedelec {

    @Override
    public String toString() {
        return BikeType.E_BIKE.getName() + " " + super.getBrand() + " with " + super.getBatteryCapacity() + " mAh battery and " + hasLights() + "head/tail light.\n" +
                "Price: " + super.getPrice() + " euros.";
    }

    @Override
    public String toLine() {
        return BikeType.E_BIKE.getName() + " " + getBrand() + "; " + getMaxSpeed() + "; " + getWeight() + "; "
                + isAvailabilityLights() + "; " + getBatteryCapacity() + "; " + getColor() + "; " + getPrice();
    }
}
