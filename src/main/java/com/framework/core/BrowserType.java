package com.framework.core;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.framework.helper.LoggerHelper;

public class BrowserType {
	
	public static WebDriver driver;
	private Logger log = LoggerHelper.getLogger(BrowserType.class);
	
	public BrowserType(WebDriver driver){
		
		BrowserType.driver = driver;
	}
	
	public WebDriver setupBrowser(String BrowserName) throws Exception {
		
		log.info("Choosing Browser Type");
		
		try {

			switch (BrowserName) {

			case "Chrome":
				ChromeBrowser chrome = ChromeBrowser.class.newInstance();
				return chrome.getChromeDriver(chrome.getChromeCapabilities());
				

			case "Firefox":
				FirefoxBrowser firefox = FirefoxBrowser.class.newInstance();
				return firefox.getFirefoxDriver(firefox
						.getFirefoxCapabilities());

			case "IE":
				IExploreBrowser iExplore = IExploreBrowser.class.newInstance();
				return iExplore.getIExplorerDriver(iExplore
						.getIExplorerCapabilities());
			
			default:
				throw new RuntimeException(" Browser Type (or) Driver Not Found :");
			}

		}

		catch (Exception e) {
			throw e;
		}
	}
	
		public void setDriver(String BrowserName) throws Exception {
			driver = setupBrowser(BrowserName);
			log.info("Choosing Browsename as "+BrowserName+" Successfully...");
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			driver.manage().window().maximize();
	
		}
	
	
	

}
