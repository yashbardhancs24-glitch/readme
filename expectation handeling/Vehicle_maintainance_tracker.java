package Exception;
import java.time.LocalDate;

//Custom exception for overdue service
class ServiceOverdueException extends Exception {
 public ServiceOverdueException(String message) {
     super(message);
 }
}

//Custom exception for invalid mileage
class InvalidMileageException extends Exception {
 public InvalidMileageException(String message) {
     super(message);
 }
}

//Vehicle maintenance class
class VehicleMaintenance {
 private LocalDate serviceDate;
 private int mileage;

 public VehicleMaintenance(LocalDate serviceDate, int mileage) {
     this.serviceDate = serviceDate;
     this.mileage = mileage;
 }

 // Method to check maintenance
 public void checkMaintenance() throws ServiceOverdueException, InvalidMileageException {
     LocalDate today = LocalDate.now();

     if (serviceDate.isBefore(today)) {
         throw new ServiceOverdueException("Service is overdue! Please schedule maintenance.");
     }

     if (mileage < 0) {
         throw new InvalidMileageException("Invalid mileage reading. Mileage cannot be negative.");
     }

     System.out.println("Vehicle maintenance is up to date.");
 }
}

//Main class
public class Vehicle_maintainance_tracker {
 public static void main(String[] args) {
     // Example with overdue service and valid mileage
     VehicleMaintenance vehicle = new VehicleMaintenance(LocalDate.of(2025, 10, 1), 15000);

     try {
         vehicle.checkMaintenance();
     } catch (ServiceOverdueException | InvalidMileageException e) {
         System.out.println("Alert: " + e.getMessage());
     }
 }
}


