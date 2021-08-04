package com.example.associations;

import static org.junit.jupiter.api.Assertions.*;

import org.hibernate.Session;
import org.junit.jupiter.api.Test;

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
		
		session.beginTransaction();

		
		session.save(employee);

		
		System.out.println(employee);
		
		session.getTransaction().commit();
		
		session.close();
	}
	
}
