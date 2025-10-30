package Lambda_function;

//Functional Interface
@FunctionalInterface
interface LightBehavior {
 void activate();
}

//SmartLight class
class SmartLight {
 private LightBehavior behavior;

 public void setBehavior(LightBehavior behavior) {
     this.behavior = behavior;
 }

 public void trigger() {
     if (behavior != null) {
         behavior.activate();
     } else {
         System.out.println("⚠️ No behavior set!");
     }
 }
}

//Main Class
public class SmartHomeLightingAutomation {
 public static void main(String[] args) {

     SmartLight light = new SmartLight();

     // Motion detected → Turn ON lights
     LightBehavior motionTrigger = () -> {
         System.out.println("🚶 Motion detected: Turning ON the lights 💡");
     };

     // Night mode → Dim lights
     LightBehavior nightTrigger = () -> {
         System.out.println("🌙 Night mode: Dimming lights...");
     };

     // Voice command → Party mode
     LightBehavior voiceTrigger = () -> {
         System.out.println("🎤 Voice command 'Party Mode': Activating colorful lights 🎉");
     };

     // Trigger each behavior
     light.setBehavior(motionTrigger);
     light.trigger();

     light.setBehavior(nightTrigger);
     light.trigger();

     light.setBehavior(voiceTrigger);
     light.trigger();
 }
}
