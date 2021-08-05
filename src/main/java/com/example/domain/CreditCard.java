package com.example.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="credit_cards")
public class CreditCard implements Serializable{

	private static final long serialVersionUID = 1L;
	
	// atributos propios
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String number;
	
	
	
	public CreditCard() {
	}
	

	public CreditCard(Long id, String number) {
		this.id = id;
		this.number = number;
	}


	public Long getId() {
		return id;
	}

	public String getNumber() {
		return number;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	
	
}
