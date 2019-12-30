package main.io.java.gojek.parkinglot1.processor;

import main.io.java.gojek.parkinglot1.constants.Constants;
import main.io.java.gojek.parkinglot1.exception.ParkingException;
import main.io.java.gojek.parkinglot1.exception.Error;


public class Validation {

    public boolean validate(String input)throws ParkingException{

        boolean valid = false;

        try {
            String[] inputs = input.trim().split(" ");
            int length = inputs.length;
            switch (length) {

                case 1: //for status input

                    if(inputs[0].equalsIgnoreCase(Constants.STATUS)){
                    valid = true;}
                    break;

                case 2: // create parking lot
                        // leave
                        // registration no for given color
                        // slot no for given color
                        // slot no for given registration no


                    if(inputs[0].equalsIgnoreCase(Constants.CREATE_PARKING_LOT)){
                        try {
                            int capacity = Integer.parseInt(inputs[1]);
                            valid = true;
                            break;
                        }
                        catch(Exception e){
                            valid = false;
                            break;
                            //throw new ParkingException(Error.INVALID_VALUE.getMessage() , e);
                        }
                    }

                    else if(inputs[0].equalsIgnoreCase(Constants.LEAVE)){
                        try {
                            int slot = Integer.parseInt(inputs[1]);
                            valid = true;
                            break;
                        }
                        catch(Exception e){
                            valid = false;
                            break;
                            //throw new ParkingException(Error.INVALID_VALUE.getMessage() , e);
                        }
                    }

                    else if(inputs[0].equalsIgnoreCase(Constants.REG_NO_FOR_CARS_WITH_COLOR)){
                       valid = true;
                       break;
                    }

                    else if(inputs[0].equalsIgnoreCase(Constants.SLOTS_NUMBER_FOR_CARS_WITH_COLOR)){
                        valid = true;
                        break;
                    }

                    else if(inputs[0].equalsIgnoreCase(Constants.SLOTS_NUMBER_FOR_REG_NUMBER)){
                        valid = true;
                        break;
                    }


                case 3:
                    if(inputs[0].equalsIgnoreCase(Constants.PARK)){

                        valid = true;
                        break;
                    }


                default:
                    valid = false;
                    break;

            }
        }
        catch(Exception e){
            valid = false;
        }

      return valid;
    }

}
