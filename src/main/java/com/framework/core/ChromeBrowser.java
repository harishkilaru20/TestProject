
package com.framework.core;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.framework.helper.ResourceHelper;


public class ChromeBrowser {

	public Capabilities getChromeCapabilities() {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("start-maximized");
		DesiredCapabilities chrome = DesiredCapabilities.chrome();
		chrome.setJavascriptEnabled(true);
		chrome.setCapability(ChromeOptions.CAPABILITY, option);
		return chrome;
	}

	public WebDriver getChromeDriver(Capabilities caps) {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/DriverFiles/chromedriver.exe");
		return new ChromeDriver(caps);
	}
	
	public WebDriver getChromeDriver(String hubUrl,Capabilities cap) throws MalformedURLException {
		return new RemoteWebDriver(new URL(hubUrl), cap);
	}
	
	
	
}
