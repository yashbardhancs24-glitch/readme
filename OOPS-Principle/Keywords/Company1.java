package Keywords;

public class Company1 {
    private static String companyName;
    private static int totalEmployees = 0;
    private String name;
    private final int id;
    private String designation;

    public Company1(String name, int id, String designation) {
        this.name = name;
        this.id = id;
        this.designation = designation;
        totalEmployees++;
    }

    public Company1(int id) {
        this.id = id;
    }

    public static void setCompanyName(String name) { companyName = name; }
    public static void displayTotalEmployees() { System.out.println("Total Employees: " + totalEmployees); }

    public void displayEmployeeDetails() {
        if (this instanceof Company1) {
            System.out.println("Company Name: " + companyName);
            System.out.println("Employee ID: " + id);
            System.out.println("Name: " + name);
            System.out.println("Designation: " + designation);
        }
    }

    public static void main(String[] args) {
        Company1.setCompanyName("Tech Solutions Inc.");
        Company1 emp1 = new Company1("Thamarai",101,"Software Engineer");
        Company1 emp2 = new Company1("Rohan",102,"Project Manager");
        Company1.displayTotalEmployees();
        emp1.displayEmployeeDetails();
        emp2.displayEmployeeDetails();
    }
}
