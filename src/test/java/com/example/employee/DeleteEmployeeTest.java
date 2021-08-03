package com.example.employee;

import static org.junit.jupiter.api.Assertions.*;

import org.hibernate.Session;
import org.junit.jupiter.api.Test;

import com.example.domain.Employee;
import com.example.util.HibernateUtil;

public class DeleteEmployeeTest {

	@Test
	void delete1() throws Exception {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		//Employee employee1 = new Employee(1L, "Employee 1", "Lorem ipsum dolor", true);
		
		// CONTROLADOR: DELETE /api/employee/1
		Employee employee1 = new Employee();
		employee1.setId(1L);

		session.beginTransaction();
		session.delete(employee1); // lo borra correctamente 
		
		session.getTransaction().commit();
		
		session.close();

	}
	
	@Test
	void deleteWithFind() throws Exception {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Employee employee1 = session.find(Employee.class, 1L);
		

		session.beginTransaction();
		session.delete(employee1); // lo borra correctamente 
		
		session.getTransaction().commit();
		
		session.close();
		
	}
	
	
}
