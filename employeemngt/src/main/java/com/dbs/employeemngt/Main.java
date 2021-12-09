package com.dbs.employeemngt;

import java.util.List;
import java.util.Optional;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dbs.employeemngt.config.Config;
import com.dbs.employeemngt.dto.Employee;
import com.dbs.employeemngt.repository.EmployeeRepository;
import com.dbs.employeemngt.service.EmployeeService;

public class Main {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);

		EmployeeService employeeService = applicationContext.getBean(EmployeeService.class);
		EmployeeService employeeService2 = applicationContext.getBean(EmployeeService.class);

		System.out.println(employeeService.hashCode());
		System.out.println(employeeService2.hashCode());
		System.out.println(employeeService.equals(employeeService2));
		System.out.println(employeeService == employeeService2);

		BasicDataSource basicDataSource = applicationContext.getBean("datasource", BasicDataSource.class);
		BasicDataSource basicDataSource2 = applicationContext.getBean("datasource", BasicDataSource.class);

		System.out.println(basicDataSource.equals(basicDataSource2));
		System.out.println(basicDataSource == basicDataSource2);

//		Employee emp = new Employee("ab002", "Annanya", "Bhandari", "Hyd", 500);
//		
//		Employee emp2 = employeeService.createEmployee(emp);
//		System.out.println(emp2);
//		Employee employee1=employeeService.deleteEmployee("ab002");

//		Optional<List<Employee>> optional = employeeService.getEmployees();
//		if (optional.isPresent()) {
//			optional.get();
//		} else {
//			System.out.println("record not found");
//		}
		employeeService.getEmployees().get().forEach(e -> System.out.println(e));
	}
}
