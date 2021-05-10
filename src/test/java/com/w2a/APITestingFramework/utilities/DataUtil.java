package com.w2a.APITestingFramework.utilities;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

import com.w2a.APITestingFramework.setUp.BaseTest;

public class DataUtil extends BaseTest {

	
	@DataProvider(name="data",parallel=true)
	public Object[][] getData(Method m) {
		
		System.out.println("SheetName "+m.getName());
		String sheetName = m.getName();
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);
		
		System.out.println("Total rows are: "+rows+"Total cols are: "+cols);
		
		//Object[][] data  = new Object[1][3];
		Object[][] data  = new Object[rows-1][cols];
		
		//excel.getCellData(sheetName, colNum, rowNum);
		System.out.println(excel.getCellData(sheetName, 0, 2));
		
//		//data[0][0]="Filippos";
//		data[0][0]=excel.getCellData(sheetName, 0, 2);
//		
//		//data[0][1]="georgantzosphil@gmail.com";
//		data[0][1]=excel.getCellData(sheetName, 1, 2);
//		
//		//data[0][2]="adding the first customer in framework";
//		data[0][2]=excel.getCellData(sheetName, 2, 2);
//		
//		
//		
//		//Ádd the second row
//		data[1][0]=excel.getCellData(sheetName, 0, 3);
//		data[1][1]=excel.getCellData(sheetName, 1, 3);
//		data[1][2]=excel.getCellData(sheetName, 2, 3);
		
		
		for(int rowNum=2; rowNum <= rows; rowNum++) {
			
			for(int colNum=0; colNum < cols; colNum++) {
				
				//data[0][0]=excel.getCellData(sheetName, 0, 2);
				data[rowNum-2][colNum] = excel.getCellData(sheetName, colNum, rowNum);
				
			}
			
		}
		
		
		return data;
	}
}
