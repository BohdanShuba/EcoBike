package ua.shuba.ecobike.io.impl;

import ua.shuba.ecobike.exception.EcoBikeException;
import ua.shuba.ecobike.factory.BikeFactory;
import ua.shuba.ecobike.io.FileProcessor;
import ua.shuba.ecobike.model.Bike;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The FileProcessorImpl class is responsible for reading Bikes from and writing Bikes to a file.
 */

public class FileProcessorImpl implements FileProcessor {

    private BikeFactory bikeFactory;

    public FileProcessorImpl(BikeFactory bikeFactory) {
        this.bikeFactory = bikeFactory;
    }

    @Override
    public List<Bike> readBikes(File file) {
        List<Bike> bikes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            String bikeString;
            while (Objects.nonNull(bikeString = reader.readLine())) {
                Bike bike = bikeFactory.createBike(bikeString);
                bikes.add(bike);
            }
            return bikes;
        } catch (IOException e) {
            throw new EcoBikeException("Cannot read bikes file", e);
        }
    }

    @Override
    public void writeBikes(List<Bike> bikes, File file) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            for (Bike bike : bikes) {
                bufferedWriter.write(bike.toLine());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new EcoBikeException("Cannot write bikes file", e);
        }
    }
}
