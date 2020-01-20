package ua.shuba.ecobike.processors;

import ua.shuba.ecobike.model.BikeStorage;

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
