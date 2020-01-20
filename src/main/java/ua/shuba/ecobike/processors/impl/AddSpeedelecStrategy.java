package ua.shuba.ecobike.processors.impl;

import ua.shuba.ecobike.io.UserInteraction;
import ua.shuba.ecobike.model.BikeStorage;
import ua.shuba.ecobike.processors.Strategy;

public class AddSpeedelecStrategy extends Strategy {

    private UserInteraction userInteraction;

    public AddSpeedelecStrategy(BikeStorage bikeStorage, UserInteraction userInteraction) {
        super(bikeStorage);
        this.userInteraction = userInteraction;
    }

    @Override
    public void process() {
        getBikeStorage().addBike(userInteraction.readSpeedelec());
    }
}
