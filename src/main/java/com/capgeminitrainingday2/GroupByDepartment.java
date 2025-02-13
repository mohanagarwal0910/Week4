package com.capgeminitrainingday2;
import java.util.*;
class Employee {
    String name;
    String department;
    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }
    @Override
    public String toString() {
        return name; // Only print the name for better readability
    }
}
public class GroupByDepartment {
    public static Map<String, List<Employee>> groupByDepartment(List<Employee> employees) {
        Map<String, List<Employee>> departmentMap = new HashMap<>();

        for (Employee emp : employees) {
            if (!departmentMap.containsKey(emp.department)) {
                departmentMap.put(emp.department, new ArrayList<>());
            }
            departmentMap.get(emp.department).add(emp);
        }
        return departmentMap;
    }
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR"),
                new Employee("Bob", "IT"),
                new Employee("Carol", "HR"),
                new Employee("David", "Finance"),
                new Employee("Eve", "IT")
        );
        Map<String, List<Employee>> grouped = groupByDepartment(employees);
        // Print grouped employees
        for (Map.Entry<String, List<Employee>> entry : grouped.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

