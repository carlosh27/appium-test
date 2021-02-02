package com.app.mobile.test;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
/*
 * Author: Carlos Humberto Garcia Durán
 * Creation date: 02-01-2021
 * mail: carlos.h27@hotmail.com
 */
public class Test_Login_Application extends AppAppiumBaseTest{
	
	String testDataPath = 	"/src/main/resources/testSpec/app/testData/app_testSpec.json";
	
	@Test
	public void Test_Login_Application_Sucess () throws InterruptedException, IOException, ParseException {
		String testCaseNumber = "Test01";
		appiumBaseTest(testDataPath, testCaseNumber);
	}
	
	 @Test
	public void Test_Login_Application_Negative () throws InterruptedException, IOException, ParseException {
		String testCaseNumber = "Test02";
		appiumBaseTest(testDataPath, testCaseNumber);
	}
}
