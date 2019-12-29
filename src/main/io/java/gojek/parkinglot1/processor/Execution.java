package main.io.java.gojek.parkinglot1.processor;

import main.io.java.gojek.parkinglot1.constants.Constants;
import main.io.java.gojek.parkinglot1.model.Car;
import main.io.java.gojek.parkinglot1.model.Vehicle;
import main.io.java.gojek.parkinglot1.service.ParkingService;

import java.util.Optional;

public class Execution {

    private ParkingService parkingService ;

    public void setParkingService(ParkingService parkingService){
        this.parkingService = parkingService;
    }

    public void execute(String input){
        String[] inputs = input.split(" ");
        String in = inputs[0];

        switch(in){

            case Constants.CREATE_PARKING_LOT:

                int capacity = Integer.parseInt(inputs[1]);
                parkingService.createParkingLot(capacity);
                break;

            case Constants.PARK:

                parkingService.park(new Car(inputs[1] , inputs[2]));
                break;

            case Constants.LEAVE:

                parkingService.leave(Integer.parseInt(inputs[1]));
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
