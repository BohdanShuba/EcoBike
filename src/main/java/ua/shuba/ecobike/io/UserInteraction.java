package ua.shuba.ecobike.io;

import ua.shuba.ecobike.model.Bike;
import ua.shuba.ecobike.processors.StrategyType;

public interface UserInteraction {

    void printMenu();

    StrategyType readProcessorType();

    Bike readEbike();

    Bike readFoldingBike();

    Bike readSpeedelec();

    String askFilePath();

    String askFileName();

    String askBrand();

    String askColor();

    int askWeight();

    int askPrice();

}
