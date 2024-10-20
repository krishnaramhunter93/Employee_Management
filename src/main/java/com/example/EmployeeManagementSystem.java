package com.example;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EmployeeManagementSystem {

	public static void main(String[] args) {
		// Step 1: Create and store the dataset in a collection
		List<Employee> employees = Arrays.asList(new Employee("Alice", 28, "HR", 50000),
				new Employee("Bob", 35, "Engineering", 75000), new Employee("Charlie", 30, "Finance", 60000),
				new Employee("David", 40, "Engineering", 80000), new Employee("Eve", 32, "HR", 52000));

		// Print the original dataset using toString
		System.out.println("Step 1: Original Dataset:");
		employees.forEach(System.out::println);

		// Step 2: Function using Function interface to concatenate name and department
		Function<Employee, String> nameAndDepartment = emp -> emp.getName() + " - " + emp.getDepartment();

		// Print the function result for each employee
		System.out.println("\nStep 2: Name and Department Concatenation:");
		employees.forEach(emp -> System.out.println(nameAndDepartment.apply(emp)));

		// Step 3: Use streams to generate a new collection of concatenated strings
		List<String> employeeSummaries = employees.stream().map(nameAndDepartment).collect(Collectors.toList());

		// Print the concatenated strings
		System.out.println("\nStep 3: Collection of Concatenated Strings:");
		employeeSummaries.forEach(System.out::println);

		// Step 4: Calculate the average salary of all employees using streams
		double averageSalary = employees.stream().mapToDouble(Employee::getSalary).average().orElse(0.0);

		// Print the average salary
		System.out.println("\nStep 4: Average Salary of All Employees:");
		System.out.println(averageSalary);

		// Step 5: Filter employees based on an age threshold (e.g., 30 years)
		int ageThreshold = 30;
		List<Employee> filteredEmployees = employees.stream().filter(emp -> emp.getAge() > ageThreshold)
				.collect(Collectors.toList());

		// Print the filtered employees using toString
		System.out.println("\nStep 5: Employees with Age > " + ageThreshold + ":");
		filteredEmployees.forEach(System.out::println);

		// Generate new collection of concatenated strings for filtered employees
		List<String> filteredEmployeeSummaries = filteredEmployees.stream().map(nameAndDepartment)
				.collect(Collectors.toList());

		// Print the filtered concatenated strings
		System.out.println("\nStep 6: Collection of Concatenated Strings for Filtered Employees:");
		filteredEmployeeSummaries.forEach(System.out::println);

		// Calculate the average salary of filtered employees
		double filteredAverageSalary = filteredEmployees.stream().mapToDouble(Employee::getSalary).average()
				.orElse(0.0);

		// Print the average salary of filtered employees
		System.out.println("\nStep 7: Average Salary of Filtered Employees:");
		System.out.println(filteredAverageSalary);
	}
}
