package com.app.model;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="MyTable")


public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private int eid;
	@Column
	private String name;
	@Column
	private double salery;
	
	public Employee() {
		
		super();
		this.salery=2500;
		// TODO Auto-generated constructor stub
	}
	public Employee(int eid, String name, double salery) {
		super();
		this.eid = eid;
		this.name = name;
		this.salery = salery;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalery() {
		return salery;
	}
	public void setSalery(double salery) {
		this.salery = salery;
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", name=" + name + ", salery=" + salery + "]";
	}
		

}
