
package com.dbs.employeemngt.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.dbs.employeemngt.dto.Employee;
import com.dbs.employeemngt.mapper.EmployeeRowMapper;
import com.google.protobuf.Empty;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public Employee createEmployee(Employee employee) {
// TODO Auto-generated method stub
		String insertStatement = "insert into employee(empId,empFirstName,empLastName,address,empsalary)"
				+ "values(?,?,?,?,?)";
		int result = jdbcTemplate.update(insertStatement, employee.getEmpId(), employee.getEmpFirstName(),
				employee.getEmpLastName(), employee.getAddress(), employee.getEmpSalary());
		if (result > 0)
			return employee;
		else
			return null;
	}

	@Override
	public Employee deleteEmployee(String empId) {
// TODO Auto-generated method stub
		String delstatement = "delete from employee where empId=?";
		jdbcTemplate.update(delstatement, empId);
		return null;
	}

	@Override
	public Employee updateEmployee(String empId, Employee employee) {
// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Employee> getEmployeeById(String empId) {
		String query = "select * from employee where empId =?";
		Employee employee = jdbcTemplate.queryForObject(query, new EmployeeRowMapper(), empId);
		System.out.println(employee);
		if (employee != null) {
			return Optional.of(employee);
		} else {
			return Optional.empty();
		}
	}

	@Override
	public Optional<List<Employee>> getEmployees() {

		String query = "select * from employee";
		List<Employee> list = jdbcTemplate.query(query, new EmployeeRowMapper());
		System.out.println(list + " details");
		if (!list.isEmpty()) {
			return Optional.of(list);
		} else {
			return Optional.empty();
		}
	}
}
