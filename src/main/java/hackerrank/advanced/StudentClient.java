/**
 * 
 */
package hackerrank.advanced;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Arbind Negi 14-Aug-2021
 *
 */
class Student {
    private String studentName;
    private String rollNo;
    
    
    /**
     * @param studentName
     * @param rollNo
     */
    public Student(String studentName, String rollNo) {
	this.studentName = studentName;
	this.rollNo = rollNo;
    }
    /**
     * @return the studentName
     */
    public String getStudentName() {
        return studentName;
    }
    /**
     * @param studentName the studentName to set
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    /**
     * @return the rollNo
     */
    public String getRollNo() {
        return rollNo;
    }
    /**
     * @param rollNo the rollNo to set
     */
    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }
}

public class StudentClient {

    private Map<String, List<String>> map = new ConcurrentHashMap<>();
    private List<String> rollnoList;

    /**
     * @param args
     */
    public static void main(String[] args) {
	StudentClient studentClient = new StudentClient();
	Student student1 = new Student("Arbind Negi", "100");
	Student student2 = new Student("Arbind Negi", "10");
	Student student3 = new Student("Arbind", "101");
	Student student4 = new Student("XX", "1000");
	
	studentClient.add(student1.getStudentName(), student1.getRollNo());
	studentClient.validate(student1.getStudentName(), student1.getRollNo());

	studentClient.add(student2.getStudentName(), student2.getRollNo());
	studentClient.validate(student2.getStudentName(), student2.getRollNo());

	studentClient.add(student3.getStudentName(), student3.getRollNo());
	studentClient.validate(student3.getStudentName(), student3.getRollNo());

	studentClient.add(student4.getStudentName(), student4.getRollNo());
	studentClient.validate(student4.getStudentName(), student4.getRollNo());
	
	studentClient.printDetails();

    }

    public void add(String name, String rollno) {
	if (rollnoList == null) {
	    rollnoList = new ArrayList<>();
	    rollnoList.add(rollno);
	    map.put(name, rollnoList);
	} else {
	    map.forEach((k, v) -> {
		if (name.equals(k)) {
		    rollnoList.add(rollno);
		    map.put(name, rollnoList);
		} else {
		    rollnoList = new ArrayList<>();
		    rollnoList.add(rollno);
		    map.put(name, rollnoList);
		}
	    });
	}
    }

    public void validate(String name, String rollno) {
	System.out.println("Sudent :" + name + " is added successfully with roll No :" + rollno);
    }

    public void printDetails() {
	System.out.println("Detail of all students (key, value pair)");
	map.forEach((k, v) -> System.out.println( k + ":"+  v));
    }

}
