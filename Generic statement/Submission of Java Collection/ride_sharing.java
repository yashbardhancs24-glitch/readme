package Collections;
import java.util.*;

//Driver class
class Driver {
 String name;
 double location; // Simulate location as a number

 public Driver(String name, double location) {
     this.name = name;
     this.location = location;
 }

 @Override
 public boolean equals(Object o) {
     if (this == o) return true;
     if (o == null || getClass() != o.getClass()) return false;
     Driver driver = (Driver) o;
     return Objects.equals(name, driver.name);
 }

 @Override
 public int hashCode() {
     return Objects.hash(name);
 }

 @Override
 public String toString() {
     return name + " (loc: " + location + ")";
 }
}

//RideRequest class
class RideRequest {
 String passenger;
 double pickupLocation;
 int urgency; // Lower number = higher urgency

 public RideRequest(String passenger, double pickupLocation, int urgency) {
     this.passenger = passenger;
     this.pickupLocation = pickupLocation;
     this.urgency = urgency;
 }

 @Override
 public String toString() {
     return passenger + " (pickup: " + pickupLocation + ", urgency: " + urgency + ")";
 }
}

//Ride class
class Ride {
 RideRequest request;
 Driver driver;

 public Ride(RideRequest request, Driver driver) {
     this.request = request;
     this.driver = driver;
 }

 @Override
 public String toString() {
     return request.passenger + " picked up by " + driver.name;
 }
}

//DispatchSystem class
public class ride_sharing {
 private Queue<RideRequest> pendingRequests = new LinkedList<>();
 private Set<Driver> availableDrivers = new HashSet<>();
 private List<Ride> completedRides = new ArrayList<>();
 private PriorityQueue<RideRequest> urgentRequests = new PriorityQueue<>((r1, r2) -> Integer.compare(r1.urgency, r2.urgency));

 // Add a new ride request
 public void addRequest(String passenger, double pickupLocation, int urgency) {
     RideRequest request = new RideRequest(passenger, pickupLocation, urgency);
     pendingRequests.add(request);
     urgentRequests.add(request);
     System.out.println("Request added: " + request);
 }

 // Register a driver
 public void registerDriver(String name, double location) {
     Driver driver = new Driver(name, location);
     if (availableDrivers.add(driver)) {
         System.out.println("Driver registered: " + driver);
     } else {
         System.out.println("Driver " + name + " already exists.");
     }
 }

 // Assign the next urgent ride
 public void assignNextRide() {
     if (urgentRequests.isEmpty() || availableDrivers.isEmpty()) {
         System.out.println("No urgent requests or no available drivers.");
         return;
     }
     RideRequest request = urgentRequests.poll();
     pendingRequests.remove(request);
     Driver driver = availableDrivers.iterator().next(); // Assign to first available driver
     Ride ride = new Ride(request, driver);
     completedRides.add(ride);
     System.out.println("Assigned: " + ride);
 }

 // Display completed rides
 public void displayCompletedRides() {
     System.out.println("Completed Rides:");
     for (Ride ride : completedRides) {
         System.out.println(ride);
     }
 }

 // Example usage
 public static void main(String[] args) {
	 ride_sharing system = new ride_sharing();
     system.registerDriver("Alice", 10.0);
     system.registerDriver("Bob", 15.0);
     system.registerDriver("Alice", 10.0); // Duplicate

     system.addRequest("John", 12.0, 2);
     system.addRequest("Jane", 8.0, 1);
     system.addRequest("Mike", 14.0, 3);

     system.assignNextRide();
     system.assignNextRide();
     system.assignNextRide();

     system.displayCompletedRides();
 }
}


