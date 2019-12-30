package main.io.java.gojek.parkinglot1.service.implement;

import main.io.java.gojek.parkinglot1.dao.ParkingDataManager;
import main.io.java.gojek.parkinglot1.dao.implement.ParkingMemoryManager;
import main.io.java.gojek.parkinglot1.exception.ParkingException;
import main.io.java.gojek.parkinglot1.model.Vehicle;
import main.io.java.gojek.parkinglot1.model.planning.NearestParkingPlanning;
import main.io.java.gojek.parkinglot1.model.planning.ParkingPlanning;
import main.io.java.gojek.parkinglot1.processor.Execution;
import main.io.java.gojek.parkinglot1.service.ParkingService;
import main.io.java.gojek.parkinglot1.exception.Error;


import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

public class ServiceImplt implements ParkingService {

    private ParkingDataManager<Vehicle> dataManager = null;

    @Override
    public void createParkingLot(int capacity) throws ParkingException{

        if(dataManager !=null){
            //System.out.println("Parking Lot already exists");
            throw new ParkingException(Error.PARKING_ALREADY_EXISTS.getMessage());
        }

        ParkingPlanning parkingPlanning = new NearestParkingPlanning();
        this.dataManager = ParkingMemoryManager.getInstance(capacity , parkingPlanning);
        System.out.println("New parking lot created of capacity"+" "+capacity);

    }

    @Override
    public Optional<Integer> park(Vehicle vehicle) throws ParkingException{

        Optional<Integer> parkedAt = Optional.empty();
        try{
            parkedAt = Optional.of(dataManager.parkCar(vehicle));
            if(parkedAt.get() == -1){
                System.out.println("Parking Lot is Full");
            }
            else if(parkedAt.get() == -2){
                System.out.println("Vehicle already exists");
            }
            else{
                System.out.println("Allocated slot is"+" "+parkedAt.get());
            }
        }
        catch(Exception e){

            //System.out.println("Parking lot doesn't exist");
            throw new ParkingException(Error.EXECUTION_ERROR.getMessage(),e);

        }



        return parkedAt;
    }

    @Override
    public void leave(int slot) throws ParkingException {

        try {
            if (dataManager.leave(slot)) {
                System.out.println("Slot" + " " + slot + " " + "is empty");
            }
            else {
                System.out.println("Slot already empty");

            }
        }
        catch(Exception e){
            System.out.println("Invalid value input");
            throw new ParkingException(Error.INVALID_VALUE.getMessage(),e);
        }


    }

    @Override
    public void getStatus() throws ParkingException{

        try {

            List<String> list = dataManager.getStatus();
            if(list.size()==0){
                System.out.println("Parking lot is empty");
            }
            else {
                for (String l : list) {
                    System.out.println(l);
                }
            }
        }
        catch(Exception e){
            System.out.println("Execution error!");
            throw new ParkingException(Error.EXECUTION_ERROR.getMessage(),e);
        }

    }

    @Override
    public void getRegistrationNoFromColor(String color) throws ParkingException {

        try {
            List<String> list = dataManager.getRegistrationNoFromColor(color);
            if(list.size()==0){
                System.out.println("No car of given color");
            }
            else {
                for (String l : list) {
                    System.out.print(l + "," + " ");
                }
            }
        }
        catch(Exception e){
            //System.out.println("Execution error");
            throw new ParkingException(Error.EXECUTION_ERROR.getMessage(),e);
        }

    }

    @Override
    public void getSlotNoFromColor(String color) throws ParkingException{

        try {
            List<Integer> list = dataManager.getSlotNoFromColor(color);
            if(list.size()==0){
                System.out.println("No car of given color");
            }
            else {
                for (int l : list) {
                    System.out.print(l + "," + " ");
                }
            }
        }
        catch(Exception e){
            //System.out.println("Execution error");
            throw new ParkingException(Error.EXECUTION_ERROR.getMessage(),e);
        }

    }

    @Override
    public void getSlotNoFromRegistrationNo(String registrationNo) throws ParkingException{

        try {
            int num = dataManager.getSlotNoFromRegistrationNo(registrationNo);
            if (num == 0) {
                System.out.println("Vehicle not parked");
            } else {
                System.out.println(num);
            }
        }
        catch(Exception e){
            //System.out.println("Execution error");
            throw new ParkingException(Error.EXECUTION_ERROR.getMessage(),e);
        }

    }
}
