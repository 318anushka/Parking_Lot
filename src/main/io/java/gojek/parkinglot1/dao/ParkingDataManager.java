package main.io.java.gojek.parkinglot1.dao;

import java.util.List;

public interface ParkingDataManager {

    public int parkCar();
    public void leave(int slot);
    public List<String> getStatus();
    public List<String> getRegistrationNoFromColor(String color);
    public List<String> getSlotNoFromColor(String color);
    public int getSlotNoFromRegistrationNo(String registrationNo);


}
