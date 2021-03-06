package ua.shuba.ecobike.io.impl;

import ua.shuba.ecobike.exception.EcoBikeException;
import ua.shuba.ecobike.io.UserInteraction;
import ua.shuba.ecobike.model.Bike;
import ua.shuba.ecobike.model.EBike;
import ua.shuba.ecobike.model.FoldingBike;
import ua.shuba.ecobike.model.Speedelec;
import ua.shuba.ecobike.processors.StrategyType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * The ConsoleUserInteraction class displays the user interface
 * and makes it possible to enter the required data through the console.
 */
public class ConsoleUserInteraction implements UserInteraction {

    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public void printMenu() {
        StringBuilder message = new StringBuilder("Please make your choice:\n");
        for (StrategyType strategyType : StrategyType.values()) {
            message.append(strategyType.getI()).append(" - ").append(strategyType.getText()).append("\n");
        }
        printMessage(message.toString());

    }

    @Override
    public StrategyType readProcessorType() {
        while (true) {
            try {
                return StrategyType.getByI(readNumberString());
            } catch (EcoBikeException e) {
                printMessage("Wrong value.");
                printMenu();
            }
        }
    }

    @Override
    public Bike readSpeedelec() {
        Speedelec bike = new Speedelec();
        bike.setBrand(askBrand());
        bike.setWeight(askWeight());
        bike.setMaxSpeed(askMaxSpeed());
        bike.setAvailabilityLights(askLightAvailable());
        bike.setBatteryCapacity(askCapacity());
        bike.setColor(askColor());
        bike.setPrice(askPrice());
        return bike;
    }

    @Override
    public Bike readEbike() {
        EBike bike = new EBike();
        bike.setBrand(askBrand());
        bike.setWeight(askWeight());
        bike.setMaxSpeed(askMaxSpeed());
        bike.setAvailabilityLights(askLightAvailable());
        bike.setColor(askColor());
        bike.setBatteryCapacity(askCapacity());
        bike.setPrice(askPrice());
        return bike;
    }

    @Override
    public Bike readFoldingBike() {
        FoldingBike bike = new FoldingBike();
        bike.setBrand(askBrand());
        bike.setSizeWheels(askSizeWheels());
        bike.setNumberGears(askNumberGears());
        bike.setWeight(askWeight());
        bike.setAvailabilityLights(askLightAvailable());
        bike.setColor(askColor());
        bike.setPrice(askPrice());
        return bike;
    }

    private String readConsoleString() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new EcoBikeException("Cannot read line");
        }
    }

    private int readNumberString() {
        while (true) {
            String s = "";
            try {
                s = readConsoleString();
                int number = Integer.parseInt(s);
                if (number < 0) throw new NumberFormatException("Number is less than zero");
                return number;
            } catch (NumberFormatException e) {
                printMessage("Wrong number " + s);
            }
        }
    }

    private Boolean readBoolString() {
        while (true) {
            String s = "";
            try {
                s = readConsoleString().toLowerCase();
                if (!(s.equals("true") || s.equals("false")))
                    throw new IllegalArgumentException("Enter true or false.");
                return Boolean.valueOf(s);
            } catch (IllegalArgumentException e) {
                printMessage("Wrong data " + s);
            }
        }
    }

    public String askFilePath() {
        printMessage("Enter the file path to which you want to write bikes: ");
        return readConsoleString();
    }

    public String askFileName() {
        printMessage("Enter the file name: ");
        return readConsoleString();
    }

    public String askBrand() {
        printMessage("Input a brand: ");
        return readConsoleString();
    }

    private void printMessage(String s) {
        System.out.println(s);
    }

    public int askWeight() {
        printMessage("Input the weight of the bike (in grams): ");
        return readNumberString();
    }

    public boolean askLightAvailable() {
        printMessage("Input the availability of lights at front and back (TRUE/FALSE): ");
        return readBoolString();
    }

    public String askColor() {
        printMessage("Input a color: ");
        return readConsoleString();
    }

    public int askPrice() {
        printMessage("Input the price: ");
        return readNumberString();
    }

    private int askNumberGears() {
        printMessage("Input the number of gears: ");
        return readNumberString();
    }

    private int askSizeWheels() {
        printMessage("Input the size of the wheels (in inch): ");
        return readNumberString();
    }

    private int askCapacity() {
        printMessage("Input the battery capacity (in mAh): ");
        return readNumberString();
    }


    private int askMaxSpeed() {
        printMessage("Input the maximum speed (in km/h): ");
        return readNumberString();
    }

}
