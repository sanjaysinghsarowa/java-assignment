package io.com.javaassignment.department;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	
	public List <Department> getAlldepartments(){
		
		List<Department> departments =new ArrayList<>();
		departmentRepository.findAll().forEach(departments::add);
		return departments;
		
	}
	
	public Department getDepartment(String department_id){
		
		return departmentRepository.findById(department_id).get();
		 
		
	}
	
	public void  addDepartment(Department department) {
		departmentRepository.save(department);
		
	}
	
	public void  updateDepartment(String department_id,Department department) {
		departmentRepository.save(department);
		
	}
	
	public void deleteDepartment(String department_id) 
	{
		departmentRepository.deleteById(department_id);
	}


}
