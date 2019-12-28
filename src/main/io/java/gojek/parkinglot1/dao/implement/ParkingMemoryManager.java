package main.io.java.gojek.parkinglot1.dao.implement;

import main.io.java.gojek.parkinglot1.dao.ParkingDataManager;

import java.util.List;

public class ParkingMemoryManager implements ParkingDataManager {
    @Override
    public int parkCar() {
        return 0;
    }

    @Override
    public void leave(int slot) {

    }

    @Override
    public List<String> getStatus() {
        return null;
    }

    @Override
    public List<String> getRegistrationNoFromColor(String color) {
        return null;
    }

    @Override
    public List<String> getSlotNoFromColor(String color) {
        return null;
    }

    @Override
    public int getSlotNoFromRegistrationNo(String registrationNo) {
        return 0;
    }
}
