package map_interface;

import java.util.*;

public class AttendanceTracker {
    public static void main(String[] args) {

        Map<String, Integer> attendance = new HashMap<>();
        List<String> students = Arrays.asList(
            "Alice", "Bob", "Charlie", "David", "Eva"
        );

        for (String s : students) {
            attendance.put(s, 0);
        }

        List<List<String>> monthAttendance = Arrays.asList(
            Arrays.asList("Alice", "Bob"),
            Arrays.asList("Alice", "Charlie", "Eva"),
            Arrays.asList("Bob", "David"),
            Arrays.asList("Alice", "Eva"),
            Arrays.asList("Charlie", "David"),
            Arrays.asList("Alice", "Bob", "Charlie"),
            Arrays.asList("Eva"),
            Arrays.asList("Bob", "David"),
            Arrays.asList("Alice", "Charlie", "Eva"),
            Arrays.asList("Bob"),
            Arrays.asList("Charlie", "David"),
            Arrays.asList("Alice"),
            Arrays.asList("Eva", "David"),
            Arrays.asList("Bob", "Charlie"),
            Arrays.asList("Alice", "Eva")
        );

        for (List<String> presentList : monthAttendance) {
            for (String name : presentList) {
                attendance.put(name, attendance.get(name) + 1);
            }
        }

        int threshold = 10;
        System.out.println("Students with attendance fewer than " + threshold + " days:");

        for (Map.Entry<String, Integer> entry : attendance.entrySet()) {
            if (entry.getValue() < threshold) {
                System.out.println(entry.getKey() + " → " + entry.getValue() + " days");
            }
        }

        System.out.println("\nFull Attendance Report:");
        for (Map.Entry<String, Integer> entry : attendance.entrySet()) {
            System.out.println(entry.getKey() + " → " + entry.getValue());
        }
    }
}
