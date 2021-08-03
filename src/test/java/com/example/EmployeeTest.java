package com.example;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.hibernate.Session;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.domain.Employee;
import com.example.util.HibernateUtil;

/**
 * 		org.hibernate -- Hibernate
		javax.persistence -- JPA
		
		SessionFactory
		Session
 *
 */
public class EmployeeTest {

	@Test
	@DisplayName("Encontrar un Empleado por id")
	void findOne() throws Exception {
		
		// 1 - obtener la session
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		// 2 - Realizar la operacion CRUD
		// SELECT * FROM employees WHERE id = 1;
		Employee employee1 = session.find(Employee.class, 1L);

		System.out.println(employee1);
		assertNotNull(employee1);
		assertEquals(1L, employee1.getId());
		assertNotNull(employee1.getFullName());
		
		// 3 - Cerrar session
		session.close();
	}
	
	@Test
	@DisplayName("Encontrar un Empleado por id usando la cache de Hibernate")
	void findOneCache() throws Exception {
		
		Session session = HibernateUtil.getSessionFactory().openSession();

		Employee employee1 = session.find(Employee.class, 1L);

		System.out.println("======================================");
		
		// CACHE
		// session.evict(employee1); // evict descachea
		employee1 = session.find(Employee.class, 1L);
		
		session.close();
		
		System.out.println("======================================");
		
		session = HibernateUtil.getSessionFactory().openSession();
		
		// sin cache
		employee1 = session.find(Employee.class, 1L);
		
		session.close();
	}
	

	@Test
	@DisplayName("Encontrar todos los empleados")
	void findAll() throws Exception {
	
		// 1 - obtener la session
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		// 2 - Realizar la operacion CRUD
		// SELECT * FROM employees;
		String hql = "from Employee"; // se ejecuta la query sobre la entidad Employee
		
		List<Employee> employees = session.createQuery(hql, Employee.class).list();
		
		assertNotNull(employees);
		
		for (Employee employee : employees) {
			assertNotNull(employee.getId());
		}
		
		employees.forEach(employee -> assertNotNull(employee.getId()));
		
		// 3 - Cerrar session
		session.close();
	}
	
	
	// CRUD
	
	
	
	
	
	
}
