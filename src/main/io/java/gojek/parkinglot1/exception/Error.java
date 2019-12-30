package main.io.java.gojek.parkinglot1.exception;

public enum Error {

    PARKING_ALREADY_EXISTS("Parking lot already created"),
    PARKING_DO_NOT_EXIST("Parking does not exist"),
    INVALID_VALUE("input value is incorrect"),
    EXECUTION_ERROR("Execution error");

    private String message = "";

    private Error(String s) {
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

}
