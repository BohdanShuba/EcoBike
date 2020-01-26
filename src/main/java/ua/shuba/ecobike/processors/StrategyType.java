package ua.shuba.ecobike.processors;

import ua.shuba.ecobike.exception.EcoBikeException;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * The StrategyType enumeration contains various program strategies.
 */

public enum StrategyType {
    SHOW_BIKES(1, "Show the entire EcoBike catalog"),
    ADD_FOLDING_BIKE(2, "Add a new folding bike"),
    ADD_SPEEDELEC(3, "Add a new speedelec"),
    ADD_EBIKE(4, "Add a new e-bike"),
    FIND_BY_BRAND(5, "Find the first item of a particular brand"),
    WRITE_TO_FILE(6, "Write to file"),
    STOP_THE_PROGRAM(7, "Stop the program");

    private static final Map<Integer, StrategyType> typesMap;
    private final int i;
    private final String text;

    static {
        typesMap = new HashMap<>();
        for (StrategyType type : StrategyType.values()) {
            typesMap.put(type.getI(), type);
        }
    }

    StrategyType(int i, String text) {
        this.i = i;
        this.text = text;
    }

    public int getI() {
        return i;
    }

    public String getText() {
        return text;
    }

    public static StrategyType getByI(int i) {
        return Optional.ofNullable(typesMap.get(i))
                .orElseThrow(() -> new EcoBikeException("Type not found " + i));
    }
}
