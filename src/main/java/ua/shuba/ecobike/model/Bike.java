package ua.shuba.ecobike.model;

public interface Bike {
    String toLine();
    String getBrand();
    int getWeight();
    boolean isAvailabilityLights();
    String getColor();
    int getPrice();
}
