package main.io.java.gojek.parkinglot1.dao;

import main.io.java.gojek.parkinglot1.model.Vehicle;

import java.util.List;

public interface ParkingDataManager<T extends Vehicle> {

    public int parkCar(T Vehicle );

    public boolean leave(int slot);

    public List<String> getStatus();

    public List<String> getRegistrationNoFromColor(String color);

    public List<Integer> getSlotNoFromColor(String color);

    public int getSlotNoFromRegistrationNo(String registrationNo);


}
