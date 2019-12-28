package main.io.java.gojek.parkinglot1.dao.implement;

import main.io.java.gojek.parkinglot1.dao.ParkingDataManager;
import main.io.java.gojek.parkinglot1.model.Vehicle;
import main.io.java.gojek.parkinglot1.model.planning.ParkingPlanning;

import java.util.ArrayList;
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
    public int parkCar(Vehicle v) {
        if(availability == 0){
            System.out.println("Slot Not Available");
            return -1;
        }
        else {
            int availableSlot = parkingPlanning.getSlots();

            slotMap.put(availableSlot, v);
            availability--;
            parkingPlanning.removeSlot(availableSlot);

            return availableSlot;
        }
    }

    @Override
    public boolean leave(int slot) {

        if(slotMap.get(slot) == null){
            return false;
        }
        slotMap.put(slot , null);
        availability++;
        parkingPlanning.addSlot(slot);
        return true;

    }

    @Override
    public List<String> getStatus() {

        List<String> statusList = new ArrayList<>();
        for(int i=1;i<=capacity;i++){
            Vehicle v = slotMap.get(i);
            if(v!=null){
                statusList.add(i + "\t\t" + v.getRegistrationNo() + "\t\t" + v.getColor());
            }
        }

        return statusList;
    }

    @Override
    public List<String> getRegistrationNoFromColor(String color) {

        List<String> regList = new ArrayList<>();
        for(int i=1;i<=capacity;i++){
            Vehicle v = slotMap.get(i);
            if((v!=null) && color.equalsIgnoreCase(v.getColor())){

                regList.add(v.getRegistrationNo());
            }
        }

        return regList;
    }

    @Override
    public List<Integer> getSlotNoFromColor(String color) {

        List<Integer> slotList = new ArrayList<>();
        for(int i=1;i<=capacity;i++){
            Vehicle v = slotMap.get(i);
            if((v!=null) && color.equalsIgnoreCase(v.getColor())){

                slotList.add(i);
            }
        }

        return slotList;
    }

    @Override
    public int getSlotNoFromRegistrationNo(String registrationNo) {

        int slot = 0;
        for(int i=1;i<=capacity;i++){
            Vehicle v = slotMap.get(i);
            if((v!=null) && registrationNo.equalsIgnoreCase(v.getRegistrationNo())){

                slot = i;
            }
        }

        return slot;
    }
}
