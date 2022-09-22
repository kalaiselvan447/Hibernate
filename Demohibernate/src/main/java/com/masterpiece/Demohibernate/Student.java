package com.masterpiece.Demohibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	
	@Id
	@Column(name="roll_no")
	private int rollno;
	
	@Column(name="student_name")
	private String name;
	
	@Column(name="student_mark")
	private int mark;
	
	
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMark() {
		return mark;
	}
	public void setMark(int mark) {
		this.mark = mark;
	}
	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", name=" + name + ", mark=" + mark + "]";
	}
	
	
}
