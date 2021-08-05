package com.example.queries;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;


import org.hibernate.Session;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.dao.EmployeeDAO;
import com.example.dao.EmployeeDAOImpl;
import com.example.domain.Employee;
import com.example.util.HibernateUtil;

public class HQLTest {

	
	@Test
	@DisplayName("Encontrar todos los empleados")
	void findAll() throws Exception {
	

		Session session = HibernateUtil.getSessionFactory().openSession();

		String hql = "from Employee";
		
		List<Employee> employees = session.createQuery(hql, Employee.class).list();
		
		assertNotNull(employees);
		
		for (Employee employee : employees) 
			assertNotNull(employee.getId());

		session.close();
	}
	
	@Test
	void findOneWithNamedParameter() throws Exception {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		// parametro por nombre: named parameter
		String hql = "from Employee where id = :id";
		
		TypedQuery<Employee> query1 = session.createQuery(hql, Employee.class);
		// Query query2 = session.createQuery(hql); // otra opcion
		query1.setParameter("id", 1L);
		Employee employee = query1.getSingleResult();
		
		assertNotNull(employee);
		
		assertEquals(1L, employee.getId());

		session.close();
		
		
	}
	
	@Test
	void findOneWithPositionParameter() throws Exception {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		// parametro por nombre: named parameter
		String hql = "from Employee where id = ?1";
		
		TypedQuery<Employee> query1 = session.createQuery(hql, Employee.class);
		// Query query2 = session.createQuery(hql); // otra opcion
		query1.setParameter(1, 1L);
		Employee employee = query1.getSingleResult();
		
		System.out.println(employee);
		assertNotNull(employee);
		
		assertEquals(1L, employee.getId());

		session.close();
		
		
	}
	
	@Test
	void findAllIn() throws Exception {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		String hql = "from Employee where id in :ids and age in :ages";
		 
		TypedQuery<Employee> query1 = session.createQuery(hql, Employee.class);

		query1.setParameter("ids", Arrays.asList(2L, 3L, 1L)); // se cumplen los 3 casos
		query1.setParameter("ages", Arrays.asList(26, 20, 40)); // se cumple solo 1 caso
		// el filtro total solo lo cumple 1 empleado
		
		List<Employee> employees = query1.getResultList();
		
		assertNotNull(employees);
		assertEquals(1L, employees.size());

		session.close();
		
		
	}
	
	@Test
	public void findAllBetween() throws Exception {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		String hql = "from Employee where age >= :age1 and age <= :age2";
		
		Query query = session.createQuery(hql);
		query.setParameter("age1", 20);
		query.setParameter("age2", 40);
		List<Employee> employees = query.getResultList();
		
		System.out.println(employees);
		assertNotNull(employees);
		
		assertEquals(3L, employees.size());

		session.close();
	}
	
	
	@Test
	public void countEmployees() throws Exception {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		// String hql = "select count(*) from Employee";
		String hql = "select count(e) from Employee e";
		
		Query query = session.createQuery(hql);
		Long totalEmployees = (Long) query.getSingleResult();
		
		assertEquals(8L, totalEmployees);

		session.close();
	}

	
	@Test
	public void findProjection() throws Exception {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		

		String hql = "select e.fullName, e.age from Employee e";
		

		List<Employee> employees = session.createQuery(hql).getResultList();
		
		assertEquals(8L, employees.size());
		System.out.println(employees);
		
//		for (Employee employee : employees) {
//			System.out.println("Nombre" + employee.getFullName() + ", Edad: " + employee.getAge());
//		}

		session.close();
	}
	
	
	@Test
	void findWithNamedQuery() throws Exception {
		
		Session session = HibernateUtil.getSessionFactory().openSession();

		List<Employee> employees = session.createNamedQuery("findAllEmployees").getResultList();
		
		System.out.println(employees);
		
		employees = session.createNamedQuery("findAllEmployeesGte18").getResultList();
		
		System.out.println(employees);
		assertEquals(4L, employees.size());
		
		session.close();
	}
	
	@Test
	void findWithNamedQueryFromDAO() throws Exception {
		
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		List<Employee> employees = employeeDAO.findAllGte18();
		assertEquals(4L, employees.size());
	}
	
	
	
	
	
	
	
	
}
