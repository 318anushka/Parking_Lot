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

                break;

            case Constants.PARK:

                break;

            case Constants.LEAVE:

                break;

            case Constants.STATUS:

                break;

            case Constants.REG_NO_FOR_CARS_WITH_COLOR:

                break;


            case Constants.SLOTS_NUMBER_FOR_CARS_WITH_COLOR:

                break;

            case Constants.SLOTS_NUMBER_FOR_REG_NUMBER:

                break;
        }


    }


}
