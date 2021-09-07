package com.mpokket.assessment.base;

public interface IRoutePath {
	
	String CREATE_EMPLOYEE_ENDPOINT="/create";
	
	String GET_SINGLE_EMPLOYEE_ENDPOINT="/employee/{id}";
	
	String DELETE_SINGLE_EMPLOYEE_ENDPOINT="/delete/{id}";
}
