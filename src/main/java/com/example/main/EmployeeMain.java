package com.example.main;


import java.util.List;

import org.hibernate.Session;

import com.example.domain.Employee;
import com.example.util.HibernateUtil;

public class EmployeeMain {

	
	public static void main(String[] args) {
		
		// concepto 1
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		// 2 - Realizar la operacion CRUD
		// SELECT * FROM employees;
		String hql = "from Employee"; // se ejecuta la query sobre la entidad Employee
		
		List<Employee> employees = session.createQuery(hql, Employee.class).list();

		System.out.println(employees);
		
		// 3 - Cerrar session
		session.close();
		
		// concepto 2
		// concepto 3
		// concepto 4
		// concepto 5
		// concepto 6
		// concepto 2
		
		
	}
}
