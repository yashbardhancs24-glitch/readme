package Collections;
import java.util.*;

class Package {
    String packageId;
    String description;

    Package(String packageId, String description) {
        this.packageId = packageId;
        this.description = description;
    }

    public String toString() {
        return packageId + ": " + description;
    }
}

public class Warehouse_Delivery_Tracking {
    Queue<Package> pendingDeliveries = new LinkedList<>();
    Set<String> packageIds = new HashSet<>();
    List<Package> deliveredPackages = new ArrayList<>();
    Stack<Package> returnedPackages = new Stack<>();

    public boolean addDeliveryRequest(Package p) {
        if (packageIds.contains(p.packageId)) {
            return false;
        }
        packageIds.add(p.packageId);
        pendingDeliveries.add(p);
        return true;
    }

    public void processNextDelivery(boolean isDelivered) {
        if (!pendingDeliveries.isEmpty()) {
            Package p = pendingDeliveries.poll();
            if (isDelivered) {
                deliveredPackages.add(p);
            } else {
                returnedPackages.push(p);
            }
        }
    }

    public void displaySummary() {
        System.out.println("Delivered Packages:");
        for (Package p : deliveredPackages) {
            System.out.println(p);
        }
        System.out.println("Returned/Cancelled Packages:");
        for (Package p : returnedPackages) {
            System.out.println(p);
        }
        System.out.println("Pending Deliveries:");
        for (Package p : pendingDeliveries) {
            System.out.println(p);
        }
    }

    public static void main(String[] args) {
    	Warehouse_Delivery_Tracking system = new Warehouse_Delivery_Tracking();

        system.addDeliveryRequest(new Package("PKG1", "Books"));
        system.addDeliveryRequest(new Package("PKG2", "Electronics"));
        system.addDeliveryRequest(new Package("PKG3", "Clothes"));

        system.processNextDelivery(true);
        system.processNextDelivery(false);
        system.processNextDelivery(true);

        system.displaySummary();
    }
}


