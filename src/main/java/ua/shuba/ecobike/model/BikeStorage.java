package ua.shuba.ecobike.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * The BikeStorage class stores read and user entered bikes. Also checks the changes were saved.
 */

public class BikeStorage {
    private final List<Bike> bikeList;
    private boolean unsavedData;
    
    public BikeStorage(List<Bike> bikeList) {
        this.bikeList = new ArrayList<>(bikeList);
    }

    public List<Bike> getBikeList() {
        return Collections.unmodifiableList(bikeList);
    }

    public void addBike(Bike bike) {
        bikeList.add(bike);
        unsavedData = true;
    }

    public boolean isUnsavedData() {
        return unsavedData;
    }

    public void setSaved() {
        this.unsavedData = false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BikeStorage that = (BikeStorage) o;
        return Objects.equals(bikeList, that.bikeList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bikeList);
    }
}
