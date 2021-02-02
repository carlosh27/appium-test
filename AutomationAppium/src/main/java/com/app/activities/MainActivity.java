package com.app.activities;

import com.app.mobile.actions.BaseTestAppium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/*
 * Author: Carlos Humberto Garcia Durán
 * Creation date: 02-01-2021
 * mail: carlos.h27@hotmail.com
 */

public class MainActivity extends BaseTestAppium{

	public MainActivity(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
	}
	
	
	protected String welcomeMessage = "io.grainchain.logintest:id/textview_first";
}
