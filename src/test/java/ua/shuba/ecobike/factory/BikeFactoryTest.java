package ua.shuba.ecobike.factory;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ua.shuba.ecobike.exception.EcoBikeException;
import ua.shuba.ecobike.model.Bike;
import ua.shuba.ecobike.model.EBike;
import ua.shuba.ecobike.model.FoldingBike;
import ua.shuba.ecobike.model.Speedelec;

import static org.junit.Assert.assertEquals;

public class BikeFactoryTest {
    private BikeFactory bikeFactory;

    @Before
    public void initBikeFactory() {
        bikeFactory = new BikeFactory();
    }

    @After
    public void clearBikeFactory() {
        bikeFactory = null;
    }

    @Test
    public void createBikeForFoldingBikeTest() {
        FoldingBike expectedFoldingBike = new FoldingBike();
        expectedFoldingBike.setBrand("Brompton");
        expectedFoldingBike.setSizeWheels(20);
        expectedFoldingBike.setNumberGears(7);
        expectedFoldingBike.setWeight(10800);
        expectedFoldingBike.setAvailabilityLights(true);
        expectedFoldingBike.setColor("orange");
        expectedFoldingBike.setPrice(1469);
        Bike expectedBike = expectedFoldingBike;

        String lineFoldingBike = "FOLDING BIKE Brompton; 20; 7; 10800; true; orange; 1469";
        Bike actualBike = bikeFactory.createBike(lineFoldingBike);

        assertEquals("Bike for expected Bike is wrong: ", expectedBike, actualBike);
    }

    @Test
    public void createBikeForSpeedelecTypeTest() {
        Speedelec expectedSpeedelec = new Speedelec();
        expectedSpeedelec.setBrand("Smart");
        expectedSpeedelec.setMaxSpeed(40);
        expectedSpeedelec.setWeight(9600);
        expectedSpeedelec.setAvailabilityLights(false);
        expectedSpeedelec.setBatteryCapacity(13000);
        expectedSpeedelec.setColor("brown");
        expectedSpeedelec.setPrice(1065);
        Bike expectedBike = expectedSpeedelec;

        String lineSpeedelec = "SPEEDELEC Smart; 40; 9600; false; 13000; brown; 1065";
        Bike actualBike = bikeFactory.createBike(lineSpeedelec);

        assertEquals("Bike for expected Bike is wrong: ", expectedBike, actualBike);
    }

    @Test
    public void createBikeForEBikeTypeTest() {
        EBike expectedEBike = new EBike();
        expectedEBike.setBrand("Felt");
        expectedEBike.setMaxSpeed(60);
        expectedEBike.setWeight(28300);
        expectedEBike.setAvailabilityLights(false);
        expectedEBike.setBatteryCapacity(9000);
        expectedEBike.setColor("grey");
        expectedEBike.setPrice(2229);
        Bike expectedBike = expectedEBike;

        String lineEBike = "E-BIKE Felt; 60; 28300; false; 9000; grey; 2229";
        Bike actualBike = bikeFactory.createBike(lineEBike);

        assertEquals("Bike for expected Bike is wrong: ", expectedBike, actualBike);
    }

    @Test(expected = EcoBikeException.class)
    public void createBikeForNonexistentTypeTest() {
        String bike = "PORTABLE BIKE Brompton; 20; 7; 10800; true; orange; 1469";
        Bike actualBike = bikeFactory.createBike(bike);
        Assert.assertEquals("For type \"PORTABLE BIKE\" wasn't exception: ", actualBike);
    }

}
