
package com.app.mobile.actions;

import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/*
 * Author: Carlos Humberto Garcia Durán
 * Creation date: 02-01-2021
 * mail: carlos.h27@hotmail.com
 */

public class BaseTestAppium {

	public AppiumDriver<MobileElement> driver;
	public JSONArray capEnv; 
	public String urlServer; 
	public DesiredCapabilities caps = new DesiredCapabilities();
	String capEnvPath = "/src/main/resources/testSpec/app/testData/app_Enviroment.json";

	
	public AppiumDriver<MobileElement> mobileDriverConnection() throws InterruptedException, IOException {		
		setCapabilities();
		driver = new AppiumDriver<MobileElement>(new URL(urlServer),caps);		
		return driver;
	}
	
	public DesiredCapabilities setCapabilities() throws IOException{
		capabilitiesParse(capEnvPath);
		JSONObject arrJson = capEnv.optJSONObject(0);
		Iterator<?> keys = arrJson.keys();		
		while(keys.hasNext()) {
			String capabilityName = (String) keys.next();
			String value = (String) arrJson.get(capabilityName);
			caps.setCapability(capabilityName, value);
		}		
		printInConsole(caps.toString());
		return caps;
	}
	
	
	public void capabilitiesParse(String capEnvPath) throws IOException {		
		String projectPath = System.getProperty("user.dir");
		FileReader readFile = new FileReader(projectPath + capEnvPath);
		JSONTokener parse = new JSONTokener(readFile);
		JSONObject jsonData = new JSONObject(parse);
		capEnv = new JSONArray();
		capEnv.put(jsonData.get("capabilities"));
		urlServer = jsonData.getString("urlServer");

	}
	
	public MobileElement findElementById(String id) {
		return driver.findElementById(id);
	}

	public void type(String id, String inputTex) {
		findElementById(id).sendKeys(inputTex);
	}
	
	public void click(String id) {
		findElementById(id).click();
	}
	
	public boolean isEnable(String id) {
		return findElementById(id).isEnabled();
	}
	
	public void printInConsole(String message) {
		System.out.println(message);
	}
	
	public void printInConsoleBoolean(Boolean message) {
		System.out.println(message);
	}
	
	public boolean isDisplayed(String id) {
		return findElementById(id).isDisplayed();
	}
	
	public String getText(String id) {
		return findElementById(id).getText();
	}
	
}
