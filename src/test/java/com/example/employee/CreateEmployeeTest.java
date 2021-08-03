package com.example.employee;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.hibernate.Session;
import org.junit.jupiter.api.Test;

import com.example.domain.Employee;
import com.example.util.HibernateUtil;

public class CreateEmployeeTest {

	@Test
	void create() throws Exception {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		// transient entity
		Employee employee = new Employee(null, "Usuario Hibernate", "Lorem ipsum dolor", false);
		
		session.save(employee);
		
		System.out.println(employee);
		
		session.close();
		
	}
	
	@Test
	void createWithTransactionCommit() throws Exception {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		// transient entity
		Employee employee = new Employee(null, "Usuario Hibernate 2", "Lorem ipsum dolor", false);
		
		session.beginTransaction();
		
		session.save(employee);
		
		session.getTransaction().commit(); // hace efectivos los cambios
		//session.getTransaction().rollback(); // deshace cambios se utiliza normalmente dentro de un catch
		
		session.close();
		
	}
	
	
	@Test
	void createWithTransactionRollback() throws Exception {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		// transient entity
		Employee employee = new Employee(null, "Usuario Hibernate 3", "Lorem ipsum dolor", false);
		
		session.beginTransaction();
		
		session.save(employee);
		
		session.getTransaction().rollback();
		
		Employee employee2 = new Employee(null, "Usuario Hibernate 4", "Lorem ipsum dolor", false);

		session.beginTransaction();
		
		session.save(employee2);
		
		session.getTransaction().commit(); // hace efectivos los cambios, el id continua hacia delante y no se resetea
		
		System.out.println(employee);
		
		session.close();
		
	}
	
	@Test
	void createCheckId() throws Exception {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Employee employee = new Employee(null, "Usuario Hibernate 3", "Lorem ipsum dolor", false);

		Long id = (Long) session.save(employee);
		
		System.out.println(id);
		System.out.println(employee.getId());
		
		assertEquals(id, employee.getId());
		session.close();

	}
}
