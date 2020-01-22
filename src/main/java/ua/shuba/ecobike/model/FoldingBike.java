package ua.shuba.ecobike.model;

import java.util.Objects;

public class FoldingBike extends AbstractBike {

    private int sizeWheels;
    private int numberGears;

    public int getSizeWheels() {
        return sizeWheels;
    }

    public void setSizeWheels(int sizeWheels) {
        this.sizeWheels = sizeWheels;
    }

    public int getNumberGears() {
        return numberGears;
    }

    public void setNumberGears(int numberGears) {
        this.numberGears = numberGears;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!super.equals(o) || getClass() != o.getClass()) return false;
        FoldingBike that = (FoldingBike) o;
        return sizeWheels == that.sizeWheels &&
                numberGears == that.numberGears;
    }

    @Override
    public String toLine() {
        return BikeType.FOLDING_BIKE.getName() + " " + getBrand() + "; " + getSizeWheels() + "; " + getNumberGears() + "; " + getWeight() + "; "
                + isAvailabilityLights() + "; " + getColor() + "; " + getPrice();
    }

    @Override
    public int hashCode() {
        return Objects.hash(sizeWheels, numberGears);
    }

    @Override
    public String toString() {
        return BikeType.FOLDING_BIKE.getName() + " " + getBrand() + " with " + numberGears + " gear(s) and " + hasLights() + "head/tail light.\n" +
                "Price: " + getPrice() + " euros.";
    }
}
