package Collections;
import java.util.*;

class Student implements Comparable<Student> {
    String name;
    int marks;
    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }
    public int compareTo(Student other) {
        int markCompare = Integer.compare(other.marks, this.marks);
        if (markCompare != 0) return markCompare;
        return this.name.compareTo(other.name);
    }
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student s = (Student) o;
        return name.equals(s.name);
    }
    public int hashCode() {
        return name.hashCode();
    }
    public String toString() {
        return name + ": " + marks;
    }
}

public class College_Admission_System{
    List<Student> applicants = new ArrayList<>();
    Set<Student> shortlisted = new HashSet<>();
    Queue<Student> interviewQueue = new LinkedList<>();
    TreeSet<Student> finalMeritList = new TreeSet<>();

    public void acceptApplications(Student[] newApplicants) {
        for (Student s : newApplicants) {
            applicants.add(s);
        }
    }

    public void shortlistEligible(int minMarks) {
        for (Student s : applicants) {
            if (s.marks >= minMarks) {
                shortlisted.add(s);
            }
        }
    }

    public void queueForInterview() {
        for (Student s : shortlisted) {
            interviewQueue.add(s);
        }
    }

    public void finalizeSelections(Set<Student> selectedStudents) {
        for (Student s : selectedStudents) {
            finalMeritList.add(s);
        }
    }

    public static void main(String[] args) {
    	College_Admission_System system = new College_Admission_System();

        Student[] newApplicants = {
            new Student("Alice", 85),
            new Student("Bob", 78),
            new Student("Charlie", 90),
            new Student("David", 65),
            new Student("Eve", 88)
        };

        system.acceptApplications(newApplicants);
        system.shortlistEligible(75);
        system.queueForInterview();

        Set<Student> selectedAfterInterview = new HashSet<>();
        while (!system.interviewQueue.isEmpty()) {
            Student current = system.interviewQueue.poll();
            if (current.marks >= 80) {
                selectedAfterInterview.add(current);
            }
        }
        system.finalizeSelections(selectedAfterInterview);

        System.out.println("Final Merit List:");
        for (Student s : system.finalMeritList) {
            System.out.println(s);
        }
    }
}


