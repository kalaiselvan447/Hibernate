package com.masterpiece.Demohibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
//import javax.persistence.Transient;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="alien_table")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Alien {
	
	@Id
//	@Column(name="id")
	private int aid;
	
//	private AlineName aname;
	
	private String aname;
	
//	@Transient // if mentioned this annotation it will not get stored in database
	@Column(name="a_tech")
	private String tech;
	
//	@OneToOne
//	Laptop laptop;
	
//	@ManyToMany(mappedBy="alien")
//	List<Laptop> laptop = new ArrayList<Laptop>();
//	
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getTech() {
		return tech;
	}
	public void setTech(String tech) {
		this.tech = tech;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	@Override
	public String toString() {
		return "Alien [aid=" + aid + ", aname=" + aname + ", tech=" + tech + "]";
	}
	
//	public AlineName getAname() {
//		return aname;
//	}
//	public void setAname(AlineName aname) {
//		this.aname = aname;
//	}
	
//	public List<Laptop> getLaptop() {
//		return laptop;
//	}
//	public void setLaptop(List<Laptop> laptop) {
//		this.laptop = laptop;
//	}
	
	
	
	
	
}
