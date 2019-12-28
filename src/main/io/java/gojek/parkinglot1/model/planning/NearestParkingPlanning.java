package main.io.java.gojek.parkinglot1.model.planning;


import java.util.HashSet;

public class NearestParkingPlanning implements ParkingPlanning{

    public HashSet<Integer> freeSlots  = new HashSet<Integer>();

    @Override
    // add free slots to set
    public void addSlot(int i) {

        freeSlots.add(i);

    }

    @Override
    // get least free slot
    public int getSlots() {
        return 0;
    }

    @Override
    // remove slot from set once occupied
    public void removeSlot(int slot) {

        freeSlots.remove(slot);
    }
}
