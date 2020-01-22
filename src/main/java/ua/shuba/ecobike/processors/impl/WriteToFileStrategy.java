package ua.shuba.ecobike.processors.impl;

import ua.shuba.ecobike.io.FileProcessor;
import ua.shuba.ecobike.model.BikeStorage;
import ua.shuba.ecobike.processors.Strategy;

import java.io.File;

public class WriteToFileStrategy extends Strategy {

    private FileProcessor fileProcessor;

    public WriteToFileStrategy(BikeStorage bikeStorage) {
        super(bikeStorage);
    }

    @Override
    public void process(){
       fileProcessor.writeBikes(getBikeStorage().getBikeList(), new File("C:\\Users\\Bohdan\\Документы\\ecobike.txt"));

    }
}
