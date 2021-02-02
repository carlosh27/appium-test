package com.app.mobile.test;

import java.io.IOException;
import java.net.MalformedURLException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.app.mobile.actions.BaseTestAppium;
import com.app.mobile.actions.TestData;
import com.app.steps.LoginActivitySteps;
import com.app.steps.MainActivitySteps;

/*
 * Author: Carlos Humberto Garcia Durán
 * Creation date: 02-01-2021
 * mail: carlos.h27@hotmail.com
 */


public class AppAppiumBaseTest extends BaseTestAppium{

	@BeforeTest
	public void setUp() throws InterruptedException, IOException, ParseException {
		driver = mobileDriverConnection();
	}
	

	public void appiumBaseTest(String testDataPath, String testCaseNumber) throws InterruptedException, IOException, ParseException {
		TestData testData = new TestData();
		testData.testDataParse(testDataPath, testCaseNumber);
		printInConsole("Start Execution... "+ testCaseNumber + " " + testData.getData("testName"));
		LoginActivitySteps loginSteps = new LoginActivitySteps(driver);
		MainActivitySteps mainSteps = new MainActivitySteps(driver);
		if(loginSteps.login(testData.getData("userName"), testData.getData("password"), testData.getBooleanData("expectedRessult"))) {
			mainSteps.validateWelcomeMessage(testData.getData("userName"));
		}
	}
	
	
}

