package Lambda_function;

import java.util.*;

class Patient {
    private int id;
    private String name;

    public Patient(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }
}

public class HospitalPatientIDPrinting {
    public static void main(String[] args) {

        // 🧾 Patient List
        List<Patient> patients = Arrays.asList(
            new Patient(101, "Riya Sharma"),
            new Patient(102, "Aman Gupta"),
            new Patient(103, "Neha Verma"),
            new Patient(104, "Rohit Singh")
        );

        System.out.println("🏥 All Patient IDs:");

        // 🔹 Using Method Reference instead of Lambda
        patients.stream()
                .map(Patient::getId)        // instead of p -> p.getId()
                .forEach(System.out::println); // instead of id -> System.out.println(id)
    }
}
