package oopspgrms;
import java.util.*;

class Employee {
    private String name;
    private int employeeId;
    private int age;
    private String position;
    private double salary;

    public Employee(String name, int employeeId, int age, String position, double salary) {
        this.name = name;
        this.employeeId = employeeId;
        this.age = age;
        this.position = position;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

class Organization {
    private double balance;
    private List<Employee> employees;

    public Organization(double initialBalance) {
        this.balance = initialBalance;
        this.employees = new ArrayList<>();
    }

    public void hireEmployee(Employee employee) {
        employees.add(employee);
    }

    public void creditSalary(Employee employee, double amount) {
        if (balance >= amount) {
            balance -= amount;
            employee.setSalary(employee.getSalary() + amount);
        } else {
            throw new IllegalArgumentException("Insufficient funds in organization account.");
        }
    }

    public double getOrganizationBalance() {
        return balance;
    }

    public double getTotalSalarySpent() {
        double totalSalary = 0;
        for (Employee employee : employees) {
            totalSalary += employee.getSalary();
        }
        return totalSalary;
    }
}

public class Main {
    public static void main(String[] args) {
        Organization organization = new Organization(100000); // Initial balance of organization

        Employee emp1 = new Employee("Dharani", 1, 30, "Manager", 0);
        Employee emp2 = new Employee("Kani", 2, 25, "Developer", 0);

        organization.hireEmployee(emp1);
        organization.hireEmployee(emp2);

        try {
            organization.creditSalary(emp1, 5000); // Credit salary to employee
            organization.creditSalary(emp2, 6000);
            organization.creditSalary(emp1, 7000); // Attempting to credit more than the balance
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Organization balance: " + organization.getOrganizationBalance());
        System.out.println("Total salary spent: " + organization.getTotalSalarySpent());
    }
}


