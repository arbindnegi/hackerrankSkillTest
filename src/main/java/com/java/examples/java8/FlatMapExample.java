/**
 * 
 */
package com.java.examples.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Arbind Negi 25-Jul-2021
 *
 */
public class FlatMapExample {

    public static void main (String[] args) {
	List<Employee> employeeList = new ArrayList<>();
	
	Employee emp1 = new Employee("Arbind","G000111",
		Arrays.asList ("9988776655","9878654534"),1000.00);
	Employee emp2 = new Employee("Negi","G000112",
		Arrays.asList ("9988776644","9878654543"),2000.00);
	Employee emp3 = new Employee("Ajay","G000113",
		Arrays.asList ("9988770066","987865992233"),4000.00);
	Employee emp4 = new Employee("Arbind","G000114",
		Arrays.asList ("9988733885","9878617364"),6000.00);

	employeeList.add(emp1);
	employeeList.add(emp2);
	employeeList.add(emp3);
	employeeList.add(emp4);
	
	List<String> listOfempPhone = employeeList.stream().map(emp -> emp.getPhoneNo())
	            .flatMap(emp -> emp.stream())
	            .collect(Collectors.toList());
	System.out.println("List of all employees phone numbers :" + listOfempPhone);
	employeeList.stream().forEach(emp -> 
	             System.out.println(emp.getName() + " "+ emp.getEmpCode() + " "+emp.getSalary()+" "+ emp.getPhoneNo()));
	
	
    }
  
    public static class Employee {
	private String name;
	private String empCode;
	private List<String> phoneNo;
	private double salary;
	
	
	/**
	 * @param name
	 * @param empCode
	 * @param phoneNo
	 * @param salary
	 */
	public Employee(String name, String empCode, List<String> phoneNo, double salary) {
	    super();
	    this.name = name;
	    this.empCode = empCode;
	    this.phoneNo = phoneNo;
	    this.salary = salary;
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
	 * @return the empCode
	 */
	public String getEmpCode() {
	    return empCode;
	}
	/**
	 * @param empCode the empCode to set
	 */
	public void setEmpCode(String empCode) {
	    this.empCode = empCode;
	}
	/**
	 * @return the phoneNo
	 */
	public List<String> getPhoneNo() {
	    return phoneNo;
	}
	/**
	 * @param phoneNo the phoneNo to set
	 */
	public void setPhoneNo(List<String> phoneNo) {
	    this.phoneNo = phoneNo;
	}
	/**
	 * @return the salary
	 */
	public double getSalary() {
	    return salary;
	}
	/**
	 * @param salary the salary to set
	 */
	public void setSalary(double salary) {
	    this.salary = salary;
	}
	
    }
    
}
