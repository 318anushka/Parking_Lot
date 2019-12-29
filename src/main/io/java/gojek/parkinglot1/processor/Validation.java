package main.io.java.gojek.parkinglot1.processor;

import main.io.java.gojek.parkinglot1.constants.Constants;

public class Validation {

    public boolean validate(String input){

        boolean valid = false;

        String[] inputs = input.split(" ");
        switch(inputs[0]){

            case Constants.CREATE_PARKING_LOT:
                valid  = true;
                break;

            case Constants.PARK:
                valid = true;
                break;

            case Constants.LEAVE:
                valid = true;
                break;

            case Constants.STATUS:
                valid = true;
                break;

            case Constants.REG_NO_FOR_CARS_WITH_COLOR:
                valid = true;
                break;

            case Constants.SLOTS_NUMBER_FOR_CARS_WITH_COLOR:
                valid = true;
                break;

            case Constants.SLOTS_NUMBER_FOR_REG_NUMBER:
                valid = true;
                break;

            default:
                valid = false;
                break;

        }

      return valid;
    }

}
