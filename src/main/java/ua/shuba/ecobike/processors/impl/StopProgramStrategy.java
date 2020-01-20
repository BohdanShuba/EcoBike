package ua.shuba.ecobike.processors.impl;

import ua.shuba.ecobike.model.BikeStorage;
import ua.shuba.ecobike.processors.Strategy;

public class StopProgramStrategy extends Strategy {

    public StopProgramStrategy(BikeStorage bikeStorage) {
        super(bikeStorage);
    }

    @Override
    public void process() {
        System.exit(0);
    }
}
