import java.util.ArrayList;
import java.util.List;

class Employee {
    private String name;
    public Employee(String name) {
        this.name = name;
    }
    @Override
    public String toString() { return this.name; }
}

class Department {
    private String name;
    private List<Employee> employees = new ArrayList<>();

    // Department creates its own employees
    public Department(String name) {
        this.name = name;
    }

    public void addEmployee(String employeeName) {
        this.employees.add(new Employee(employeeName));
    }

    public void showEmployees() {
        System.out.println("  Employees: " + employees);
    }

    @Override
    public String toString() { return "Department: " + this.name; }
}
class Company {
    private String name;
    private List<Department> departments;

    public Company(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }
    public void addDepartment(String name) {
        this.departments.add(new Department(name));
    }

    public Department getDepartment(String name) {
        for(Department dept : departments) {
            if(dept.toString().contains(name)) return dept;
        }
        return null;
    }

    public void showDepartments() {
        System.out.println("Departments in " + this.name + ":");
        for (Department dept : departments) {
            System.out.println("- " + dept);
            dept.showEmployees();
        }
    }
}
public class CompanyDemo {
    public static void main(String[] args) {
        Company myCompany = new Company("Innovate Corp");
        myCompany.addDepartment("Human Resources");
        myCompany.addDepartment("Engineering");
        Department engineering = myCompany.getDepartment("Engineering");
        if (engineering != null) {
            engineering.addEmployee("Charlie");
            engineering.addEmployee("David");
        }

        myCompany.showDepartments();
        myCompany = null;
        System.out.println("\nCompany object is now null. Its departments no longer exist.");
    }
}
