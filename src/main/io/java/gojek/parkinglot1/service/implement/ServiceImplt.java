package main.io.java.gojek.parkinglot1.service.implement;

import main.io.java.gojek.parkinglot1.dao.ParkingDataManager;
import main.io.java.gojek.parkinglot1.dao.implement.ParkingMemoryManager;
import main.io.java.gojek.parkinglot1.model.Vehicle;
import main.io.java.gojek.parkinglot1.model.planning.NearestParkingPlanning;
import main.io.java.gojek.parkinglot1.model.planning.ParkingPlanning;
import main.io.java.gojek.parkinglot1.service.ParkingService;

import java.util.List;
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
    public void getStatus() {

        List<String> list = dataManager.getStatus();
        for(String l: list){
            System.out.println(l);
        }

    }

    @Override
    public void getRegistrationNoFromColor(String color) {

        List<String> list = dataManager.getRegistrationNoFromColor(color);
        for(String l: list){
            System.out.print(l+","+" ");
        }

    }

    @Override
    public void getSlotNoFromColor(String color) {

        List<Integer> list = dataManager.getSlotNoFromColor(color);
        for(int l: list){
            System.out.print(l+","+" ");
        }

    }

    @Override
    public void getSlotNoFromRegistrationNo(String registrationNo) {

        int num = dataManager.getSlotNoFromRegistrationNo(registrationNo);
        if(num==0){
            System.out.println("Vehicle not parked");
        }
        else{
            System.out.println(num);
        }

    }
}
