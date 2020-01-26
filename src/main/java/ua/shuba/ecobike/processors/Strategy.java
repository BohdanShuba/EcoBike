package ua.shuba.ecobike.processors;

import ua.shuba.ecobike.model.BikeStorage;

/**
 * General view for all strategies.
 */

public abstract class Strategy {

    private BikeStorage bikeStorage;

    public Strategy(BikeStorage bikeStorage) {
        this.bikeStorage = bikeStorage;
    }

    public abstract void process();

    protected BikeStorage getBikeStorage() {
        return bikeStorage;
    }
}
