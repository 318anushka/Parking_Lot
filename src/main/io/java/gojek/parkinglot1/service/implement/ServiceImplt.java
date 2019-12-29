package main.io.java.gojek.parkinglot1.service.implement;

import main.io.java.gojek.parkinglot1.dao.ParkingDataManager;
import main.io.java.gojek.parkinglot1.dao.implement.ParkingMemoryManager;
import main.io.java.gojek.parkinglot1.model.Vehicle;
import main.io.java.gojek.parkinglot1.model.planning.NearestParkingPlanning;
import main.io.java.gojek.parkinglot1.model.planning.ParkingPlanning;
import main.io.java.gojek.parkinglot1.service.ParkingService;

import java.util.Optional;

public class ServiceImplt implements ParkingService {

    private ParkingDataManager<Vehicle> dataManager = null;

    @Override
    public void createParkingLot(int capacity) {

        ParkingPlanning parkingPlanning = new NearestParkingPlanning();
        this.dataManager = ParkingMemoryManager.getInstance(capacity , parkingPlanning);
        System.out.println("New parking lot creatred of capacity"+" "+capacity);

    }

    @Override
    public Optional<Integer> park(Vehicle vehicle) {

        Optional<Integer> parkedAt = Optional.empty();
        parkedAt = Optional.of(dataManager.parkCar(vehicle));
        System.out.println("Allocated slot is"+" "+parkedAt);
        return parkedAt;
    }

    @Override
    public void leave(int slot) {

        if(dataManager.leave(slot)){
            System.out.println("Slot"+" "+slot+" "+"is empty");
        }
        else{
            System.out.println("Slot already empty");

        }


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
