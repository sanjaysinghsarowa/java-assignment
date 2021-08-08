package io.com.javaassignment.employee;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.com.javaassignment.department.Department;

@RestController
public class EmployeeController {

	
	@Autowired
	private EmployeeService employeeService;
	
	
	
	/*
	 * Method Name - getCustomEmployees.
	 * Method description- To get list of employees have 3 or more skills and sorted by lastName.
	 * Created By - Sanjay Singh Sarowa
	 * 
	 * */
	@RequestMapping("/customEmployees")
	public List<Employee> getCustomEmployees(){
		List<Employee> list=getAllEmployees();
		Collections.sort(list,(p1,p2)->{  
	        return p1.getLastName().compareTo(p2.getLastName());  
	        });  
		List<Employee> result=list.stream().filter(p -> p.getSkills().split(",").length >= 3).collect(Collectors.toList());
  
		return result;
		
	}
	
	
	
	/*
	 * Method Name - getEmployeeAndDeptIdString.
	 * Method description- returns a list of  string using LastName and department_id of employees whose salary is >=5000 and Department name is 'Devshop' or 'Engg'.
	 * Created By - Sanjay Singh Sarowa
	 * 
	 * */
	
	@RequestMapping("/employeesAndDeptId")
	public List<String> getEmployeeAndDeptIdString(){
		List<Employee> list=getAllEmployees();
		list=list.stream().filter(p -> Integer.parseInt(p.getSalary()) >= 5000 ).collect(Collectors.toList());
		list=list.stream().filter(p1-> p1.getDepartment().getDepartment_Name().equalsIgnoreCase("devshop")||p1.getDepartment().getDepartment_Name().equalsIgnoreCase("engg")).collect(Collectors.toList());
		 
		
		Map <Employee, Department> map= new HashMap<Employee, Department>();

		 for(Employee e:list)
		{
			map.put(e,e.getDepartment());
		}
		
		List<String> result=new ArrayList<String>();
		
		for(Map.Entry m:map.entrySet()){
			String lname=((Employee) m.getKey()).getLastName();
			String dept_id=((Department) m.getValue()).getDepartment_id();
			   result.add(lname +" - "+dept_id );  
			  }
		 return result;
		
	}
	
	
	@RequestMapping("/employees")
	public List<Employee> getAllEmployees(){
		
		return employeeService.getAllEmployees();
	}
	
	@RequestMapping("/employees/id")
	public Employee getEmployee(@PathVariable String id) {
		return employeeService.getEmployee(id);
		
	}
	
	@RequestMapping(method = RequestMethod.POST,value="/employees")
	public void addEmployee(@RequestBody Employee employee ) {
		employeeService.addEmployee(employee);
	}
	
	@RequestMapping(method = RequestMethod.PUT,value="/employees/{id}")
	public void UpdateEmployee(@RequestBody Employee employee, @PathVariable String id ) {
		employeeService.updateEmployee(id,employee);
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value="/employees/{id}")
	public void DeleteEmployee(@PathVariable String id ) {
		employeeService.deleteEmployee(id);
	}
}
