package map_interface;

import java.util.*;

public class StudentGradeTracker {
    public static void main(String[] args) {

        Map<String, Double> grades = new HashMap<>();

        // 1. Add students
        grades.put("Alice", 85.5);
        grades.put("Bob", 92.0);
        grades.put("Charlie", 78.0);
        grades.put("David", 88.5);
        grades.put("Charlie", 82.0);
        grades.remove("David");

        System.out.println("Students and Grades (sorted):");

        Map<String, Double> sorted = new TreeMap<>(grades);

        for (Map.Entry<String, Double> entry : sorted.entrySet()) {
            System.out.println(entry.getKey() + " → " + entry.getValue());
        }
    }
}
