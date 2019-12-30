package main.io.java.gojek.parkinglot1.constants;

import java.util.HashMap;
import java.util.Map;

public class InputValidation {

    private static volatile Map<String, Integer> validInput  = new HashMap<String, Integer>();

    static
    {
        validInput.put(Constants.CREATE_PARKING_LOT, 1);
        validInput.put(Constants.PARK, 2);
        validInput.put(Constants.LEAVE, 1);
        validInput.put(Constants.STATUS, 0);
        validInput.put(Constants.REG_NO_FOR_CARS_WITH_COLOR, 1);
        validInput.put(Constants.SLOTS_NUMBER_FOR_CARS_WITH_COLOR, 1);
        validInput.put(Constants.SLOTS_NUMBER_FOR_REG_NUMBER, 1);
    }


}



