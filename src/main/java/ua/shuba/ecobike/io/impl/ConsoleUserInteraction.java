package ua.shuba.ecobike.io.impl;

import ua.shuba.ecobike.exception.EcoBikeException;
import ua.shuba.ecobike.io.UserInteraction;
import ua.shuba.ecobike.model.EBike;
import ua.shuba.ecobike.model.Bike;
import ua.shuba.ecobike.model.FoldingBike;
import ua.shuba.ecobike.model.Speedelec;
import ua.shuba.ecobike.processors.StrategyType;

import java.io.*;

public class ConsoleUserInteraction implements UserInteraction {

    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public void printMenu() {
        StringBuilder message = new StringBuilder("Please make your choice:\n");
        for (StrategyType strategyType : StrategyType.values()) {
            message.append(strategyType.getI()).append(" - ").append(strategyType.getText()).append("\n");
        }
        System.out.println(message.toString());

    }

    @Override
    public StrategyType readProcessorType() {
        while (true) {
            try {
                return StrategyType.getByI(readNumberString());
            } catch (EcoBikeException e) {
                System.out.println("Wrong value.");
                printMenu();
            }
        }
    }

    @Override
    public Bike readEbike() {
        EBike bike = new EBike();
        String brand = askBrand();
        bike.setBrand(brand);
        int weight = askWeight();
        bike.setWeight(weight);
        int maxSpeed = askMaxSpeed();
        bike.setMaxSpeed(maxSpeed);
        boolean isLightAsvailable = askLightAsvailable();
        bike.setAvailabilityLights(isLightAsvailable);
        String color = askColor();
        bike.setColor(color);
        int capacity = askCapacity();
        bike.setBatteryCapacity(capacity);
        int price = askPrice();
        bike.setPrice(price);
        return bike;
    }

    private String askColor() {
        System.out.println("Input a color: ");
        return readConsoleString();
    }

    private int askWeight() {
        System.out.println("Input the weight of the bike (in grams): ");
        return readNumberString();
    }

    @Override
    public Bike readFoldingBike() {
        FoldingBike bike = new FoldingBike();
        String brand = askBrand();
        bike.setBrand(brand);
        bike.setSizeWheels(askSizeWheeks());
        bike.setNumberGears(askNumberGears());
        int weight = askWeight();
        bike.setWeight(weight);
        boolean isLightAsvailable = askLightAsvailable();
        bike.setAvailabilityLights(isLightAsvailable);
        String color = askColor();
        bike.setColor(color);
        int price = askPrice();
        bike.setPrice(price);
        return bike;
    }

    private int askPrice() {
        System.out.println("Input the price: ");
        return readNumberString();
    }

    private int askNumberGears() {
        System.out.println("Input the number of gears: ");
        return readNumberString();
    }

    private int askSizeWheeks() {
        System.out.println("Input the size of the wheels (in inch): ");
        return readNumberString();
    }

    private String askBrand() {
        System.out.println("Input a brand: ");
        return readConsoleString();
    }

    @Override
    public Bike readSpeedelec() {
        Speedelec bike = new Speedelec();
        String brand = askBrand();
        bike.setBrand(brand);
        int maxSpeed = askMaxSpeed();
        bike.setMaxSpeed(maxSpeed);
        int weight = askWeight();
        bike.setWeight(weight);
        boolean isLightAsvailable = askLightAsvailable();
        bike.setAvailabilityLights(isLightAsvailable);
        int capacity = askCapacity();
        bike.setBatteryCapacity(capacity);
        String color = askColor();
        bike.setColor(color);
        int price = askPrice();
        bike.setPrice(price);
        return bike;
    }

    private int askCapacity() {
        System.out.println("Input the battery capacity (in mAh): ");
        return readNumberString();
    }

    private boolean askLightAsvailable() {
        System.out.println("Input the availability of lights at front and back (TRUE/FALSE): ");
        return readBoolString();
    }

    private int askMaxSpeed() {
        System.out.println("Input the maximum speed (in km/h): ");
        return readNumberString();
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
                return Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.println("Wrong number " + s);
            }
        }
    }

    private Boolean readBoolString() {
        while (true) {
            String s = "";
            try {
                s = readConsoleString();
                return Boolean.valueOf(s);
            } catch (NumberFormatException e) {
                System.out.println("Wrong number " + s);
            }
        }
    }
}
