package com.ems.service;

import java.util.List;

import com.ems.entity.Employee;

public interface EmployeeService {
	
	List<Employee> getAllEmployee();
	
	Employee getEmployeeById(int id);
	
	Employee save(Employee emp);
	
	void deleteEmployee(int id);

}
