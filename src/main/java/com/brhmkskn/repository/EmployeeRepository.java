package com.brhmkskn.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.brhmkskn.model.Employee;
import com.brhmkskn.model.UpdateEmployeeRequest;

import ch.qos.logback.classic.model.processor.LogbackClassicDefaultNestedComponentRules;

@Repository
public class EmployeeRepository {

	@Autowired
	private List<Employee> employeeList;
	
	public List<Employee> getAllEmployeeList() {
		
		//List<Employee> list=
		
		return employeeList;
	}
  public Employee getEmployeeById(String id) {
		
		Employee findEmployee=null;
		for (Employee employee: employeeList) {
			if(id.equals(employee.getId()))
			{	findEmployee=employee;
				break;
			}
			
		}
		
		return findEmployee;
	}
  public List<Employee> getEmployeeWithParams(String firstname,String lastname) {
		
	  List<Employee> employees=new ArrayList<>();
	  if(firstname==null && lastname==null)
		  return employeeList;
	  
	  
		for (Employee employee: employeeList) {
			if(firstname!=null && lastname!=null)
			{	if(employee.getFirstName().equalsIgnoreCase(firstname) &&
					employee.getLastName().equalsIgnoreCase(lastname))
				{
				 employees.add(employee);
				}
			}
			if(firstname!=null && lastname==null)
			{	if(employee.getFirstName().equalsIgnoreCase(firstname))
				{
				 employees.add(employee);
				}
			}
			if(firstname==null && lastname!=null)
			{	if(employee.getLastName().equalsIgnoreCase(lastname))
				{
				 employees.add(employee);
				}
			}
		}
		
		return employees;
	}
  public Employee saveEmployee(Employee newEmployee) {
		
		if(newEmployee.getId()!=null && newEmployee.getFirstName()!=null && newEmployee.getLastName()!=null)
		{
			employeeList.add(newEmployee);
		}
		return newEmployee;
	}
  private Employee findEmployeeById(String id) {
	  Employee findEmployee=null;
		for (Employee employee: employeeList) {
			if(id.equals(employee.getId()))
			{	findEmployee=employee;
				break;
			}
			
		}
		
		return findEmployee;
	
}
  public Employee updateEmployee(String id,UpdateEmployeeRequest request) {
		
		Employee findEmployee=findEmployeeById(id);
		if(findEmployee!=null)
		{
			deleteEmployeeById(id);
			
			Employee updateEmployee=new Employee();
			updateEmployee.setId(id);
			updateEmployee.setFirstName(request.getFirstName());
			updateEmployee.setLastName(request.getLastName());
			
			employeeList.add(updateEmployee);
			return updateEmployee;
		}
		
		
		return null;
	}
  public boolean deleteEmployeeById(String id) {
		
		Employee findEmployee=null;
		for (Employee employee: employeeList) {
			if(id.equals(employee.getId()))
			{	findEmployee=employee;
				break;
			}
			
		}
		
		return employeeList.remove(findEmployee);
	}
}
