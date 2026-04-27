package com.brhmkskn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brhmkskn.model.Employee;
import com.brhmkskn.services.EmployeeService;

@RestController
@RequestMapping("/rest/api")
public class RestEmployeeController {

	@Autowired
	private EmployeeService _employeeService;
	
	@GetMapping(path = "/employee-list")
	public List<Employee> getAllEmployeeList()
	{
		return _employeeService.getEmployeeList();
	}
}
