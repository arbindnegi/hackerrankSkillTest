/**
 * 
 */
package com.java.examples;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Arbind Negi 29-Sep-2021
 *
 */
public class Student {
    private String studentName;
    private List<String> rollNo;
    
    
    /**
     * @param studentName
     * @param v
     */
    public Student(String studentName, List<String> v) {
	this.studentName = studentName;
	this.rollNo = v;
    }
    
    public Student() {
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
    public List<String> getRollNo() {
        return rollNo;
    }
    /**
     * @param rollNo the rollNo to set
     */
    public void setRollNo(List<String> rollNo) {
        this.rollNo = rollNo;
    }
  
    private Map<String, List<String>> map = new ConcurrentHashMap<>();
    private List<String> rollnoList;
    
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
    
    public Student printDetails() {
	Student student = null;
	map.forEach((k, v) ->  new Student(k, v));
	map.forEach((k, v) ->  System.out.println("Key : " + k + ", Value : " + v));
	return student;
    }
}
