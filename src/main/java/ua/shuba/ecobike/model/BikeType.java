package ua.shuba.ecobike.model;

public enum  BikeType {

    FOLDING_BIKE("FOLDING BIKE"),
    SPEEDELEC("SPEEDELEC"),
    E_BIKE("E-BIKE");

    private String name;

    BikeType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
