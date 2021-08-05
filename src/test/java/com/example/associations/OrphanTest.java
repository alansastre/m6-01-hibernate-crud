package com.example.associations;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Arrays;

import org.hibernate.Session;
import org.junit.jupiter.api.Test;

import com.example.domain.Company;
import com.example.domain.CreditCard;
import com.example.domain.Employee;
import com.example.util.HibernateUtil;
import java.util.List;

public class OrphanTest {

	@Test
	void save1() throws Exception {
		
		
		Session session = HibernateUtil.getSessionFactory().openSession();

		Company company = new Company(null, "Nombre", "CIF", null, 40000d);
		CreditCard creditCard1 = new CreditCard(null, "142344354354");
			
		session.beginTransaction();
		
		session.save(company);
		session.save(creditCard1);
		
		session.getTransaction().commit();
		
		
		session.close();
	}
	
	
	@Test
	void saveAll() throws Exception {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Company company = new Company(null, "Nombre", "CIF", null, 40000d);
		CreditCard creditCard1 = new CreditCard(null, "card1");
		CreditCard creditCard2 = new CreditCard(null, "card2");
		CreditCard creditCard3 = new CreditCard(null, "card3");
		
		company.getCreditCards().addAll(List.of(creditCard1, creditCard2, creditCard3));
		
		session.beginTransaction();
		
		session.save(creditCard1);
		session.save(creditCard2);
		session.save(creditCard3);
		session.save(company);
		
		session.getTransaction().commit();
		
		session.beginTransaction();
		
		company.getCreditCards().remove(0);
		company.getCreditCards().remove(0);
		session.save(company);
		// Opcion 1: orphanRemoval = true a la relacion de Company con CreditCard para que se borren automaticamente
		// las tarjetas desasociadas
		
		// Opcion 2: borrar manualmente las tarjetas desasociadas
		// session.delete(creditCard1);
		
		session.getTransaction().commit();
		
		
		session.close();
	}
}
