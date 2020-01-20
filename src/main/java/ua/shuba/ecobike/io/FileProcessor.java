package ua.shuba.ecobike.io;

import ua.shuba.ecobike.model.Bike;

import java.io.File;
import java.util.List;

public interface FileProcessor {

    List<Bike> readBikes(File file);

    void writeBikes(List<Bike> bikes, File file);
}
