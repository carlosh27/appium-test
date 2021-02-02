package com.app.steps;

import static org.junit.Assert.assertEquals;

import com.app.activities.MainActivity;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/*
 * Author: Carlos Humberto Garcia Durán
 * Creation date: 02-01-2021
 * mail: carlos.h27@hotmail.com
 */


public class MainActivitySteps extends  MainActivity{

	public MainActivitySteps(AppiumDriver<MobileElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	public void validateWelcomeMessage(String userName) {
		boolean welcomeMessageIsDisplay = isDisplayed(welcomeMessage);
		if(welcomeMessageIsDisplay) {
			printInConsole("welcome meessage is displayed");
			String welcomeMessageDisplayed = getText(welcomeMessage);	
			String actualResult = welcomeMessageDisplayed.substring(6, welcomeMessageDisplayed.length());
			printInConsole(actualResult);
			assertEquals(actualResult.trim(),userName);
			printInConsole("welcome message display the user name correctly as "+actualResult);
		}else {
			printInConsole("welcome meessage is not displayed");
		}
	}

}
