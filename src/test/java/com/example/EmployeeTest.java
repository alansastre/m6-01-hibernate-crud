package com.example;

import static org.junit.jupiter.api.Assertions.*;

import org.hibernate.Session;
import org.junit.jupiter.api.Test;

import com.example.util.HibernateUtil;

public class EmployeeTest {

	@Test
	void test1() throws Exception {
		
		// 1 - obtener la session
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		// 2 - Realizar la operacion CRUD
		

		// 3 - Cerrar session
		session.close();
	}
	
	
	
	
	
	@Test
	void test2() throws Exception {
		
	}
	
}
