package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeMain {
	public static void main(String[] args) {
		
		Employee dc = new Employee("Deepak", 26);
		Employee ac = new Employee("Aditya", 22);
		Employee lc = new Employee("Lata", 45);
		Employee dcc = new Employee("Dinesh", 52);
		Employee atul = new Employee("Atul", 35);
		Employee dhruv = new Employee("Dhruv", 16);
		
		List<Employee> employees = new ArrayList<>();
		employees.add(dc);
		employees.add(dcc);
		employees.add(ac);
		employees.add(lc);
		employees.add(dhruv);
		employees.add(atul);
		
		List<Employee> sortedEmployee = employees.stream()
												.sorted((e1,e2) -> e1.getName().compareTo(e2.getName()))
												.collect(Collectors.toList());
		
		sortedEmployee.forEach(employee -> {
			System.out.println(employee.getName() +" "+employee.getAge());
		});
		System.out.println("<===========================================>");
		List<Employee> employeeAbove30 = sortedEmployee.stream()
													.filter(e -> e.getAge()>30)
													.collect(Collectors.toList());
		
		employeeAbove30.forEach(e ->{
			System.out.println(e.getName() + " "+e.getAge());
		});
		
		
		Department hr = new Department("Human Resources");
		hr.addEmployee(dc);
		hr.addEmployee(ac);
		hr.addEmployee(atul);
		
		Department accounting = new Department("Accounting");
		accounting.addEmployee(lc);
		accounting.addEmployee(dcc);
		accounting.addEmployee(dhruv);
		
		List<Department> departments = new ArrayList<>();
		departments.add(hr);
		departments.add(accounting);
		
		departments.stream()
					.flatMap(department -> department.getEmployees().stream())
					.forEach(System.out::println);
		
		List<String> topNames2015 = Arrays.asList(
					"Amelia",
					"Olivia",
					"emily",
					"Isla",
					"Ava",
					"Amy",
					"oliver",
					"Jack",
					"Charlie",
					"harry",
					"Jacob");
		
		topNames2015.stream()
					.map(s -> s.substring(0,1).toUpperCase().concat(s.substring(1,s.length())))
					.peek(System.out::println)
					.filter(s-> s.startsWith("A"))
					.peek(System.out::println)
					.sorted()
					.forEach(System.out::println);
	}
	
}

class Employee{
	private String name;
	private int age;
	/**
	 * @param name
	 * @param age
	 */
	public Employee(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + "]";
	}
	
	
}

class Department{
	private String name;
	private List<Employee> employees;
	
	
	
	/**
	 * @param name
	 */
	public Department(String name) {
		this.name = name;
		employees = new ArrayList<>();
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the employees
	 */
	public List<Employee> getEmployees() {
		return employees;
	}
	/**
	 * @param employees the employees to set
	 */
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	public void addEmployee(Employee employee) {
		employees.add(employee);
	}
	
	
}

