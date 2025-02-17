class Employee {
    int id;
    String name;
    double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Salary: " + salary;
    }
}

class EmployeeManagementSystem {
    private List<Employee> employees = new ArrayList<>();

    public void addEmployee(int id, String name, double salary) {
        for (Employee emp : employees) {
            if (emp.id == id) {
                System.out.println("Error: Employee with ID " + id + " already exists.");
                return;
            }
        }
        employees.add(new Employee(id, name, salary));
        System.out.println("Employee Added: ID=" + id + ", Name=" + name + ", Salary=" + salary);
    }

    public void updateEmployee(int id, double newSalary) {
        for (Employee emp : employees) {
            if (emp.id == id) {
                emp.salary = newSalary;
                System.out.println("Employee ID " + id + " updated successfully.");
                return;
            }
        }
        System.out.println("Error: Employee ID " + id + " not found.");
    }

    public void removeEmployee(int id) {
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            Employee emp = iterator.next();
            if (emp.id == id) {
                iterator.remove();
                System.out.println("Employee ID " + id + " removed successfully.");
                return;
            }
        }
        System.out.println("Error: Employee ID " + id + " not found.");
    }

    public void searchEmployeeById(int id) {
        for (Employee emp : employees) {
            if (emp.id == id) {
                System.out.println("Employee Found: " + emp);
                return;
            }
        }
        System.out.println("Error: Employee ID " + id + " not found.");
    }

    public void displayEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            for (Employee emp : employees) {
                System.out.println(emp);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem();

        // Test Case 1: Display Employees (No employees initially)
        ems.displayEmployees();

        // Test Case 2: Add Employees
        ems.addEmployee(101, "Anish", 50000);
        ems.addEmployee(102, "Bobby", 60000);

        // Test Case 3: Update Employee Salary
        ems.updateEmployee(101, 55000);

        // Test Case 4: Search Employee by ID
        ems.searchEmployeeById(102);

        // Test Case 5: Remove Employee
        ems.removeEmployee(101);

        // Test Case 6: Display All Employees
        ems.displayEmployees();

        // Test Case 7: Adding Duplicate Employee ID
        ems.addEmployee(101, "Charlie", 70000);
    }
}
