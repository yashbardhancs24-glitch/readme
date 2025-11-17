package Collections;
import java.util.*;

class Patient {
    String id;
    String name;

    Patient(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient)) return false;
        Patient p = (Patient) o;
        return id.equals(p.id);
    }

    public int hashCode() {
        return id.hashCode();
    }

    public String toString() {
        return id + ": " + name;
    }
}

public class HospitalPatientManagementSystem {
    Set<Patient> admittedPatients = new HashSet<>();
    Queue<Patient> waitingQueue = new LinkedList<>();
    Stack<Patient> dischargedStack = new Stack<>();
    List<Patient> patientHistory = new ArrayList<>();

    public void admitPatient(Patient p) {
        if (admittedPatients.add(p)) {
            waitingQueue.add(p);
            patientHistory.add(p);
        }
    }

    public Patient treatNextPatient() {
        Patient p = waitingQueue.poll();
        return p;
    }

    public void dischargePatient(Patient p) {
        if (admittedPatients.remove(p)) {
            dischargedStack.push(p);
        }
    }

    public void readmitPatient() {
        if (!dischargedStack.isEmpty()) {
            Patient p = dischargedStack.pop();
            admitPatient(p);
        }
    }

    public static void main(String[] args) {
    	HospitalPatientManagementSystem system = new HospitalPatientManagementSystem();

        Patient p1 = new Patient("P001", "Alice");
        Patient p2 = new Patient("P002", "Bob");
        Patient p3 = new Patient("P003", "Charlie");

        system.admitPatient(p1);
        system.admitPatient(p2);
        system.admitPatient(p3);

        Patient toTreat = system.treatNextPatient();

        system.dischargePatient(toTreat);

        system.readmitPatient();

        System.out.println("Admitted Patients:");
        for (Patient p : system.admittedPatients) {
            System.out.println(p);
        }

        System.out.println("Patient History:");
        for (Patient p : system.patientHistory) {
            System.out.println(p);
        }
    }
}


