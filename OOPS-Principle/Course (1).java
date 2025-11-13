import java.util.ArrayList;
import java.util.List;

class Course {
    private String courseName;
    private List<Student> enrolledStudents = new ArrayList<>(); // Association with Student

    public Course(String courseName) { this.courseName = courseName; }
    public String getCourseName() { return this.courseName; }

    public void addStudent(Student student) {
        enrolledStudents.add(student);
    }

    public void showEnrolledStudents() {
        System.out.println("Students in " + this.courseName + ":");
        for (Student s : enrolledStudents) {
            System.out.println("- " + s.getName());
        }
    }
}

class Student {
    private String name;
    private List<Course> enrolledCourses = new ArrayList<>(); // Association with Course

    public Student(String name) { this.name = name; }
    public String getName() { return this.name; }

    public void enrollInCourse(Course course) {
        this.enrolledCourses.add(course);
        course.addStudent(this); // Establish the bi-directional link
    }

    public void viewEnrolledCourses() {
        System.out.println(this.name + "'s Courses:");
        for (Course c : enrolledCourses) {
            System.out.println("- " + c.getCourseName());
        }
    }
}

class School {
    private String name;
    private List<Student> students = new ArrayList<>(); // Aggregation of Students

    public School(String name) { this.name = name; }

    public void admitStudent(Student student) {
        this.students.add(student);
    }
}

// Main class to demonstrate
public class SchoolDemo {
    public static void main(String[] args) {
        // Create independent students and courses
        Student student1 = new Student("Eve");
        Student student2 = new Student("Frank");
        Course math101 = new Course("Math 101");
        Course hist202 = new Course("History 202");

        // A school aggregates students
        School highSchool = new School("Central High");
        highSchool.admitStudent(student1);
        highSchool.admitStudent(student2);

        // Students and Courses form an association
        student1.enrollInCourse(math101);
        student1.enrollInCourse(hist202);
        student2.enrollInCourse(math101);

        // Demonstrate the relationships
        student1.viewEnrolledCourses();
        System.out.println();
        math101.showEnrolledStudents();
    }
}
