package com.framework.core;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.framework.core.BrowserType;
import com.framework.helper.LoggerHelper;
import com.framework.reader.ExcelReader;
import com.framework.reader.PropertyFileReader;
import com.framework.reports.ExtentReporting;


public class TestBase extends ExtentReporting  {
	
	public static WebDriver driver;
	private Logger log = LoggerHelper.getLogger(TestBase.class);
	public static ExcelReader data; 
	public static PropertyFileReader preader;

		@BeforeMethod
		@Parameters({"Browser","Environment"})
		public void initialization(String Browser,String Environment) throws Exception{
		
		    log.info("Intialization........");    
		    try{
			    // configuration
		    	data = new ExcelReader(System.getProperty("user.dir")+"/src/main/resources/exceldata/Login.xlsx");
			    log.info("test configuration..... ");
			    log.info("test configuration..... Successfully");

			    //Invoking browser
				BrowserType BrowserMode = new BrowserType(driver);
				BrowserMode.setDriver(Browser);
				extent.addSystemInfo("BrowserName", Browser);
			    
				//Selecting Environment Mode
				EnvironmentSetup EnvirornmentMode= new EnvironmentSetup();
				EnvirornmentMode.setEnvironmentMode(Environment);
			    extent.addSystemInfo("Environment", Environment);

				log.info("Intialization........ Successfully Done");
				driver = BrowserType.driver;

		    }
		    catch (Exception e) {
				throw e;
			}
		
			}
	
		
	
	
	@AfterMethod
	public void extentEnd(){
		
		extent.endTest(test);
		extent.flush();
		driver.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
