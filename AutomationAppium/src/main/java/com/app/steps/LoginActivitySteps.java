package com.app.steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


import com.app.activities.LoginActivity;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/*
 * Author: Carlos Humberto Garcia Durán
 * Creation date: 02-01-2021
 * mail: carlos.h27@hotmail.com
 */


public class LoginActivitySteps extends LoginActivity{

	public LoginActivitySteps(AppiumDriver<MobileElement> driver) {
		super(driver);
	}
	
	public void typeUserName(String inputText) {
		type(userNameId, inputText);
	}
	
	public void typePassword(String inputText) {
		type(passwordId, inputText);
	}
	
	public void typePasswordByChar(String inputText) {
		type(passwordId, inputText);
	}
	
	public void pressSignInButton() {
		click(signInButtonId);
	}
	
	public boolean enterPassword(String password) throws InterruptedException {
		boolean validatorButton = signInButtonIsEnable();		
		for (int character = 0; character < password.length(); character++) {
			String passwordTyped = password.substring(0, character + 1);
			int passwordCharNum = character + 1;
			typePasswordByChar(passwordTyped);
			validatorButton = signInButtonIsEnable();

			boolean validatorChar = false;
			if(validatorButton) {
				if(passwordCharNum>5) {
					validatorChar = true;
				}
				assertTrue("Failed the button is enable but the passoword length is less than 5",validatorChar);
				printInConsole("Sign in Button is enable after type " + passwordCharNum + " characters " + passwordTyped);
				break;

			}else {			
				if(passwordCharNum>5) {
					validatorChar = true;
				}
				assertFalse("Failed the button is disable but the passoword length is more than 5",validatorChar);
				printInConsole("Sign in Button is disable after type " + passwordCharNum + " characters " + passwordTyped);

				}
		}	

		return validatorButton;
	}
	
	public boolean signInButtonIsEnable() {
		return isEnable(signInButtonId);
	}
	
	public boolean login(String userName, String password, boolean expectedResult) throws InterruptedException {
		boolean login = false;
		typeUserName(userName);
		boolean actualResult = enterPassword(password);
		if(actualResult) {
			printInConsole("Sign In Button is enable");
			pressSignInButton();
			login = true;
		}else {
			printInConsole("Sign In Button is not enable");
		}
		assertEquals(actualResult,expectedResult);
		return login;
	}
}
