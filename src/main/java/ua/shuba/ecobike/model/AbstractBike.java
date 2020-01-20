package ua.shuba.ecobike.model;

import java.util.Objects;

public abstract class AbstractBike implements Bike {

    private String brand;
    private int weight;
    private boolean availabilityLights;
    private String color;
    private int price;



    protected String hasLights() {
        return availabilityLights ? "" : "no ";
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isAvailabilityLights() {
        return availabilityLights;
    }

    public void setAvailabilityLights(boolean availabilityLights) {
        this.availabilityLights = availabilityLights;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractBike that = (AbstractBike) o;
        return getWeight() == that.getWeight() &&
                isAvailabilityLights() == that.isAvailabilityLights() &&
                getPrice() == that.getPrice() &&
                getBrand().equals(that.getBrand()) &&
                getColor().equals(that.getColor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBrand(), getWeight(), isAvailabilityLights(), getColor(), getPrice());
    }
}
