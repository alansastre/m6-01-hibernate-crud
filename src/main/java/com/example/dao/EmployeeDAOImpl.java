package com.example.dao;


import java.util.List;

import org.hibernate.Session;

import com.example.domain.Employee;
import com.example.util.HibernateUtil;

public class EmployeeDAOImpl implements EmployeeDAO{

	@Override
	public Employee findOne(Long id) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Employee employee1 = session.find(Employee.class, id);

		session.close();
		
		return employee1;

	}

	@Override
	public List<Employee> findAll() {

		Session session = HibernateUtil.getSessionFactory().openSession();
				
		List<Employee> employees = session.createQuery("from Employee", Employee.class).list();
		
		session.close();
		
		return employees;
	}

	@Override
	public Employee save(Employee employee) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		
		try {
			session.beginTransaction();
			session.save(employee);
			session.getTransaction().commit(); 
			return employee;
		} catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		finally {
			session.close();
		}
		return null;

	}

	@Override
	public Employee update(Employee employee) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		try {
			session.beginTransaction();
			session.merge(employee);
			session.getTransaction().commit(); 
			return employee;
		} catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		finally {
			session.close();
		}
		return null;
	}

	@Override
	public void deleteById(Long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		try {
			session.beginTransaction();
			session.delete(session.find(Employee.class, 1L));
			session.getTransaction().commit(); 
		} catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		finally {
			session.close();
		}
		
	}

	@Override
	public void delete(Employee employee) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		try {
			session.beginTransaction();
			session.delete(employee);
			session.getTransaction().commit(); 
		} catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		finally {
			session.close();
		}		
	}
	

}
