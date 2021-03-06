package main.io.java.gojek.parkinglot1.processor;

import main.io.java.gojek.parkinglot1.constants.Constants;
import main.io.java.gojek.parkinglot1.exception.ParkingException;
import main.io.java.gojek.parkinglot1.exception.Error;
import main.io.java.gojek.parkinglot1.constants.InputValidation;
import main.io.java.gojek.parkinglot1.service.AbstractService;


public interface Validation {

    public void setService(AbstractService service);

    public void execute(String action) throws ParkingException;

    public default boolean validate(String input)throws ParkingException{

        boolean valid = false;
        try
        {
            String[] inputs = input.split(" ");
            int key = InputValidation.getValidInput().get(inputs[0]);
            switch (inputs.length)
            {
                case 1:
                    if (key == 0) // e.g status -> inputs = 1
                        valid = true;
                    break;
                case 2:
                    if (key == 1) // create_parking_lot 6 -> inputs = 2
                        valid = true;
                    break;
                case 3:
                    if (key == 2) // park KA-01-P-333 White -> inputs = 3
                        valid = true;
                    break;
                default:
                    valid = false;
            }
        }
        catch (Exception e)
        {
            valid = false;
        }
        return valid;


    }

}
