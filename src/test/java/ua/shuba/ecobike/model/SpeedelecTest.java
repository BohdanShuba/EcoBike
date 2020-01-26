package ua.shuba.ecobike.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SpeedelecTest {
    @Test
    public void toLineTest() {
        String expectedLineSpeedelec = "SPEEDELEC Smart; 40; 9600; false; 13000; brown; 1065";

        Speedelec speedelec = new Speedelec();
        speedelec.setBrand("Smart");
        speedelec.setMaxSpeed(40);
        speedelec.setWeight(9600);
        speedelec.setAvailabilityLights(false);
        speedelec.setBatteryCapacity(13000);
        speedelec.setColor("brown");
        speedelec.setPrice(1065);
        String actualBikeToLine = speedelec.toLine();

        assertEquals("Writing a Bike to line is wrong: ", expectedLineSpeedelec, actualBikeToLine);
    }
}
