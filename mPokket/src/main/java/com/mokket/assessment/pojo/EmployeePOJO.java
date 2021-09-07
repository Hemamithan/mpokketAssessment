package com.mokket.assessment.pojo;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

@JsonPropertyOrder(value = {
		"name",
		"salary",
		"age"
})
public class EmployeePOJO {

	@JsonProperty("name")
	private String name;
	
	@JsonProperty("salary")
	private String salary;

	@JsonProperty("age")
	private String age;

	
	public EmployeePOJO() {
		super();
	}

	public EmployeePOJO(String name, String salary, String age) {
		super();
		this.name = name;
		this.salary = salary;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
	
	
}
