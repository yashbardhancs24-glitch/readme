package Keywords;

public class Patient {
    private static String hospitalName;
    private static int totalPatients = 0;
    private final String patientID;
    private String name;
    private int age;
    private String ailment;

    public Patient(String name, int age, String ailment, String patientID) {
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        this.patientID = patientID;
        totalPatients++;
    }

    public static void setHospitalName(String name) { hospitalName = name; }
    public static int getTotalPatients() { return totalPatients; }

    public void displayPatientDetails() {
        if (this instanceof Patient) {
            System.out.println("Hospital Name: " + hospitalName);
            System.out.println("Patient ID: " + patientID);
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Ailment: " + ailment);
        }
    }

    public static void main(String[] args) {
        Patient.setHospitalName("City Hospital");
        Patient pt1 = new Patient("Lathika",30,"Flu","P001");
        Patient pt2 = new Patient("Lidiya",45,"Fracture","P002");
        System.out.println("Total Patients Admitted: " + Patient.getTotalPatients());
        pt1.displayPatientDetails();
        System.out.println();
        pt2.displayPatientDetails();
    }
}
