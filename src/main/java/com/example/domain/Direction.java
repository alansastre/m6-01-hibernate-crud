package com.example.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="directions")
public class Direction implements Serializable{

	private static final long serialVersionUID = 1L;

	// atributos propios
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="street", length = 100)
	private String street;
	
	@Column(name="postal_code")
	private String postalCode;
	
	private String city;
	
	private String country;
	
	// not owner
	@OneToOne(mappedBy = "direction") // bidireccional: opcional
	//@OneToOne(mappedBy = "direction", cascade = CascadeType.REMOVE) // bidireccional: opcional
	private Employee employee;

	public Direction() {}
	
	public Direction(Long id, String street, String postalCode, String city, String country) {
		this.id = id;
		this.street = street;
		this.postalCode = postalCode;
		this.city = city;
		this.country = country;
	}

	public Long getId() {
		return id;
	}

	public String getStreet() {
		return street;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public String getCity() {
		return city;
	}

	public String getCountry() {
		return country;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
	
}
