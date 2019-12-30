package main.io.java.gojek.parkinglot1.exception;


import java.util.Objects;

public class ParkingException extends Exception {

    private static final long serialVersionUID = 4980196508277280342L;

    private String		errorCode		= null;	// this will hold system defined error code
    private Object[]	errorParameters	= null;	// this will hold parameters for error code/message

    public ParkingException (String message) {

        super(message);
    }

    public ParkingException (String message , Throwable throwable){

        super(message,throwable);
    }

    public ParkingException (Throwable throwable){

        super(throwable);
    }

    public ParkingException(String errorCode , String message , Objects[] errorParameters){

        super(message);
        this.errorCode = errorCode;
        this.errorParameters = errorParameters;
    }

    public ParkingException(String message , String errorCode , Throwable throwable){

        super(message,throwable);
        this.errorCode = errorCode;
    }

    public ParkingException(String message,String errorCode , Objects[] errorParameters , Throwable throwable){

        super(message,throwable);
        this.errorCode = errorCode;
        this.errorParameters = errorParameters;
    }

}
