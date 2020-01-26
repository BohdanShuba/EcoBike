package ua.shuba.ecobike.processors.impl;

import ua.shuba.ecobike.model.Bike;
import ua.shuba.ecobike.model.BikeStorage;
import ua.shuba.ecobike.processors.Strategy;

/**
 * Concrete strategy. Show all Bikes.
 */

public class ShowBikesStrategy extends Strategy {

    public ShowBikesStrategy(BikeStorage bikeStorage) {
        super(bikeStorage);
    }

    @Override
    public void process() {
        for (Bike bikes : getBikeStorage().getBikeList()) {
            System.out.println(bikes.toString());
        }
    }
}
