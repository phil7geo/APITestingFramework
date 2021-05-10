package com.w2a.APITestingFramework.APIs;

import static io.restassured.RestAssured.given;

import java.util.Hashtable;

import com.w2a.APITestingFramework.setUp.BaseTest;

import io.restassured.response.Response;

public class DeleteCustomerAPI  extends BaseTest {

	
//	public static Response sendDeleteRequestToCreateCustomerApiWithValidAuthKey(String name, String email,String description) {
	public static Response sendDeleteRequestToCreateCustomerApiWithValidID(Hashtable<String, String> data) {	
		
		Response response =given().auth().basic(config.getProperty("validSecretKey"), "")
		.delete(config.getProperty("customerAPIEndPoint")+"/"+data.get("id"));
		
		//OR:
		//for big data and many variables then use Hashtable
		//Response response = CreateCustomerAPI.sendPostRequestToCreateCustomerAPIWithValidAuthKey(String name,String email,String description);
		
		return response;
	}
	
//	public static Response sendPostRequestToCreateCustomerApiWithInValidAuthKey(String name, String email, String description) {
//		
//		
//		Response response =given().auth().basic(config.getProperty("inValidSecretKey"),"")
//				.formParam("email", email).formParam("description",description)
//				.post(config.getProperty("customerAPIEndPoint"));
//		
//		return response;
//
//	
//	
//	}

}