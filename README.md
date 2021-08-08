# java-assignment


**Requirements**:-
1. Return List<Employee> having skills >=3 and list should be sorted as per last name of employee.
2. Create Map<Employee, Department> for all employees whose salary is >=5000 and Department name is 'Devshop' or 'Engg'. Using this map, create a string - "empLastName - deptId" and store it in list. Eg: List<String> result might contain data like:-
singh - 1001
sharma - 1002

**Implementation:-**
  
1. Implementation code written in EmployeeController class, 
	 
	method name- getCustomEmployees()
	
	Return Type -list
	
	Request-@RequestMapping("/customEmployees")
	
**For Input**:
	
Using Postman ,make a Rest API call 
	request Type- POST 
	
	URL-http://localhost:8090/employees
	
	Input Data Type(In JSON Format)-  

Input 1:-

	{
        "id": "1",
        "firstName": "Jane",
        "lastName": "Doe",
        "salary": "900",
        "skills": "java,c++",
        "department": {
            "department_id": "2",
            "department_Name": "devshop"
        }
    }
Input 2:-
	
	{
		"id": "2",
		"firstName": "nick",
		"lastName":  "E",
		"salary": "90000",
		"skills":"java,c++,python",
		"department": {
			"department_id": "4",
			"department_Name": "engg"
		
		}

	}
	
	
	
Input 3:-	

	{
        "id": "3",
        "firstName": "kevin",
        "lastName": "A",
        "salary": "90000",
        "skills": "java,c++,python,c",
        "department": {
            "department_id": "5",
            "department_Name": "IT"
        }
    }
	
	
Input 4:-
	
	{
        "id": "4",
        "firstName": "John",
        "lastName": "C",
        "salary": "90000",
        "skills": "Spring,java,c++,python,c",
        "department": {
            "department_id": "2",
            "department_Name": "devshop"
        }
    }

	

For Ouput:

	Using Postman ,make a Rest API call 
				request Type- GET 
				URL-http://localhost:8090/customEmployees
Ouput:-

	[
    {
        "id": "3",
        "firstName": "kevin",
        "lastName": "A",
        "salary": "90000",
        "skills": "java,c++,python,c",
        "department": {
            "department_id": "5",
            "department_Name": "IT"
        }
    },
    {
        "id": "4",
        "firstName": "John",
        "lastName": "C",
        "salary": "90000",
        "skills": "Spring,java,c++,python,c",
        "department": {
            "department_id": "2",
            "department_Name": "devshop"
        }
    },
    {
        "id": "2",
        "firstName": "nick",
        "lastName": "E",
        "salary": "90000",
        "skills": "java,c++,python",
        "department": {
            "department_id": "4",
            "department_Name": "engg"
        }
    }
	]




2. Implementation code written in EmployeeController class, 
			
	method name- getEmployeeAndDeptIdString()
	
	Return Type -list<String>
		
	Request-@RequestMapping("/employeesAndDeptId")

For input:
		
	Using Postman ,make a Rest API call 
	
	request Type- POST 
	
	URL-http://localhost:8090/employees
	
	Input Data Type(In JSON Format)-  

Input 1:-

	{
						"id": "1",
						"firstName": "Jane",
						"lastName": "Doe",
						"salary": "900",
						"skills": "java,c++",
						"department": {
								"department_id": "2",
								"department_Name": "devshop"
						}
				}
		
Input 2:-
			
	{
				"id": "2",
				"firstName": "nick",
				"lastName":  "E",
				"salary": "90000",
				"skills":"java,c++,python",
				"department": {
					"department_id": "4",
					"department_Name": "engg"

				}

			}



Input 3:-	

			{
						"id": "3",
						"firstName": "kevin",
						"lastName": "A",
						"salary": "90000",
						"skills": "java,c++,python,c",
						"department": {
								"department_id": "5",
								"department_Name": "IT"
						}
				}


Input 4:-
			
			{
						"id": "4",
						"firstName": "John",
						"lastName": "C",
						"salary": "90000",
						"skills": "Spring,java,c++,python,c",
						"department": {
								"department_id": "2",
								"department_Name": "devshop"
						}
				}



For Ouput:
	Using Postman ,make a Rest API call 
	request Type- GET 
	URL-http://localhost:8090/employeesAndDeptId

Ouput:-

			[
				"E - 4",
				"C - 2"
			]
