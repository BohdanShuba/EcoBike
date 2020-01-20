package ua.shuba.ecobike.factory;

import ua.shuba.ecobike.exception.EcoBikeException;
import ua.shuba.ecobike.model.*;

public class BikeFactory {

    public Bike createBike(String bikeString) {
        switch (getTypeBike(bikeString)) {
            case FOLDING_BIKE:
                return createFoldingBike(bikeString);
            case SPEEDELEC:
                return createSpeedelec(bikeString);
            case E_BIKE:
                return createEBike(bikeString);
            default:
                throw new EcoBikeException("Wrong bike type: " + bikeString);
        }
    }

    private Bike createEBike(String bikeString) {
        EBike eBike = new EBike();
        bikeString = bikeString.substring(BikeType.E_BIKE.getName().length() + 1);
        String[] str = bikeString.split("; ");
        eBike.setBrand(str[0]);
        eBike.setMaxSpeed(Integer.parseInt(str[1]));
        eBike.setWeight(Integer.parseInt(str[2]));
        eBike.setAvailabilityLights(Boolean.valueOf(str[3]));
        eBike.setBatteryCapacity(Integer.parseInt(str[4]));
        eBike.setColor(str[5]);
        eBike.setPrice(Integer.parseInt(str[6]));
        return eBike;
    }

    private Bike createFoldingBike(String bikeString) {
        FoldingBike foldingBike = new FoldingBike();
        bikeString = bikeString.substring(BikeType.FOLDING_BIKE.getName().length() + 1);
        String[] str = bikeString.split("; ");
        foldingBike.setBrand(str[0]);
        foldingBike.setSizeWheels(Integer.parseInt(str[1]));
        foldingBike.setNumberGears(Integer.parseInt(str[2]));
        foldingBike.setWeight(Integer.parseInt(str[3]));
        foldingBike.setAvailabilityLights(Boolean.valueOf(str[4]));
        foldingBike.setColor(str[5]);
        foldingBike.setPrice(Integer.parseInt(str[6]));
        return foldingBike;
    }

    private Bike createSpeedelec(String bikeString) {
        Speedelec speedelec = new Speedelec();
        bikeString = bikeString.substring(BikeType.SPEEDELEC.getName().length() + 1);
        String[] str = bikeString.split("; ");
        speedelec.setBrand(str[0]);
        speedelec.setMaxSpeed(Integer.parseInt(str[1]));
        speedelec.setAvailabilityLights(Boolean.valueOf(str[3]));
        speedelec.setWeight(Integer.parseInt(str[2]));
        speedelec.setBatteryCapacity(Integer.parseInt(str[4]));
        speedelec.setColor(str[5]);
        speedelec.setPrice(Integer.parseInt(str[6]));
        return speedelec;
    }

    private BikeType getTypeBike(String bikeString) {
        for (BikeType typeBike : BikeType.values()) {
            if (typeBike.getName().equals(bikeString.substring(0, typeBike.getName().length())))
                return typeBike;
        }
        throw new EcoBikeException("Wrong bike type: " + bikeString);
    }
}
