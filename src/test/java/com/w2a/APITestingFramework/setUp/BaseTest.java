package com.w2a.APITestingFramework.setUp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;
import com.w2a.APITestingFramework.utilities.*;

public class BaseTest {

	
	public static Properties config = new Properties();
	private FileInputStream fis;
	public static ExcelReader excel = new ExcelReader(".\\src\\test\\resources\\excel\\testdata.xlsx");
	
	
	
	//Execute before doing anything with test cases
	
	@BeforeSuite
	public void setUp() {
		
		//FileInputStream fis = new FileInputStream("C:\\Users\\georg\\eclipse-workspace\\RestASSUREDAPI\\APITestingFramework\\src\\test\\resources\\properties\\config.properties");
		try {
			fis = new FileInputStream(".\\src\\test\\resources\\properties\\config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			config.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		RestAssured.baseURI=config.getProperty("baseURI");
		RestAssured.basePath=config.getProperty("basePath");
		
	}
	
	//Quit or start any session-Generate at end of test case execution
	
	@AfterSuite
	public void tearDown () {
		
		
	}
}
