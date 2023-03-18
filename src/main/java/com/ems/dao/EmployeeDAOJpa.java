package com.ems.dao;

import java.util.List;

import com.ems.entity.Employee;

public interface EmployeeDAOJpa {

	List<Employee> findAll();

	Employee findById(int id);

	Employee save(Employee myemp);

	void delete(int id);
}
