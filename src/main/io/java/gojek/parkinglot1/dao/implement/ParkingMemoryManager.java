package main.io.java.gojek.parkinglot1.dao.implement;

import main.io.java.gojek.parkinglot1.dao.ParkingDataManager;
import main.io.java.gojek.parkinglot1.model.Vehicle;
import main.io.java.gojek.parkinglot1.model.planning.NearestParkingPlanning;
import main.io.java.gojek.parkinglot1.model.planning.ParkingPlanning;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class ParkingMemoryManager<T extends Vehicle> implements ParkingDataManager<T> {

    // initial capacity of lot
    private int capacity = 0;
    // total available slots in lot
    private int availability = 0;
    // instance of ParkingPlanning
    private ParkingPlanning parkingPlanning;

    private Map<Integer, Optional<T>> slotMap;

    private static ParkingMemoryManager instance = null;

    public static <T extends Vehicle> ParkingMemoryManager<T> getInstance(int capacity,
                                                                          ParkingPlanning parkingPlanning)
    {
        if (instance == null)
        {
            synchronized (ParkingMemoryManager.class)
            {
                if (instance == null)
                {
                    instance = new ParkingMemoryManager<T>(capacity, parkingPlanning);
                }
            }
        }
        return instance;
    }

    public ParkingMemoryManager(int capacity , ParkingPlanning parkingPlanning){
        this.capacity = capacity;
        this.availability = capacity;
        this.parkingPlanning = parkingPlanning;

        if(parkingPlanning == null){
            parkingPlanning = new NearestParkingPlanning();
        }
        slotMap = new ConcurrentHashMap<>();

        for(int i=1;i<=capacity;i++){
            slotMap.put(i,Optional.empty());
            parkingPlanning.addSlot(i);
        }
    }


    @Override
    public int parkCar(T vehicle) {
        int availableSlot;
        if(availability == 0){
            System.out.println("Slot Not Available");
            return -1;
        }
        else {
            availableSlot = parkingPlanning.getSlots();

            if (slotMap.containsValue(Optional.of(vehicle))) {
                System.out.println("Vehicle Already Exists");
                return -2;
            }
            slotMap.put(availableSlot, Optional.of(vehicle));
            availability--;
            parkingPlanning.removeSlot(availableSlot);

        }

            return availableSlot;

    }

    @Override
    public boolean leave(int slot) {

        // slot already empty
        if(!slotMap.get(slot).isPresent()){
            return false;
        }

        //System.out.println("code running till here");
        availability++;
        parkingPlanning.addSlot(slot);
        slotMap.put(slot , Optional.empty());
        return true;

    }

    @Override
    public List<String> getStatus() {

        List<String> statusList = new ArrayList<>();
        for(int i=1;i<=capacity;i++){
            Optional<T> v = slotMap.get(i);
            if(v.isPresent()){
                statusList.add(i + "\t\t" + v.get().getRegistrationNo() + "\t\t" + v.get().getColor());
            }
        }

        return statusList;
    }

    @Override
    public List<String> getRegistrationNoFromColor(String color) {

        List<String> regList = new ArrayList<>();
        for(int i=1;i<=capacity;i++){
            Optional<T> vehicle = slotMap.get(i);
            if(vehicle.isPresent() && color.equalsIgnoreCase(vehicle.get().getColor())){

                regList.add(vehicle.get().getRegistrationNo());
            }
        }

        return regList;
    }

    @Override
    public List<Integer> getSlotNoFromColor(String color) {

        List<Integer> slotList = new ArrayList<>();
        for(int i=1;i<=capacity;i++){
            Optional<T> vehicle = slotMap.get(i);
            if((vehicle.isPresent()) && color.equalsIgnoreCase(vehicle.get().getColor())){

                slotList.add(i);
            }
        }

        return slotList;
    }

    @Override
    public int getSlotNoFromRegistrationNo(String registrationNo) {

        int slot = 0;
        for(int i=1;i<=capacity;i++){
            Optional<T> vehicle = slotMap.get(i);
            if((vehicle.isPresent()) && registrationNo.equalsIgnoreCase(vehicle.get().getRegistrationNo())){

                slot = i;
            }
        }

        return slot;
    }
}
