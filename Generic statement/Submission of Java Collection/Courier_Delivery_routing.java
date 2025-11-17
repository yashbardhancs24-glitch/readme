package Collections;
import java.util.*;

class Parcel implements Comparable<Parcel> {
    String deliveryId;
    String address;
    int priority;

    Parcel(String deliveryId, String address, int priority) {
        this.deliveryId = deliveryId;
        this.address = address;
        this.priority = priority;
    }

    public int compareTo(Parcel other) {
        return Integer.compare(other.priority, this.priority);
    }

    public String toString() {
        return deliveryId + " to " + address + " (Priority: " + priority + ")";
    }
}

public class Courier_Delivery_routing {
    PriorityQueue<Parcel> priorityQueue = new PriorityQueue<>();
    Set<String> assignedDeliveryIds = new HashSet<>();
    List<Parcel> completedDeliveries = new ArrayList<>();
    Queue<Parcel> normalQueue = new LinkedList<>();

    public boolean addParcel(Parcel p) {
        if (assignedDeliveryIds.contains(p.deliveryId)) {
            return false;
        }
        assignedDeliveryIds.add(p.deliveryId);
        if (p.priority > 5) {
            priorityQueue.add(p);
        } else {
            normalQueue.add(p);
        }
        return true;
    }

    public Parcel assignNextDelivery() {
        if (!priorityQueue.isEmpty()) {
            return priorityQueue.poll();
        } else if (!normalQueue.isEmpty()) {
            return normalQueue.poll();
        }
        return null;
    }

    public void completeDelivery(Parcel p) {
        completedDeliveries.add(p);
    }

    public void displayCompleted() {
        System.out.println("Completed Deliveries:");
        for (Parcel p : completedDeliveries) {
            System.out.println(p);
        }
    }

    public static void main(String[] args) {
    	Courier_Delivery_routing system = new Courier_Delivery_routing();

        system.addParcel(new Parcel("D001", "123 Main St", 8));
        system.addParcel(new Parcel("D002", "456 Park Ave", 3));
        system.addParcel(new Parcel("D003", "789 Elm St", 6));

        Parcel assigned = system.assignNextDelivery();

        if (assigned != null) {
            system.completeDelivery(assigned);
        }

        assigned = system.assignNextDelivery();

        if (assigned != null) {
            system.completeDelivery(assigned);
        }

        system.displayCompleted();
    }
}

