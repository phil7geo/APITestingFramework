package com.w2a.APITestingFramework.APIs;

import static io.restassured.RestAssured.given;

import com.w2a.APITestingFramework.setUp.BaseTest;

import io.restassured.response.Response;


//CLASS TO SEPERATE BUSINESS SPECIFICATIONS-CONCEPT FROM THE TEST CASE WITH THESE 2 METHODS TO CREATE A CUSTOMER WITH VALID VALID AND INVALID KEY AND  MAKE THIS POST REQUEST AT RESPONSE AND RETURN IT

public class CreateCustomerAPI extends BaseTest{

	
	public static Response sendPostRequestToCreateCustomerApiWithValidAuthKey(String name, String email,String description) {
		
		
		Response response =given().auth().basic(config.getProperty("validSecretKey"), "")
		.formParam("email", email).formParam("description",description)
		.post(config.getProperty("customerAPIEndPoint"));
		
		//OR:
		//for big data and many variables then use Hashtable
		//Response response = CreateCustomerAPI.sendPostRequestToCreateCustomerAPIWithValidAuthKey(String name,String email,String description);
		
		return response;
	}
	
	public static Response sendPostRequestToCreateCustomerApiWithInValidAuthKey(String name, String email, String description) {
		
		
		Response response =given().auth().basic(config.getProperty("inValidSecretKey"),"")
				.formParam("email", email).formParam("description",description)
				.post(config.getProperty("customerAPIEndPoint"));
		
		return response;
	}
}
