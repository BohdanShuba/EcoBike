package ua.shuba.ecobike.processors.impl;

import ua.shuba.ecobike.exception.EcoBikeException;
import ua.shuba.ecobike.io.FileProcessor;
import ua.shuba.ecobike.io.UserInteraction;
import ua.shuba.ecobike.model.BikeStorage;
import ua.shuba.ecobike.processors.Strategy;

import java.io.File;

public class WriteToFileStrategy extends Strategy {

    private FileProcessor fileProcessor;
    private UserInteraction userInteraction;

    public WriteToFileStrategy(BikeStorage bikeStorage, UserInteraction userInteraction, FileProcessor fileProcessor) {
        super(bikeStorage);
        this.userInteraction = userInteraction;
        this.fileProcessor = fileProcessor;
    }

    @Override
    public void process() {
        File file = new File(createPathFile(), userInteraction.askFileName() + ".txt");
        System.out.println(file.getAbsoluteFile());
        fileProcessor.writeBikes(getBikeStorage().getBikeList(), file);
        getBikeStorage().setSaved();
    }

    private File createPathFile() {
        File file;
        while (true) {
            file = new File(userInteraction.askFilePath());
            try {
                if (!file.exists())
                    if (!file.mkdirs()) throw new EcoBikeException("Failed to create path.");
                return file;
            } catch (EcoBikeException e) {
                System.out.println("Wrong file path " + e);
            } catch (SecurityException e) {
                System.out.println("Writing to this folder is forbidden:" + e);
            }
        }
    }
}