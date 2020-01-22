package ua.shuba.ecobike.factory;

import ua.shuba.ecobike.exception.EcoBikeException;
import ua.shuba.ecobike.io.UserInteraction;
import ua.shuba.ecobike.model.BikeStorage;
import ua.shuba.ecobike.processors.Strategy;
import ua.shuba.ecobike.processors.StrategyType;
import ua.shuba.ecobike.processors.impl.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class StrategyFactory {

    private Map<StrategyType, Strategy> strategies = new HashMap<>();

    public StrategyFactory(BikeStorage bikeStorage, UserInteraction userInteraction) {
        strategies.put(StrategyType.SHOW_BIKES, new ShowBikesStrategy(bikeStorage));
        strategies.put(StrategyType.ADD_FOLDING_BIKE, new AddFoldingBikeStrategy(bikeStorage, userInteraction));
        strategies.put(StrategyType.ADD_SPEEDELEC, new AddSpeedelecStrategy(bikeStorage, userInteraction));
        strategies.put(StrategyType.ADD_EBIKE, new AddEBikeStrategy(bikeStorage, userInteraction));
        strategies.put(StrategyType.FIND_BY_BRAND, new FindFirstByBrandStrategy(bikeStorage, userInteraction));
        strategies.put(StrategyType.WRITE_TO_FILE, new WriteToFileStrategy(bikeStorage));
        strategies.put(StrategyType.STOP_THE_PROGRAM, new StopProgramStrategy(bikeStorage));

    }

    public Strategy getStrategy(StrategyType strategyType) {
        return Optional.ofNullable(strategies.get(strategyType))
                .orElseThrow(() -> new EcoBikeException("Strategy not found: " + strategyType));
    }
}
