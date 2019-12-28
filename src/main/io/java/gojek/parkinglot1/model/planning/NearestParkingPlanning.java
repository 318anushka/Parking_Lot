package main.io.java.gojek.parkinglot1.model.planning;


//import java.util.HashSet;
import java.util.TreeSet;

public class NearestParkingPlanning implements ParkingPlanning{

    public TreeSet<Integer> freeSlots  = new TreeSet<Integer>();

    @Override
    // add free slots to set
    public void addSlot(int i) {

        freeSlots.add(i);

    }

    @Override
    // get least free slot
    public int getSlots() {
        return freeSlots.first();
    }

    @Override
    // remove slot from set once occupied
    public void removeSlot(int slot) {

        freeSlots.remove(slot);
    }
}
