package com.example.dao;

import com.example.domain.Employee;

public interface EmployeeDAO {

	Employee findOne(Long id);
	
}
