package com.example.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="employees")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="full_name", unique = true)
	private String fullName;
	
	@Column(name="biography", length = 300)
	private String biography;
	
	private Boolean married;
	
	
	public Employee() {}


	public Long getId() {
		return id;
	}


	public String getFullName() {
		return fullName;
	}


	public String getBiography() {
		return biography;
	}


	public Boolean getMarried() {
		return married;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public void setBiography(String biography) {
		this.biography = biography;
	}


	public void setMarried(Boolean married) {
		this.married = married;
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", fullName=" + fullName + ", biography=" + biography + ", married=" + married
				+ "]";
	}
	
	
	
}
