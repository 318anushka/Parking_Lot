package main.io.java.gojek.parkinglot1.service;

import main.io.java.gojek.parkinglot1.model.Vehicle;

import java.util.Optional;

public interface ParkingService extends AbstractService{

    public void createParkingLot(int capacity);
    public Optional<Integer> park(int capacity , Vehicle vehicle);
    public void leave (int slot);
    public void getStaus();
    public void getRegistrationNoFromColor(String color);
    public void getSlotNoFromColor(String color);
    public void getSlotNoFromRegistrationNo(String color);


}
