package com.mpokket.assessment.base;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;

public class Base {
	
	@BeforeSuite
	public void requestSetUp() {
		RestAssured.baseURI=PropertyFileUtility.getPropertyValue("uri");
	}
	
	
	
	@AfterSuite
	public void requestTearDown() {
		
	}

}
