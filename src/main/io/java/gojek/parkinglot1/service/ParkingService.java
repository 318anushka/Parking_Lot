package main.io.java.gojek.parkinglot1.service;

import main.io.java.gojek.parkinglot1.exception.ParkingException;
import main.io.java.gojek.parkinglot1.model.Vehicle;

import java.util.Optional;

public interface ParkingService extends AbstractService{

    public void createParkingLot(int capacity) throws ParkingException;
    public Optional<Integer> park(Vehicle vehicle) throws ParkingException;
    public void leave (int slot) throws ParkingException;
    public void getStatus() throws ParkingException;
    public void getRegistrationNoFromColor(String color) throws ParkingException;
    public void getSlotNoFromColor(String color) throws ParkingException;
    public void getSlotNoFromRegistrationNo(String registrationNo) throws ParkingException;


}
