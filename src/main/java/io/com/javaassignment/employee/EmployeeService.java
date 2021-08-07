package io.com.javaassignment.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.com.javaassignment.department.Department;
import io.com.javaassignment.department.DepartmentRepository;

import java.util.*;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	public List<Employee> getAllEmployees() {
		List<Employee> employees =new ArrayList<>();
		employeeRepository.findAll().forEach(employees::add);
		return employees;
		
	}
	
	public Employee getEmployee(String id){
		
		return employeeRepository.findById(id).get();
		 
		
	}
	
	public void  addEmployee(Employee employee) {
		
		Department dept = departmentRepository.findById(employee.getDepartment().getDepartment_id()).orElse(null);
      
		if (dept == null) {
            dept = new Department();
            departmentRepository.save(employee.getDepartment());
            
        }
        dept.setDepartment_Name(employee.getDepartment().getDepartment_Name());
        dept.setDepartment_id(employee.getDepartment().getDepartment_id());
        employee.setDepartment(dept);

		employeeRepository.save(employee);
		
	}
	
	public void  updateEmployee(String id,Employee employee) {
		employeeRepository.save(employee);
		
	}
	
	public void deleteEmployee(String id) 
	{
		employeeRepository.deleteById(id);
	}
}
