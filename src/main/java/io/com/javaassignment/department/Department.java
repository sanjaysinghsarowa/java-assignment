package io.com.javaassignment.department;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Department {
	
	@Id
	private String department_id;
	

	private String department_Name;

	public Department() {
//		super();
		// TODO Auto-generated constructor stub
	}
	
	public Department(String department_id, String department_Name) {
			super();
			this.department_id = department_id;
			this.department_Name = department_Name;
		}



		public String getDepartment_id() {
			return department_id;
		}
		
		public void setDepartment_id(String department_id) {
			this.department_id = department_id;
		}
		
		public String getDepartment_Name() {
			return department_Name;
		}
		
		public void setDepartment_Name(String department_Name) {
			this.department_Name = department_Name;
		}

}



