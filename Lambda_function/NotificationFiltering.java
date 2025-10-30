package Lambda_function;

import java.util.*;
import java.util.function.Predicate;

class Alert {
    String type;
    String message;
    int priority;

    public Alert(String type, String message, int priority) {
        this.type = type;
        this.message = message;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "[" + type + "] " + message + " (Priority: " + priority + ")";
    }
}

public class NotificationFiltering {
    public static void main(String[] args) {

        // 🏥 Sample Alerts
        List<Alert> alerts = Arrays.asList(
            new Alert("Critical", "Patient heart rate abnormal!", 1),
            new Alert("Info", "Patient check-up completed.", 3),
            new Alert("Warning", "Low oxygen level detected.", 2),
            new Alert("Info", "Appointment confirmed.", 3),
            new Alert("Critical", "Emergency in ward 5!", 1)
        );

        // 🔹 User preferences — dynamically set using lambda

        // Show only Critical alerts
        Predicate<Alert> criticalOnly = alert -> alert.type.equals("Critical");

        // Show only high priority (1 or 2)
        Predicate<Alert> highPriority = alert -> alert.priority <= 2;

        // Show only informational alerts
        Predicate<Alert> infoOnly = alert -> alert.type.equals("Info");

        // 🔹 Filter and Display based on user choice
        System.out.println("All Alerts:");
        alerts.forEach(System.out::println);

        System.out.println("\n🔴 Showing Critical Alerts:");
        filterAndShow(alerts, criticalOnly);

        System.out.println("\n🟠 Showing High Priority Alerts (1 or 2):");
        filterAndShow(alerts, highPriority);

        System.out.println("\n🔵 Showing Info Alerts:");
        filterAndShow(alerts, infoOnly);
    }

    // 🔹 Helper method to apply predicate filter
    static void filterAndShow(List<Alert> alerts, Predicate<Alert> filter) {
        alerts.stream()
              .filter(filter)
              .forEach(System.out::println);
    }
}
