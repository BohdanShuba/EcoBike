package ua.shuba.ecobike;

import ua.shuba.ecobike.io.UserInteraction;
import ua.shuba.ecobike.io.impl.ConsoleUserInteraction;
import ua.shuba.ecobike.io.impl.FileProcessorImpl;
import ua.shuba.ecobike.model.BikeStorage;
import ua.shuba.ecobike.factory.BikeFactory;
import ua.shuba.ecobike.factory.StrategyFactory;
import ua.shuba.ecobike.io.FileProcessor;
import ua.shuba.ecobike.processors.StrategyType;

import java.io.File;

import static java.util.Objects.isNull;

/**
 * Main class of the program.
 */

public class EcoBikeMain {

    public static void main(String[] args) {
        EcoBikeMain ecoBikeMain = new EcoBikeMain();
        ecoBikeMain.checkFilePresence(args);
        FileProcessor fileProcessor = new FileProcessorImpl(new BikeFactory());
        BikeStorage bikeStorage = new BikeStorage(fileProcessor.readBikes(new File(args[0])));
        UserInteraction userInteraction = new ConsoleUserInteraction();
        StrategyFactory strategyFactory = new StrategyFactory(bikeStorage, userInteraction, fileProcessor);

        while (true) {
            userInteraction.printMenu();
            StrategyType strategyType = userInteraction.readProcessorType();
            strategyFactory.getStrategy(strategyType)
                    .process();
        }
    }

    private void checkFilePresence(String[] args) {
        if (isNull(args) || args.length < 1 || !new File(args[0]).exists()) {
            System.out.println("File not found.");
            exit();
        }
    }

    private void exit() {
        System.exit(1);
    }
}
