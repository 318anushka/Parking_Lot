package main.io.java.gojek.parkinglot1.exception;

import main.io.java.gojek.parkinglot1.service.ParkingService;

public class ParkingException extends Exception {

    public ParkingException (String message) {

        super(message);
    }

    public ParkingException (String message , Throwable throwable){

        super(message,throwable);
    }

    public ParkingException (Throwable throwable){

        super(throwable);
    }

}
