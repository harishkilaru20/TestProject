package com.framework.reports;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeSuite;

import com.framework.core.EnvironmentSetup;
import com.framework.helper.LoggerHelper;
import com.framework.helper.ResourceHelper;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ExtentReporting {
	

	private Logger log = LoggerHelper.getLogger(ExtentReporting.class);
	public ExtentReports extent;
	public static ExtentTest test;

	@BeforeSuite
	public void GeneratingReport() throws IOException{
		
	    
		try{
			log.info("Configuration of reporting ..........");
			//Configuring properties of Extent reports
			extent = new ExtentReports(System.getProperty("user.dir")+"/Reports/CurrentReport.html");
			extent.loadConfig(new File(System.getProperty("user.dir")+"/src/main/resources/configfile/extent-config.xml"));
			
		}
		catch(Throwable t) 
	    {	
			  log.info(t.getLocalizedMessage());
		      Error e1 = new Error(t.getMessage()); 
		      log.error("Configuration of reporting logs failed........" +t.getLocalizedMessage());
		      log.error(t.getMessage());
		      e1.setStackTrace(t.getStackTrace()); 
		      throw e1;
	   }	
	
	}
		
	}
	
	
	


