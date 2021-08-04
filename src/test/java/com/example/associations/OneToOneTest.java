package com.example.associations;

import static org.junit.jupiter.api.Assertions.*;

import org.hibernate.Session;
import org.junit.jupiter.api.Test;

import com.example.domain.Direction;
import com.example.domain.Employee;
import com.example.util.HibernateUtil;

public class OneToOneTest {

	@Test
	void save() throws Exception {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		
		Employee employee = new Employee(null, "Usuario Hibernate", "Lorem ipsum dolor", true);
		Direction direction = new Direction(null, "Calle falsa", "123", "Madrid", "Spain");
		
		session.beginTransaction();
		employee.setDirection(direction);
		
		session.save(direction); // Importante guardar la direccion
		session.save(employee);

		
		System.out.println(employee);
		
		session.getTransaction().commit();
		
		session.close();
	}
	
	
	@Test
	public void findEmployeeTest() throws Exception {
		

		Session session = HibernateUtil.getSessionFactory().openSession();

		Employee employee4 = session.find(Employee.class, 4L);

		System.out.println(employee4);
		assertNotNull(employee4);
		assertEquals(4L, employee4.getId());
		assertNotNull(employee4.getDirection());
		assertEquals(1L, employee4.getDirection().getId());
		assertEquals("Avenida independencia", employee4.getDirection().getStreet());

		session.close();
	}
	
	
	@Test
	void findDirection() throws Exception {
		
		Session session = HibernateUtil.getSessionFactory().openSession();

		Direction direction1 = session.find(Direction.class, 1L);

		System.out.println(direction1);
		assertNotNull(direction1);
		assertEquals(1L, direction1.getId());
		assertNotNull(direction1.getEmployee()); // bidireccional: el empleado existe
		assertEquals(4L, direction1.getEmployee().getId());

		session.close();
		
	}
	
	
	
}
