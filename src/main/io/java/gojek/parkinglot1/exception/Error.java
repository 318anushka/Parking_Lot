package main.io.java.gojek.parkinglot1.exception;

public enum Error {

    PARKING_ALREADY_EXISTS("Parking lot already created"),
    PARKING_DO_NOT_EXIST("Parking does not exist"),
    INVALID_VALUE("input value is incorrect"),
    EXECUTION_ERROE("Execution error"),

    ;

    private String s = "";

    private Error(String s) {
        this.s = s;
    }

    public String getMessage(){
        return s;
    }

}
