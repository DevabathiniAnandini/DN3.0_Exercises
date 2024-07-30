class Employee {
    private String employeeId;
    private String name;
    private String position;
    private double salary;

    public Employee(String employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
               "employeeId='" + employeeId + '\'' +
               ", name='" + name + '\'' +
               ", position='" + position + '\'' +
               ", salary=" + salary +
               '}';
    }
}
public class Exercise4 {
    private Employee[] employees;
    private int count;

    public Exercise4(int capacity) {
        employees = new Employee[capacity];
        count = 0;
    }

    public boolean addEmployee(Employee employee) {
        if (count < employees.length) {
            employees[count++] = employee;
            return true;
        }
        return false; 
    }

    public Employee searchEmployee(String employeeId) {
        for (int i = 0; i < count; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                return employees[i];
            }
        }
        return null;
    }

    public void traverseEmployees() {
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i]);
        }
    }

    public boolean deleteEmployee(String employeeId) {
        for (int i = 0; i < count; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                employees[i] = employees[--count]; 
                employees[count] = null; 
                return true;
            }
        }
        return false; 
    }

    public static void main(String[] args) {
        Exercise4 ems = new Exercise4(10);

        ems.addEmployee(new Employee("E001", "Alice", "Manager", 70000));
        ems.addEmployee(new Employee("E002", "Bob", "Developer", 50000));
        ems.addEmployee(new Employee("E003", "Charlie", "Designer", 45000));

        System.out.println("All Employees:");
        ems.traverseEmployees();

        System.out.println("\nSearch for Employee E002:");
        System.out.println(ems.searchEmployee("E002"));

        System.out.println("\nDelete Employee E003:");
        ems.deleteEmployee("E003");

        System.out.println("\nAll Employees After Deletion:");
        ems.traverseEmployees();
    }
}
