package com.lti.divyue.practice.JSONtoPOJO;

import java.util.List;

public class CustomerDetails {
	private int id;
	private String firstName;
	private String lastName;
	private List coursesCompleted;
	
	public CustomerDetails() {
		
	}

	public CustomerDetails(int id, String firstName, String lastName, List coursesCompleted) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.coursesCompleted = coursesCompleted;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List getCoursesCompleted() {
		return coursesCompleted;
	}

	public void setCoursesCompleted(List coursesCompleted) {
		this.coursesCompleted = coursesCompleted;
	}
	
	
	
}
