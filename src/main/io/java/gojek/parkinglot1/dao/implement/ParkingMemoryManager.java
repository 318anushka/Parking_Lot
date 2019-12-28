package main.io.java.gojek.parkinglot1.dao.implement;

import main.io.java.gojek.parkinglot1.dao.ParkingDataManager;
import main.io.java.gojek.parkinglot1.model.Vehicle;
import main.io.java.gojek.parkinglot1.model.planning.ParkingPlanning;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ParkingMemoryManager implements ParkingDataManager {

    // initial capacity of lot
    private int capacity = 0;
    // total available slots in lot
    private int availability = 0;
    // instance of ParkingPlanning
    private ParkingPlanning parkingPlanning;

    private Map<Integer, Vehicle> slotMap;

    public ParkingMemoryManager(int capacity , ParkingPlanning parkingPlanning){
        this.capacity = capacity;
        this.availability = capacity;
        this.parkingPlanning = parkingPlanning;
        slotMap = new ConcurrentHashMap<>();

        for(int i=1;i<=capacity;i++){
            slotMap.put(i,null);
            parkingPlanning.addSlot(i);
        }
    }

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
