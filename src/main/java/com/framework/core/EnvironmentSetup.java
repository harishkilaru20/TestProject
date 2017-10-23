package com.framework.core;

import java.io.IOException;
import org.apache.log4j.Logger;
import com.framework.core.BrowserType;
import com.framework.helper.LoggerHelper;
import com.framework.helper.ResourceHelper;
import com.framework.reader.PropertyFileReader;
import com.framework.reports.ExtentReporting;

public class EnvironmentSetup extends ExtentReporting{
	
	private Logger log = LoggerHelper.getLogger(EnvironmentSetup.class);
	private String qaURL;
	private String statgeURL;
	private String devURL;
	private String prodURL;
	public PropertyFileReader reader;
	
	public void setEnvironmentMode(String environment) throws IOException{
		
		getEnvironmentConfiguaration();
		log.info("Choosing Environment Mode");
	   try{
			  switch(environment){
			  
			    case "QA":
			    	
			    	    BrowserType.driver.get(qaURL);
			    		log.info("Navigated to URL : "+qaURL);
			    		break;
				
			    case "Staging":
			    	    BrowserType.driver.get(statgeURL);
						log.info("Navigated to URL : "+statgeURL);
						break;
				case "Dev":
					    BrowserType.driver.get(devURL);
						log.info("Navigated to URL : "+devURL);
						break;
				case "Production":
					    BrowserType.driver.get(prodURL);
						log.info("Navigated to URL : "+prodURL);
						break;
				default:
						throw new RuntimeException("Environemnt Value Not Matched .....");
			  
			  	}
	       }

	    catch(Throwable t) 
	    {	
		      Error e1 = new Error(t.getMessage()); 
		      log.error("Navigating URL failed.........." +t.getLocalizedMessage());
		      e1.setStackTrace(t.getStackTrace()); 
		      throw e1;
	   }
	   
	
	}
		
		public void getEnvironmentConfiguaration() throws IOException{
			  reader = new PropertyFileReader(System.getProperty("user.dir")+"/src/main/resources/configfile/Environment.properties");
			  qaURL   =   reader.readingData("QA");
			  statgeURL = reader.readingData("Staging");
			  devURL  =   reader.readingData("Dev");
			  prodURL =   reader.readingData("Production");
					  
		}
		
		
		
		
		
		
		
		
	

}
	
	
	
	
	
	
	
	
	
	

