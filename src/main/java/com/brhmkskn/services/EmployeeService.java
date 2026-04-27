package com.brhmkskn.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brhmkskn.model.Employee;
import com.brhmkskn.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository _employeeRepository;
	public List<Employee> getEmployeeList()
	{		
		return _employeeRepository.getAllEmployeeList();
	}
}
