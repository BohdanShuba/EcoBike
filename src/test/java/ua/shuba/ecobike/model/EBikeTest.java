package ua.shuba.ecobike.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EBikeTest {
    @Test
    public void toLineTest() {
        String expectedLineEBike = "E-BIKE Felt; 60; 28300; false; 9000; grey; 2229";
        EBike eBike = new EBike();
        eBike.setBrand("Felt");
        eBike.setMaxSpeed(60);
        eBike.setWeight(28300);
        eBike.setAvailabilityLights(false);
        eBike.setBatteryCapacity(9000);
        eBike.setColor("grey");
        eBike.setPrice(2229);
        String actualBikeToLine = eBike.toLine();

        assertEquals("Writing a Bike to line is wrong: ", expectedLineEBike, actualBikeToLine);
    }
}
