package com.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private String college;
	
	public Employee() {

	}
	
	
	public Employee(Integer id, String name, String college) {
		super();
		this.id = id;
		this.name = name;
		this.college = college;
		
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", college=" + college + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	

}
