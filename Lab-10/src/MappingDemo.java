import java.util.*;
import java.util.function.Function;

class Employee {
    private String firstName;
    private String lastName;
    private double salary;

    public Employee(String firstName, String lastName, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public double getSalary() { return salary; }
}

public class MappingDemo {
    public static void main(String[] args) {

        List<Employee> employees = List.of(
                new Employee("Alice", "Johnson", 72000.00),
                new Employee("Bob", "Martinez", 55000.50),
                new Employee("Clara", "Smith", 91000.75),
                new Employee("David", "Lee", 48500.00)
        );

        Function<Employee, String> formatCard =
                e -> "Name: [" + e.getLastName() + ", " + e.getFirstName() + "]- Salary: $" + e.getSalary();

        Function<Employee, Double> salaryPicker = Employee::getSalary;

        System.out.println("=== Employee Cards ===");

        employees.forEach(e -> {
            System.out.println(formatCard.apply(e));
            System.out.println("Salary only: $" + salaryPicker.apply(e));
            System.out.println();
        });
    }
}