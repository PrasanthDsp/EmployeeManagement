package com.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ems.entity.Employee;
import com.ems.service.EmployeeService;

import jakarta.persistence.EntityManager;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService empService;
	
	private EntityManager entityManager;
	
//	//get all employee
//	@Autowired
//	public EmployeeController(EmployeeService thisempService) {
//		super();
//		empService = thisempService;
//	}



	@GetMapping("/all")
	public List<Employee> getAll(){
		return empService.getAllEmployee();
	}
	
	@GetMapping("/{id}")
	public Employee getEmployee(@PathVariable int id ) {
		Employee emp = empService.getEmployeeById(id);
		if(emp==null) {
			throw new RuntimeException("Employee not found");
		}
		
		return emp;
	}
	
	@PostMapping("/new")
	public Employee addEmployee(@RequestBody Employee emp) {
		emp.setId(0);
		Employee newemp=empService.save(emp);
		
		return newemp;
	}
	
	@PutMapping("/{id}")
	public Employee updateEmployee(@RequestBody Employee emp,@PathVariable int id) {
		
//		Employee updateEmp = entityManager.find(Employee.class, id);
//				
//		updateEmp.setFirstName(emp.getFirstName());
//		updateEmp.setLastName(emp.getLastName());
//		updateEmp.setEmail(emp.getEmail());
		
		Employee emp1 =empService.save(emp);
		return emp1;
		
	}
	
	@DeleteMapping("/{id}")
	public String deleteEmployee(@PathVariable int id) {
		
		empService.deleteEmployee(id);
		
		return "Employee "+id+" is deleted successfully";
	}

}
