package com.masterpiece.Demohibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AlineName {
	
	@Column(name="first_name")
	String firstName;
	@Column(name="last_name")
	String lastName;
	@Column(name="middle_name")
	String middleName;
	
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
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	
	
}
