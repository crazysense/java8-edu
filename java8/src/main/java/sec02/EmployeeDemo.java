package sec02;

import sec02.data.Employee;

import java.util.*;

public class EmployeeDemo {
	public static void main(String[] args) {
		Employee emp1 = new Employee("kim", 50000);
		Employee emp2 = new Employee("lee", 90000);
		Employee emp3 = new Employee("choi", 80000);
		Employee emp4 = new Employee("moon", 70000);
		Employee emp5 = new Employee("park", 60000);

		List<Employee> employees = new ArrayList<>();
		employees.add(emp1);
		employees.add(emp2);
		employees.add(emp3);
		employees.add(emp4);
		employees.add(emp5);

		print(employees);

		Collections.sort(employees, Comparator.comparingDouble(Employee::getSalary));

		print(employees);
	}

	private static void print(Collection c) {
		c.forEach(System.out::println);
		System.out.println("============================================");
	}
}
