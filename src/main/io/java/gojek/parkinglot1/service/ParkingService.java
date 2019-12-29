package main.io.java.gojek.parkinglot1.service;

import main.io.java.gojek.parkinglot1.model.Vehicle;

import java.util.Optional;

public interface ParkingService extends AbstractService{

    public void createParkingLot(int capacity) throws Exception;
    public Optional<Integer> park(Vehicle vehicle) throws Exception;
    public void leave (int slot) throws Exception;
    public void getStatus() throws Exception;
    public void getRegistrationNoFromColor(String color) throws Exception;
    public void getSlotNoFromColor(String color) throws Exception;
    public void getSlotNoFromRegistrationNo(String color) throws Exception;


}
