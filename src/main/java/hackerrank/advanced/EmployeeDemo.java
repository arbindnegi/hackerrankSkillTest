package hackerrank.advanced;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeDemo {

	public static void main(String[] args) {
		List<Employee> employeeData = getEmployeeData();
		System.out.println("Size:" + employeeData.size());
		System.out.println("Orignial:" + employeeData);
		
		employeeData = employeeData.stream().sorted(Comparator.comparing(Employee::getName).thenComparing(Employee::getDepartment)).distinct().collect(Collectors.toList());
		System.out.println("Size:" + employeeData.size());
		System.out.println("Sorted:" + employeeData);
		
		employeeData.stream().forEach(e -> {
		    if(e.getAge() > 40) {
			System.out.println(e.getName() + "  Retirement will be on 31 Dec 2022 from department " + e.getDepartment());
		    }  
		});
		
		List<String> empnames = employeeData
			.stream()
			.filter(age -> age.getAge() > 30)
			.map(e -> e.getName())
			.collect(Collectors.toList());
		System.out.println(empnames);

	}
	
	
	static List<Employee> getEmployeeData(){
		List<Employee> empList = new ArrayList<>();
		empList.add(new Employee("Arbind", "Barclays", 45));
		empList.add(new Employee("Negi", "Barclays Markets", 40));
		empList.add(new Employee("Anil", "BNP", 22));
		empList.add(new Employee("Sharma", "BNP Markets", 30));
		empList.add(new Employee("Negi", "Barclays Markets", 40));
		empList.add(new Employee("XYZ", "Barclays", 45));
		return empList;
		
	}

}

class Employee {
	private String name;
	private String department;
	private int age;

	public Employee(String name, String department, int age) {
		super();
		this.name = name;
		this.department = department;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result
				+ ((department == null) ? 0 : department.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (age != other.age)
			return false;
		if (department == null) {
			if (other.department != null)
				return false;
		} else if (!department.equals(other.department))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", department=" + department
				+ ", age=" + age + "]";
	}

}
