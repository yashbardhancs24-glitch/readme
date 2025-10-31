import java.util.ArrayList;
import java.util.List;

// Faculty can exist independently
class Faculty {
    private String name;
    public Faculty(String name) { this.name = name; }
    @Override
    public String toString() { return "Faculty member: " + this.name; }
}

class University {
    private String name;
    // Composition: Departments are part of the University
    private List<Department> departments = new ArrayList<>();
    // Aggregation: Faculty are associated with but independent of the University
    private List<Faculty> facultyMembers = new ArrayList<>();

    private static class Department { // Inner class to enforce composition
        private String name;
        public Department(String name) { this.name = name; }
        @Override
        public String toString() { return "Department of " + this.name; }
    }

    public University(String name) { this.name = name; }

    // University creates and manages its own departments
    public void addDepartment(String name) {
        this.departments.add(new Department(name));
    }

    // University hires existing faculty members
    public void hireFaculty(Faculty faculty) {
        this.facultyMembers.add(faculty);
    }

    public void showDetails() {
        System.out.println("University: " + this.name);
        System.out.println("Departments: " + this.departments);
        System.out.println("Faculty: " + this.facultyMembers);
    }
}

// Main class
public class UniversityDemo {
    public static void main(String[] args) {
        // Faculty members can be created independently
        Faculty profJones = new Faculty("Dr. Jones");
        Faculty profSmith = new Faculty("Dr. Smith");

        // Create the University
        University myUniversity = new University("State University");

        // Composition: University creates its departments
        myUniversity.addDepartment("Physics");
        myUniversity.addDepartment("Computer Science");

        // Aggregation: University hires independent faculty
        myUniversity.hireFaculty(profJones);
        myUniversity.hireFaculty(profSmith);

        myUniversity.showDetails();

        // If the university closes, its departments are gone.
        myUniversity = null;
        System.out.println("\nUniversity object set to null.");

        // But the faculty members still exist.
        System.out.println("Independent faculty still exists: " + profJones);
    }
}
