package ua.shuba.ecobike.processors.impl;

import ua.shuba.ecobike.io.UserInteraction;
import ua.shuba.ecobike.model.Bike;
import ua.shuba.ecobike.model.BikeStorage;
import ua.shuba.ecobike.processors.Strategy;

public class FindFirstByBrandStrategy extends Strategy {

    private UserInteraction userInteraction;

    public FindFirstByBrandStrategy(BikeStorage bikeStorage, UserInteraction userInteraction) {
        super(bikeStorage);
        this.userInteraction = userInteraction;
    }

    @Override
    public void process() {
        String brand = userInteraction.askBrand();
        int weight = userInteraction.askWeight();
        String color = userInteraction.askColor();
        int price = userInteraction.askPrice();
        findBike(brand, weight, color, price);
    }

    private void findBike(String brand, int weight, String color, int price) {
        for (Bike bike : getBikeStorage().getBikeList()) {
            if (checkBrand(brand, bike.getBrand())
                    && checkWeight(weight, bike.getWeight())
                    && checkColor(color, bike.getColor())
                    && checkPrice(price, bike.getPrice())) {
                System.out.println(bike);
                return;
            }
        }
        System.out.println("A bike with such parameters was not found.");
    }

    private boolean checkPrice(int price, int bikePrice) {
        return price == 0 || price == bikePrice;
    }

    private boolean checkColor(String color, String bikeColor) {
        return color.isEmpty() || color.equals(bikeColor);
    }

    private boolean checkWeight(int weight, int bikeWeight) {
        return weight == 0 || weight == bikeWeight;
    }

    private boolean checkBrand(String brand, String bikeBrand) {
        return brand.isEmpty() || brand.equals(bikeBrand);
    }
}
