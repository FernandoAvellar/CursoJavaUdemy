package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Employee> employeeList = new ArrayList<>();

		System.out.print("How many employees will be registered? ");
		int numberOfEmployees = sc.nextInt();
		sc.nextLine();

		for (int i = 0; i < numberOfEmployees; i++) {
			System.out.println();
			System.out.println("Employee #" + (i + 1));

			System.out.print("Id: ");
			int id = sc.nextInt();
			sc.nextLine();

			System.out.print("Name: ");
			String name = sc.nextLine();

			System.out.print("Salary: ");
			double salary = sc.nextDouble();

			Employee employee = new Employee(id, name, salary);
			employeeList.add(employee);
		}

		System.out.println();
		System.out.print("Enter the employee id that will have salary increase: ");
		int employeeId = sc.nextInt();
		
		Employee employeeToIncreaseSalary = getEmployeeById(employeeId, employeeList);
		if (employeeToIncreaseSalary == null) {
			System.out.println("This id does not exist!");
		} else {
			System.out.print("Enter the percentage: ");
			double raisePercent = sc.nextDouble();
			employeeToIncreaseSalary.raiseSalary(raisePercent);
		}

		System.out.println();
		System.out.println("List of employees:");
		for (Employee employee : employeeList) {
			System.out.println(employee);

		}

		sc.close();

	}

	private static Employee getEmployeeById(int employeeId, List<Employee> employeeList) {
		return employeeList.stream().filter(e -> e.getId() == employeeId).findFirst().orElse(null);
		/*
		 * for (Employee employee : employeeList) { if (employee.getId() == employeeId)
		 * { return employee; } } return null;
		 */
	}

}
