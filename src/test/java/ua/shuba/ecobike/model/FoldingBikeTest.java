package ua.shuba.ecobike.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FoldingBikeTest {

    @Test
    public void toLineTest() {
        String expectedLineFoldingBike = "FOLDING BIKE Brompton; 20; 7; 10800; true; orange; 1469";

        FoldingBike foldingBike = new FoldingBike();
        foldingBike.setBrand("Brompton");
        foldingBike.setSizeWheels(20);
        foldingBike.setNumberGears(7);
        foldingBike.setWeight(10800);
        foldingBike.setAvailabilityLights(true);
        foldingBike.setColor("orange");
        foldingBike.setPrice(1469);
        String actualBikeToLine = foldingBike.toLine();

        assertEquals("Writing a Bike to line is wrong: ", expectedLineFoldingBike, actualBikeToLine);
    }
}
