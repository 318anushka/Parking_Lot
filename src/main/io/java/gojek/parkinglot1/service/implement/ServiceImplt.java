package main.io.java.gojek.parkinglot1.service.implement;

import main.io.java.gojek.parkinglot1.model.Vehicle;
import main.io.java.gojek.parkinglot1.service.ParkingService;

import java.util.Optional;

public class ServiceImplt implements ParkingService {
    @Override
    public void createParkingLot(int capacity) {

    }

    @Override
    public Optional<Integer> park(int capacity, Vehicle vehicle) {
        return Optional.empty();
    }

    @Override
    public void leave(int slot) {

    }

    @Override
    public void getStaus() {

    }

    @Override
    public void getRegistrationNoFromColor(String color) {

    }

    @Override
    public void getSlotNoFromColor(String color) {

    }

    @Override
    public void getSlotNoFromRegistrationNo(String color) {

    }
}
