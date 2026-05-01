package com.brhmkskn.controller;

import java.util.List;

import org.apache.el.parser.AstFalse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.brhmkskn.model.Employee;
import com.brhmkskn.model.UpdateEmployeeRequest;
import com.brhmkskn.services.EmployeeService;

@RestController
@RequestMapping("/rest/api/employee")
public class RestEmployeeController {

	@Autowired
	private EmployeeService _employeeService;
	
	@GetMapping(path = "/list")
	public List<Employee> getAllEmployeeList()
	{
		return _employeeService.getEmployeeList();
	}
	@GetMapping(path = "/{id}")
	public Employee getEmployeeById(@PathVariable(name ="id",required = true) String id)
	{
		return _employeeService.getEmployeeById(id);
	}
	@GetMapping(path = "/with-params")
	public List<Employee> getEmployeeWithParams(@RequestParam(name ="firstName",required = false) String firstname,
										@RequestParam(name ="lastName",required = false) String lastname
			 )
	{
		System.out.println(firstname +' '+ lastname);
		return _employeeService.getEmployeeWithParams(firstname, lastname);
	}
	@PostMapping(path = "/")
	public Employee SaveEmployee(@RequestBody Employee newEmployee)
	{
		return _employeeService.saveEmployee(newEmployee);
	}
	@PutMapping(path = "/{id}")
	public Employee DeleteEmployee(@PathVariable(name ="id",required = true) String id, @RequestBody UpdateEmployeeRequest request)
	{
		return _employeeService.updateEmployee(id,request);
	}
	@DeleteMapping(path = "/{id}")
	public boolean DeleteEmployee(@PathVariable(name ="id",required = true) String id)
	{
		return _employeeService.deleteEmployeeById(id);
	}
}
