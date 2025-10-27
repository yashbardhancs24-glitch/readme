
interface VehicleDashboard {
    void displaySpeed();
    default void displayBattery(){System.out.println("Battery: 100%");}
}
class CarDash implements VehicleDashboard {
    public void displaySpeed(){System.out.println("Speed 80");}
}
class ElectricCarDash implements VehicleDashboard {
    public void displaySpeed(){System.out.println("Speed 80");}
}
