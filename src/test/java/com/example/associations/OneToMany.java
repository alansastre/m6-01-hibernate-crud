package com.example.associations;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import javax.persistence.FetchType;

import org.hibernate.Session;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.domain.Company;
import com.example.domain.Direction;
import com.example.domain.Employee;
import com.example.util.HibernateUtil;

public class OneToMany {

	
	@Test
	void save() throws Exception {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		
		Employee employee1 = new Employee(null, "Emp1 empresa", "Lorem ipsum dolor", true);
		Employee employee2 = new Employee(null, "Emp2 empresa", "Lorem ipsum dolor", true);
		
		Company company = new Company(null, "Empresa OneToMany", "B122342", LocalDate.now(), 3500d);
		
		// asociacion
		employee1.setCompany(company);
		employee2.setCompany(company);
		
		session.beginTransaction();

		
		session.save(company);
		session.save(employee1);
		session.save(employee2);

		
		System.out.println(employee1);
		
		session.getTransaction().commit();
		
		session.close();
	}
	
	
	@Test
	@DisplayName("Sin EAGER dentro de la misma sesion SI se recuperan los employees")
	void findCompany() throws Exception {
		
		Session session = HibernateUtil.getSessionFactory().openSession();

		Company company1 = session.find(Company.class, 1L);

		System.out.println(company1);
		assertNotNull(company1);
		assertEquals(1L, company1.getId());
		assertNotNull(company1.getEmployees()); // bidireccional
		assertEquals(2, company1.getEmployees().size());
		assertEquals(5l, company1.getEmployees().get(0).getId());
		assertEquals(6l, company1.getEmployees().get(1).getId());

		session.close();
		
	}
	
	@Test
	@DisplayName("Sin EAGER y cerrando sesion se produce LaxyInitializationException")
	void findCompany2() throws Exception {
		
		Session session = HibernateUtil.getSessionFactory().openSession();

		Company company1 = session.find(Company.class, 1L);
		session.close();
		
		/*
		 * Si fetch = FetchType.EAGER la lista de employees se carga 
		 * al comienzo y por tanto no hay fallo
		 * 
		 * Si fetch = FetchType.LAZY (por defecto) entonces hay LazyInitializationException
		 * por intentar acceder a una coleccion que no se ha cargado aún
		 */
		System.out.println(company1);
		assertNotNull(company1);
		assertEquals(1L, company1.getId());
		assertNotNull(company1.getEmployees()); // bidireccional
		assertEquals(2, company1.getEmployees().size());
		assertEquals(5l, company1.getEmployees().get(0).getId());
		assertEquals(6l, company1.getEmployees().get(1).getId());

		
		
	}
	
	
	@Test
	@DisplayName("Sin EAGER refrescar en una nueva sesion")
	void findCompany3() throws Exception {
		
		Session session = HibernateUtil.getSessionFactory().openSession();

		Company company1 = session.find(Company.class, 1L);
		session.close(); // se limpia el contexto de persistencia
		
		// ===================== NUEVA SESION =========================
		session = HibernateUtil.getSessionFactory().openSession(); // se abre nuevo contexto de persistencia
		session.refresh(company1); // recarga la entidad en el nuevo contexto de persistencia
	
		System.out.println(company1);
		assertNotNull(company1);
		assertEquals(1L, company1.getId());
		assertNotNull(company1.getEmployees()); // bidireccional
		assertEquals(2, company1.getEmployees().size());
		assertEquals(5l, company1.getEmployees().get(0).getId());
		assertEquals(6l, company1.getEmployees().get(1).getId());
		session.close();
		
		
	}
	
	
	
	
	
	
	
	
	
	
}
