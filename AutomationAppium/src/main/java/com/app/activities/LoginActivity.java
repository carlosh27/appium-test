package com.app.activities;

import com.app.mobile.actions.BaseTestAppium;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/*
 * Author: Carlos Humberto Garcia Durán
 * Creation date: 02-01-2021
 * mail: carlos.h27@hotmail.com
 */

public class LoginActivity extends BaseTestAppium{

	public LoginActivity(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
	}
	
	protected String userNameId = "io.grainchain.logintest:id/username";
	protected String passwordId = "io.grainchain.logintest:id/password";
	protected String signInButtonId = "io.grainchain.logintest:id/login";
			
	
	
	
}
