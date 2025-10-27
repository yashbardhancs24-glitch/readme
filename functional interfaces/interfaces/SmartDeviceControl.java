
interface SmartDevice {
    void turnOn();
    void turnOff();
}
class Light implements SmartDevice {
    String a;
    public void turnOn(){System.out.println(a+" Light On");}
    public void turnOff(){System.out.println(a+" Light Off");}
}
class AC implements SmartDevice {
    String b;
    public void turnOn(){System.out.println(b+" AC On");}
    public void turnOff(){System.out.println(b+" AC Off");}
}
class TV implements SmartDevice {
    String c;
    public void turnOn(){System.out.println(c+" TV On");}
    public void turnOff(){System.out.println(c+" TV Off");}
}
