package org.example;

import org.example.entity.Employee;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new LinkedList<>();

        employees.add(new Employee(1, "Margot", "Robbie"));
        employees.add(new Employee(2, "Jason", "Statham"));
        employees.add(new Employee(3, "Dwayne", "Johnson"));
        employees.add(new Employee(4, "Henry", "Cavill"));
        employees.add(new Employee(1, "Dwayne", "Johnson"));

        List<Employee> duplicates = findDuplicates(employees);
        System.out.println("Tekrar eden çalışanlar: " + duplicates);

        Map<Integer, Employee> uniques = findUniques(employees);
        System.out.println("Benzersiz çalışanlar: " + uniques);

        List<Employee> withoutDuplicates = removeDuplicates(employees);
        System.out.println("Tekrar etmeyen çalışanlar: " + withoutDuplicates);
    }

    public static List<Employee> findDuplicates(List<Employee> list) {
        List<Employee> duplicates = new LinkedList<>();
        Set<Employee> uniqueElements = new HashSet<>();

        for (Employee employee : list) {
            if (!uniqueElements.add(employee)) {
                if (!duplicates.contains(employee)) {
                    duplicates.add(employee);
                }
            }
        }
        return duplicates;
    }

    public static Map<Integer, Employee> findUniques(List<Employee> list) {
        Map<Integer, Employee> uniques = new HashMap<>();
        Set<Integer> seenIds = new HashSet<>();

        for (Employee employee : list) {
            if (employee != null) {
                if (!seenIds.contains(employee.getId())) {
                    uniques.put(employee.getId(), employee);
                    seenIds.add(employee.getId());
                }
            }
        }
        return uniques;
    }

    public static List<Employee> removeDuplicates(List<Employee> list) {
        Map<Employee, Integer> elementCountMap = new HashMap<>();

        for (Employee employee : list) {
            if (employee != null) {
                elementCountMap.put(employee, elementCountMap.getOrDefault(employee, 0) + 1);
            }
        }

        List<Employee> result = new LinkedList<>();

        for (Map.Entry<Employee, Integer> entry : elementCountMap.entrySet()) {
            if (entry.getValue() == 1) {
                result.add(entry.getKey());
            }
        }
        return result;
    }
}
