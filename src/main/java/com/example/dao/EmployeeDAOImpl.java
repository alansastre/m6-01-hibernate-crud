package com.example.dao;


import org.hibernate.Session;

import com.example.domain.Employee;
import com.example.util.HibernateUtil;

public class EmployeeDAOImpl implements EmployeeDAO{

	@Override
	public Employee findOne(Long id) {
		// 1 - obtener la session
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		// 2 - Realizar la operacion CRUD
		// SELECT * FROM employees WHERE id = 1;
		Employee employee1 = session.find(Employee.class, 1L);
		// 3 - Cerrar session
		session.close();
		
		return employee1;
		

	}
	

}
