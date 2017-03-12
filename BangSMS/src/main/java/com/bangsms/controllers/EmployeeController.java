package com.bangsms.controllers;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bangsms.models.Employee;
import com.bangsms.services.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	final static Logger logger = Logger.getLogger(EmployeeController.class);

	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
		employee = employeeService.save(employee);
		return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Employee> getEmployee(@PathVariable("id") Long id){
		Employee employee = employeeService.getById(id);
		if(employee == null){
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Void> updateEmployee(@RequestBody Employee employee){
		Employee existingEmployee = employeeService.getById(employee.getId());
		if(existingEmployee == null){
			logger.debug("Employee with id "+employee.getId()+ " doesn't exist.");
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}else{
			employeeService.save(employee);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> getAllEmployees(){
		List<Employee> employees = employeeService.getAll();
		
		if(employees.isEmpty()){
			logger.debug("Employees doesn't exists.");
			return new ResponseEntity<List<Employee>>(HttpStatus.NO_CONTENT);
		}
		
		logger.debug("Found "+employees.size() + " employees.");
		logger.debug(employees);
		logger.debug(Arrays.toString(employees.toArray()));
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteEmployee(@PathVariable("id") Long id) {
		Employee employee = employeeService.getById(id);
		if (employee == null) {
			logger.debug("Employee with id " + id + " does not exists");
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			employeeService.delete(id);
			logger.debug("Employee with id " + id + " deleted");
			return new ResponseEntity<Void>(HttpStatus.GONE);
		}
	}
}
