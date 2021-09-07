package com.mpokket.assessment.deserialize;
/*
 * {
    "status": "success",
    "data": {
        "name": "test",
        "salary": "123",
        "age": "23",
        "id": 3377
    },
    "message": "Successfully! Record has been added."
}
 */
public class CreateEmployeeDeserialize {

	private String status;
	private Data data;
	private String message;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Data getData() {
		return data;
	}
	public void setData(Data data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
