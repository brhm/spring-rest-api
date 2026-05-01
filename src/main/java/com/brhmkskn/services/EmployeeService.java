package com.brhmkskn.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brhmkskn.model.Employee;
import com.brhmkskn.model.UpdateEmployeeRequest;
import com.brhmkskn.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository _employeeRepository;
	public List<Employee> getEmployeeList()
	{		
		return _employeeRepository.getAllEmployeeList();
	}
	public Employee getEmployeeById(String id)
	{		
		return _employeeRepository.getEmployeeById(id);
	}
	
	public List<Employee> getEmployeeWithParams(String firstname, String lastname)
	{		
		return _employeeRepository.getEmployeeWithParams(firstname, lastname);
	}
	public Employee saveEmployee(Employee newEmployee) 
	{		
		return _employeeRepository.saveEmployee(newEmployee);
	}
	public Employee updateEmployee(String id, UpdateEmployeeRequest updateEmployee) 
	{		
		return _employeeRepository.updateEmployee(id, updateEmployee);
	}
	public boolean deleteEmployeeById(String id)
	{		
		return _employeeRepository.deleteEmployeeById(id);
	}
}
