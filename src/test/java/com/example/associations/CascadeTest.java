package com.example.associations;

import org.hibernate.Session;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.domain.Direction;
import com.example.domain.Employee;
import com.example.util.HibernateUtil;

public class CascadeTest {

	@Test
	public void save() throws Exception {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		
		Employee employee = new Employee(null, "Usuario Cascada", "Lorem ipsum dolor", true);
		Direction direction = new Direction(null, "Calle falsa", "123", "Madrid", "Spain");
		employee.setDirection(direction);
		
		
		session.beginTransaction();
		
		// session.save(direction); // con CASCADE.ALL no hace falta guardar la direccion
		session.save(employee);

		
		System.out.println(employee);
		
		session.getTransaction().commit();
		
		session.close();
	}
	
	@Test
	public void deleteEmployee() throws Exception {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Employee employee = session.find(Employee.class, 4L);
		
		session.beginTransaction();
		
		// con CASCADE.ALL se borra tambien la direccion
		// sin CASCADE.ALL se conserva la direccion
		session.delete(employee.getDirection());
		session.delete(employee);

		
		session.getTransaction().commit();
		
		
		session.close();
	}
	
	
	@Test
	@DisplayName("Borrar Direction y borrar Employee automaticamente con cascade.all")
	public void deleteDirectionCascade() throws Exception {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Direction direction = session.find(Direction.class, 1L);
		
		session.beginTransaction();
		
		session.delete(direction); // al tener CASCADE la direccion se borra tambien el Employee
		
		session.getTransaction().commit();
		
		
		session.close();
	}
	
	
	@Test
	@DisplayName("Desasociar Employee de Direction: Borrar Direction y conservar Employee")
	public void deleteDirectionWithoutCascade() throws Exception {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Direction direction = session.find(Direction.class, 1L);
		Employee employee = session.find(Employee.class, 4L);
		
		employee.setDirection(null);
		
		session.beginTransaction();
		
		session.save(employee);
		session.delete(direction); // al tener CASCADE la direccion se borra tambien el Employee
		
		session.getTransaction().commit();
		
		
		session.close();
	}
	
}
