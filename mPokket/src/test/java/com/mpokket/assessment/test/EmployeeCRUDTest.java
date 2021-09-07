package com.mpokket.assessment.test;

import org.testng.annotations.Test;

import com.mokket.assessment.pojo.EmployeePOJO;
import com.mpokket.assessment.base.Base;
import com.mpokket.assessment.base.IRoutePath;
import com.mpokket.assessment.deserialize.CreateEmployeeDeserialize;
import com.mpokket.assessment.get.deserialize.GetEmployeeDesirealize;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;

public class EmployeeCRUDTest extends Base {
	
	@Test
	public void createDeleteEmployeeTest() {
		/*
		 * Creating a new resource using employee pojo
		 */
		EmployeePOJO employeePOJO = new EmployeePOJO("Hema", "50000", "26");
		
		/*
		 * Post Request for adding new employee 
		 */
		Response createEMPResponse = RestAssured.given()
		.contentType(ContentType.JSON)
		.body(employeePOJO)
		.when()
		.post(IRoutePath.CREATE_EMPLOYEE_ENDPOINT);
		createEMPResponse.then()
		.log().all();
		
		//Getting the empId from Post request
		
		CreateEmployeeDeserialize emp = createEMPResponse.getBody().as(CreateEmployeeDeserialize.class);
		int empId = emp.getData().getId();
		//validating employee data in response
		Assert.assertEquals(emp.getStatus(), "success");
		Assert.assertEquals(emp.getData().getName(), employeePOJO.getName());
		Assert.assertEquals(emp.getData().getSalary(), employeePOJO.getSalary());
		Assert.assertEquals(emp.getData().getAge(), employeePOJO.getAge());;
		Assert.assertEquals(emp.getMessage(), "Successfully! Record has been added.");
		
		/*
		 * Retrieving the employee information by specifying the emp ID
		 */
		Response getEmployeeResponse=RestAssured.given()
		.pathParam("id", empId)
		.get(IRoutePath.GET_SINGLE_EMPLOYEE_ENDPOINT);
		getEmployeeResponse.then()
		.assertThat().statusCode(200)
		.assertThat().contentType(ContentType.JSON)
		.log().all();
		GetEmployeeDesirealize getEmployeeData = getEmployeeResponse.getBody().as(GetEmployeeDesirealize.class);
		
		Assert.assertEquals(getEmployeeData.getStatus(), "success");
		Assert.assertEquals(getEmployeeData.getData().getEmployee_name(), employeePOJO.getName());
		Assert.assertEquals(getEmployeeData.getData().getEmployee_salary(), employeePOJO.getSalary());
		Assert.assertEquals(getEmployeeData.getData().getEmployee_age(), employeePOJO.getAge());
		/*
		 * Deleting the employee created in post request
		 */
		Response deleteEmployeeResponse=RestAssured.given()
		.pathParam("id", empId)
		.delete(IRoutePath.DELETE_SINGLE_EMPLOYEE_ENDPOINT);
		deleteEmployeeResponse.then()
		.assertThat().statusCode(204)
		.log().all();
		
	}
	

}
