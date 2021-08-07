package io.com.javaassignment.department;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	
	@RequestMapping("/departments")
	public List<Department> getAlldepartments(){
		
		return departmentService.getAlldepartments();
	}
	
	@RequestMapping("/departments/department_id")
	public Department getDepartment(@PathVariable String department_id) {
		return departmentService.getDepartment(department_id);
		
	}
	
	@RequestMapping(method = RequestMethod.POST,value="/departments")
	public void addDepartment(@RequestBody Department department ) {
		departmentService.addDepartment(department);
	}
	
	@RequestMapping(method = RequestMethod.PUT,value="/departments/{department_id}")
	public void UpdateDepartment(@RequestBody Department department, @PathVariable String department_id ) {
		departmentService.updateDepartment(department_id,department);
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value="/departments/{id}")
	public void DeleteDepartment(@PathVariable String department_id ) {
		departmentService.deleteDepartment(department_id);
	}
	
	
}
