package com.w2a.APITestingFramework.testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.w2a.APITestingFramework.APIs.CreateCustomerAPI;
import com.w2a.APITestingFramework.setUp.BaseTest;
import com.w2a.APITestingFramework.utilities.DataUtil;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;



public class CreateCustomerTest extends BaseTest {

	
	//@Test(dataProvider="getData")
	@Test(dataProviderClass=DataUtil.class,dataProvider="data")
	public void validateCreateCustomerAPIWithValidSecretKey(String name, String email,String description) {
//		public void validateCreateCustomerAPI(String name, String email,String description) {
		
	//FOR HASHTABLE:
	//@Test(dataProviderClass=DataUtil.class,dataProvider="data")
	//public void validateCreateCustomerAPIWithValidSecretKey(Hashtable <String,String> data) {
		
//		Response response =given().auth().basic(config.getProperty("validSecretKey"), "")
//			.formParam("email", email).formParam("description",description)
//			.post(config.getProperty("customerAPIEndPoint"));
		
		
		//Test Report from ExtentListeners with the info of the data i provided
		//ExtentListeners.testReport.get().info(data.toString());
		
		Response response = CreateCustomerAPI.sendPostRequestToCreateCustomerApiWithValidAuthKey(name, email, description);
		
		
		//baseURI + basePath + Endpoint --> /customers...
		
		response.prettyPrint();
		
		System.out.println(response.statusCode());
		
		System.out.println(response.statusCode());
		
		Assert.assertEquals(response.statusCode(), 200);
	}
	
	
	@Test(dataProviderClass=DataUtil.class,dataProvider="data")
	public void validateCreateCustomerAPIWithInValidSecretKey(String name, String email, String description) {
//	public void invalidCreateCustomerAPI(String name, String email, String description) {
	
	//FOR HASHTABLE:
	//@Test(dataProviderClass=DataUtil.class,dataProvider="data")
	//public void validateCreateCustomerAPIWithInValidSecretKey(Hashtable <String,String> data) {
		
//		Response response =given().auth().basic(config.getProperty("inValidSecretKey"),"")
//				.formParam("email", data.get("email")).formParam("description",data.get("description"))
//				.post(config.getProperty("customerAPIEndPoint"));
		
	
		
//		RestAssured.baseURI="https://api.stripe.com";
//		RestAssured.basePath="/v1";
		
		
		//THIS IS BUSINESS CONCEPT
//		Response response =given().auth().basic(config.getProperty("inValidSecretKey"),"")
//			.formParam("email","georgantzosphil@gmail.com").formParam("description","adding the first customer in framework")
//			.post(config.getProperty("customerAPIEndPoint"));
		
		//ExtentListeners.testReport.get().info(data.toString());
		
		Response response = CreateCustomerAPI.sendPostRequestToCreateCustomerApiWithInValidAuthKey(name, email, description);
		
		
		
		response.prettyPrint();
		
		System.out.println(response.statusCode());
		
		Assert.assertEquals(response.statusCode(), 200);
		
		
	}
	
	
	
	//DATA PROVIDER ....
	
	
}
