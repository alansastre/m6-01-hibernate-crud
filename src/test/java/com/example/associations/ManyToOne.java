package com.example.associations;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.hibernate.Session;
import org.junit.jupiter.api.Test;

import com.example.domain.Company;
import com.example.domain.Direction;
import com.example.domain.Employee;
import com.example.util.HibernateUtil;

/**
 * Asociación Employee - Company
 */
public class ManyToOne {

	@Test
	void save() throws Exception {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		
		Employee employee = new Employee(null, "Usuario Hibernate", "Lorem ipsum dolor", true);
		Company company = new Company(null, "Empresa 1", "B122342", LocalDate.now(), 3500d);
		
		// asociacion
		employee.setCompany(company);
		
		session.beginTransaction();

		
		session.save(company);
		session.save(employee);

		
		System.out.println(employee);
		
		session.getTransaction().commit();
		
		session.close();
	}
	
	@Test
	void findEmployee() throws Exception {
		
		Session session = HibernateUtil.getSessionFactory().openSession();


		Employee employee = session.find(Employee.class, 5L);
		
		System.out.println(employee);
		assertNotNull(employee);
		assertEquals(5L, employee.getId());
		assertNotNull(employee.getDirection());
		assertEquals(2L, employee.getDirection().getId());

		assertNotNull(employee.getCompany());
		assertEquals(1L, employee.getCompany().getId());
		
		session.close();
	}
	
}
