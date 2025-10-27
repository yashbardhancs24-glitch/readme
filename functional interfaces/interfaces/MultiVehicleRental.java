
interface Vehicle {
    void rent();
    void returnVehicle();
}
class Car implements Vehicle {
    String a;
    public void rent(){System.out.println(a+" Car Rented");}
    public void returnVehicle(){System.out.println(a+" Car Returned");}
}
class Bike implements Vehicle {
    String b;
    public void rent(){System.out.println(b+" Bike Rented");}
    public void returnVehicle(){System.out.println(b+" Bike Returned");}
}
class Bus implements Vehicle {
    String c;
    public void rent(){System.out.println(c+" Bus Rented");}
    public void returnVehicle(){System.out.println(c+" Bus Returned");}
}
