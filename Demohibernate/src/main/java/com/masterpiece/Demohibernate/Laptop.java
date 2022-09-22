package com.masterpiece.Demohibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Laptop {
	
	@Id
	private int lid;
	private String lname;
	
//	@ManyToMany
//	private List<Alien> alien = new ArrayList<Alien>();
	
	
//	public List<Alien> getAlien() {
//		return alien;
//	}
//	public void setAlien(List<Alien> alien) {
//		this.alien = alien;
//	}
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	
	
}
