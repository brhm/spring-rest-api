package com.brhmkskn.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.brhmkskn.model.Employee;

@Configuration
public class AppConfig {

	@Bean
	public List<Employee> employeeList(){
		List<Employee> employeeList=new ArrayList<>();
		employeeList.add(new Employee("1","ibrahim","Keskin"));
		employeeList.add(new Employee("2","Medya","Aydın"));
		employeeList.add(new Employee("3","Sarya","Keskin"));
		employeeList.add(new Employee("4","Süleyman","Keskin"));
		
		return employeeList;
	}
}
