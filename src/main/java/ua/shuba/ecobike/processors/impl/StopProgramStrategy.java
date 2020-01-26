package ua.shuba.ecobike.processors.impl;

import ua.shuba.ecobike.model.BikeStorage;
import ua.shuba.ecobike.processors.Strategy;

/**
 * Concrete strategy. Stops the program. Checks for unsaved Bikes.
 */

public class StopProgramStrategy extends Strategy {

    public StopProgramStrategy(BikeStorage bikeStorage) {
        super(bikeStorage);
    }

    @Override
    public void process() {
        if (getBikeStorage().isUnsavedData()) System.out.println("There are unsaved files. Save bikes before exiting the program.\n");
        else System.exit(0);
    }
}
