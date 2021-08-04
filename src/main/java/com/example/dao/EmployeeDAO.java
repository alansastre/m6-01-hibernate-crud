package com.example.dao;

import java.util.List;

import com.example.domain.Employee;

public interface EmployeeDAO {

	Employee findOne(Long id);
	
	List<Employee> findAll();
	
	Employee save(Employee employee);
	
	Employee update(Employee employee);
	
	void deleteById(Long id);
	
	void delete(Employee employee);
}
