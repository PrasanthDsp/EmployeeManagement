package com.ems.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ems.dao.EmployeeDAOJpa;
import com.ems.entity.Employee;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	
	private EmployeeDAOJpa employeeDao;
	
	
	public EmployeeServiceImpl(EmployeeDAOJpa empDao) {
		super();
		employeeDao = empDao;
	}



	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return employeeDao.findAll();
	}



	@Override
	@Transactional
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		return employeeDao.findById(id);
	}



	@Override
	@Transactional
	public Employee save(Employee emp) {
		// TODO Auto-generated method stub
		return employeeDao.save(emp);
	}



	@Override
	@Transactional
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		employeeDao.delete(id);
	}

}
