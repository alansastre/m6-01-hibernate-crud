package com.example.dao;

import java.util.List;

import com.example.domain.Employee;

public interface EmployeeDAO {

	// filtros
	Employee findOne(Long id);
	
	List<Employee> findAll();
	
	List<Employee> findAllGte18();
	
	// resto operaciones
	Employee save(Employee employee);
	
	Employee update(Employee employee);
	
	void deleteById(Long id);
	
	void delete(Employee employee);
}
