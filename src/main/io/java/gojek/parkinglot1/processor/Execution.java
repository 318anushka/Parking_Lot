package main.io.java.gojek.parkinglot1.processor;

import main.io.java.gojek.parkinglot1.constants.Constants;
import main.io.java.gojek.parkinglot1.exception.ParkingException;
import main.io.java.gojek.parkinglot1.model.Car;
import main.io.java.gojek.parkinglot1.model.Vehicle;
import main.io.java.gojek.parkinglot1.service.AbstractService;
import main.io.java.gojek.parkinglot1.service.ParkingService;
import main.io.java.gojek.parkinglot1.exception.Error;

import java.util.Optional;

public class Execution implements Validation{

    private ParkingService parkingService ;

    public void setParkingService(ParkingService parkingService) throws ParkingException{
        this.parkingService = parkingService;
    }

    @Override
    public void setService(AbstractService service) {

        this.parkingService = (ParkingService) service;

    }

    public void execute(String input) throws ParkingException {
        String[] inputs = input.split(" ");
        String in = inputs[0];

        switch(in){

            case Constants.CREATE_PARKING_LOT:

                try {
                    int capacity = Integer.parseInt(inputs[1]);
                    parkingService.createParkingLot(capacity);
                }
                catch(NumberFormatException e) {
                    //System.out.println("Invalid value input");
                    throw new ParkingException(Error.INVALID_VALUE.getMessage(), e);

                }

                break;

            case Constants.PARK:

                parkingService.park(new Car(inputs[1] , inputs[2]));
                break;

            case Constants.LEAVE:

                try {
                    parkingService.leave(Integer.parseInt(inputs[1]));
                }
                catch(NumberFormatException e){
                    //System.out.println("Invalid Slot Number");
                    throw new ParkingException(Error.INVALID_VALUE.getMessage(), e);
                }
                break;

            case Constants.STATUS:

                parkingService.getStatus();
                break;

            case Constants.REG_NO_FOR_CARS_WITH_COLOR:

                parkingService.getRegistrationNoFromColor(inputs[1]);
                break;


            case Constants.SLOTS_NUMBER_FOR_CARS_WITH_COLOR:

                parkingService.getSlotNoFromColor(inputs[1]);
                break;

            case Constants.SLOTS_NUMBER_FOR_REG_NUMBER:

                parkingService.getSlotNoFromRegistrationNo(inputs[1]);
                break;

            default:
                break;
        }



    }


}
