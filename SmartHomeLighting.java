package Lambda_function;

public class SmartHomeLighting {
    public static void main(String[] args) {
        SmartLight light = new SmartLight();

        LightBehavior motionTrigger = () -> System.out.println("Motion detected: Turning ON the lights 💡");

        LightBehavior nightTrigger = () -> System.out.println("Night mode: Dimming lights 🌙");

        LightBehavior voiceTrigger = () -> System.out.println("Voice command 'Party Mode': Activating colorful lights 🎉");

        light.setBehavior(motionTrigger);
        light.trigger();

        light.setBehavior(nightTrigger);
        light.trigger();

        light.setBehavior(voiceTrigger);
        light.trigger();
    }
}
