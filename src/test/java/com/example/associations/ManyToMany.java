package com.example.associations;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Arrays;

import org.hibernate.Session;
import org.junit.jupiter.api.Test;

import com.example.domain.Company;
import com.example.domain.Employee;
import com.example.domain.Project;
import com.example.util.HibernateUtil;

public class ManyToMany {

	@Test
	void save() throws Exception {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Employee employee = new Employee(null, "Usuario Hibernate", "Lorem ipsum dolor", true);
		Project project1 = new Project(null, "Proyecto ManyToMany 1", "PRJ1");
		Project project2 = new Project(null, "Proyecto ManyToMany 2", "PRJ2");
		Project project3 = new Project(null, "Proyecto ManyToMany 3", "PRJ3");

		// asociacion
		employee.setProjects(Arrays.asList(project1, project2, project3));

		session.beginTransaction();

		session.save(project1);
		session.save(project2);
		session.save(project3);
		session.save(employee);

		System.out.println(employee);

		session.getTransaction().commit();

		session.close();

	}
	
	
	@Test
	void findEmployee() throws Exception {
		
		Session session = HibernateUtil.getSessionFactory().openSession();


		Employee employee = session.find(Employee.class, 7L);
		
		System.out.println(employee);
		assertNotNull(employee);
		assertEquals(7L, employee.getId());


		assertNotNull(employee.getProjects());
		assertEquals(3, employee.getProjects().size());
		
		Employee employee8 = session.find(Employee.class, 8L);
		
		assertNotNull(employee8.getProjects());
		assertEquals(2, employee8.getProjects().size());
		
		session.close();
	}
	
	@Test
	void findProject() throws Exception {
		
		Session session = HibernateUtil.getSessionFactory().openSession();

		// ================ PROJECT 1 (2 EMPLEADOS)
		Project project1 = session.find(Project.class, 1L);
		
		System.out.println(project1);
		assertNotNull(project1);
		assertEquals(1L, project1.getId());


		assertNotNull(project1.getEmployees()); // bidireccional
		assertEquals(2, project1.getEmployees().size());
		
		// ================ PROJECT 3 (1 EMPLEADO)
		
		Project project3 = session.find(Project.class, 3L);
		
		System.out.println(project3);
		assertNotNull(project3);
		assertEquals(3L, project3.getId());

		assertNotNull(project3.getEmployees()); // bidireccional
		assertEquals(1, project3.getEmployees().size());
		
		session.close();
		
	}
	
	
	
	
}
