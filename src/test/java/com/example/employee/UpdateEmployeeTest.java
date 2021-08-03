package com.example.employee;

import org.hibernate.Session;
import org.junit.jupiter.api.Test;

import com.example.domain.Employee;
import com.example.util.HibernateUtil;

public class UpdateEmployeeTest {

	
	@Test
	void updateNewEmployee() throws Exception {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Employee employee = new Employee(null, "Ejemplo update", "Lorem ipsum dolor", false);
		
		session.beginTransaction();
		session.save(employee); // genera id
		
		employee.setFullName("Ejemplo update 2");

		session.getTransaction().commit(); // se actualiza en base de datos
		System.out.println(employee);
		
		session.close();
	}
	
	@Test
	void update1() throws Exception {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Employee employee1 = new Employee(1L, "Editado", "Editado", true);
		session.beginTransaction();
		// El metodo save esta creando uno nuevo en vez de actualizar porque no tiene en cuenta
		// que el Employee 1L ya existe en base de datos
		session.save(employee1);
		session.getTransaction().commit();
		
		session.close();

	}
	
	@Test
	void update2() throws Exception {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Employee employee1 = new Employee(1L, "Editado", "Editado", true);
		session.beginTransaction();
		// El metodo merge SÍ ACTUALIZA obtiene los datos del Employee 1L de base datos y le 
		// actualiza los campos por los datos que tu le pasas
		session.merge(employee1);
		session.getTransaction().commit();
		
		session.close();

	}
	
	@Test
	void dynamicUpdate() throws Exception {

		/*
		 * NOTA: descomentar la anotación @DynamicUpdate de la clase Employee para ver este test
		 */
		
		Session session = HibernateUtil.getSessionFactory().openSession();

		Employee employee1 = new Employee(1L, "Editado", "Lorem ipsum dolor", true); // cambia solo el fullname

		session.beginTransaction();

		session.merge(employee1); // visualizar en consola que solo update set de la columna full_name
		
		session.getTransaction().commit();
		
		session.close();

	}
	
	
	@Test
	void updateWithFind() throws Exception {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Employee employee1 = session.find(Employee.class, 1L);

		employee1.setFullName("Editado desde test updateWithFind");
		employee1.setMarried(false);
		
		session.beginTransaction();
		session.save(employee1); // en este caso el save SI ACTUALIZA porque hay un find previo que hace que la entity sea managed
		session.getTransaction().commit();
		
		session.close();

	}
	
}
