package com.dbs.employeemngt.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.dbs.employeemngt.dto.Employee;
import com.dbs.employeemngt.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Employee createEmployee(Employee employee) {
// TODO Auto-generated method stub
		return employeeRepository.createEmployee(employee);
	}

	@Override
	public Employee deleteEmployee(String empId) {
// TODO Auto-generated method stub
		return employeeRepository.deleteEmployee(empId);
	}

	@Override
	public Employee updateEmployee(String empId, Employee employee) {
// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Employee> getEmployeeById(String empId) {
// TODO Auto-generated method stub
//		String query = "select * from employee where empId=?";
//		return null;
		return employeeRepository.getEmployeeById(empId);
	}

	@Override
	public Optional<List<Employee>> getEmployees() {
// TODO Auto-generated method stub
//		String query = "select * from employee";
		return employeeRepository.getEmployees();
	}
}
