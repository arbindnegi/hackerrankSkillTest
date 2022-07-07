/**
 * 
 */
package com.java.examples;

import java.util.Arrays;
import java.util.List;

/**
 * @author Arbind Negi 29-Sep-2021
 *
 */
public class StudentInterfaceImpl {

    public static void main (String [] args) {
	String name = "Arbind";
	List<String> rollno = Arrays.asList("100","101");
	//Interface implementation by using anonymous class
	StudentInterface studentInterface = new StudentInterface() {
	    
	    @Override
	    public Student studentDetails() {
		Student students = new Student(name, rollno);
		return  students;
	    }
	};
	System.out.println("Student name : " + studentInterface.studentDetails().getStudentName() + "  Student rollNo : "+ studentInterface.studentDetails().getRollNo() );
    
	//Interface implementation by using lambda expression
	StudentInterface studentInterfaceBylembda = () -> {
	    Student students = new Student();
	    students.setStudentName("Negi");
	    students.setRollNo(rollno);
	    return students;
	};
	System.out.println("Student name : " + studentInterfaceBylembda.studentDetails().getStudentName() + "  Student rollNo : "+ studentInterfaceBylembda.studentDetails().getRollNo() );
    
	    //Interface implementation by using Method reference
	    
	    Student std = new Student();
	    StudentInterface studentInterfaceByMethodRef = std::printDetails;
	    studentInterfaceByMethodRef.studentDetails();
    }
    
}
