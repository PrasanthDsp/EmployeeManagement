package com.ems.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ems.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAOJpa {
	
	private EntityManager entityManager;
	
	

	@Autowired
	public EmployeeDAOJpaImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}




	@Override
	public List<Employee> findAll() {

		//create a query
		TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);
		//execute query and get result list
		List<Employee> empList = theQuery.getResultList();
		//return the results
		return empList;
	}




	@Override
	public Employee findById(int empid) {
		// TODO Auto-generated method stub
//		TypedQuery<Employee> findById = entityManager.createQuery("from Employee where id=:empid",Employee.class);
		Employee emp =entityManager.find(Employee.class, empid);
		return emp;
	}




	@Override
	public Employee save(Employee myemp) {
		// TODO Auto-generated method stub
		
		Employee dbEmployee =entityManager.merge(myemp);
		return dbEmployee;
	}




	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		Employee emp1=entityManager.find(Employee.class, id);
		entityManager.remove(emp1);
	}

}
