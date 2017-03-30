package examples.section03.data;

public class Employee implements Person, Identified {
	private String name;
	private double salary;

	public Employee(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}

	public void raiseSalary(double byPercent) {
		double raise = salary * byPercent / 100;
		salary += raise;
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	public int getId() {
		return Identified.super.getId();
	}

	@Override
	public String toString() {
		return String.format("Employee{id='%d', name='%s', salary='%.1f'}", getId(), name, salary);
	}
}