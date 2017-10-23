package com.framework.driver;


import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.framework.core.TestBase;
import com.framework.helper.LoggerHelper;
import com.relevantcodes.extentreports.LogStatus;

public class CommonMethod extends TestBase {
	
	private static Logger log = LoggerHelper.getLogger(CommonMethod.class);
	public static String loggerMessage=
	"Element is not visible or disabled on the webPage";
	

	
	
	/**
	 * Extent ScreenCaputure
	 * @return
	 * @throws IOException
	 */
	
	public static String captureScreenshot() throws IOException{
		return test.addScreenCapture(takeScreenShot(driver));
	}

	/**
	 * Return WebElement
	 * @param driver
	 * @param elementBy
	 * @return
	 */
	public static WebElement findElement(By elementBy){
		return driver.findElement(elementBy);	
	}
	
	/**
	 * Clear Method
	 * @param driver
	 * @param elementBy
	 * @throws IOException 
	 */
	public static void clear(By elementBy,String StepDescription) throws IOException{
		if(CommonMethod.isElementPresent(elementBy)){
			findElement(elementBy).clear();
			 log.info("clearing the textBox field...." +elementBy);
			 test.log(LogStatus.PASS, StepDescription + " Successfully",captureScreenshot());
		}
	
		else{
			 test.log(LogStatus.FAIL, StepDescription + " Failed"+
					 "Element is not visible or disabled on the webPage. "
					 + "Please check Element Locator once...." +elementBy,captureScreenshot());
			 throw new RuntimeException(StepDescription + " Failed"+
					 loggerMessage +elementBy);
		}	
	}
	
	/**
	 * SendKeys Method
	 * @param driver
	 * @param elementBy
	 * @throws IOException 
	 */
	public static void click(By elementBy,String StepDescription) throws IOException{
		
		
			if(CommonMethod.isElementPresent(elementBy)){
				findElement(elementBy).click();
				log.info("Clicking on element ..... " +elementBy);
				test.log(LogStatus.PASS, StepDescription + " Successfully",captureScreenshot());
			}
			else{
			
				 test.log(LogStatus.FAIL, StepDescription + " Failed"+
						 loggerMessage +elementBy,captureScreenshot());
				 throw new RuntimeException(StepDescription + " Failed"+
						 loggerMessage +elementBy);
			}

	}
	
	/**
	 * SendKeys method
	 * @param driver
	 * @param elementBy
	 * @param data
	 * @throws IOException 
	 */
	public static void sendKeys(By elementBy,String data,String StepDescription) throws IOException{
		if(CommonMethod.isElementPresent(elementBy)){
			findElement(elementBy).sendKeys(data);
			 log.info(" Entering data to the textBox field.... " +elementBy);
			 test.log(LogStatus.PASS, StepDescription + " Successfully",captureScreenshot());

		}
		else{
			
			 test.log(LogStatus.FAIL, StepDescription + " Failed"+
					 loggerMessage +elementBy,captureScreenshot());
			 throw new RuntimeException(StepDescription + " Failed"+
					 loggerMessage +elementBy);

		}

	}
	
	/**
	 * GetText Method
	 * @param driver
	 * @param elementBy
	 * @return
	 */
	public static String getText(By elementBy){
		
		String out =findElement(elementBy).getText();
		log.info("getting text from the element  "+elementBy);

		return out;
	}
	
	/**
	 * Select drop down
	 * @param driver
	 * @param by
	 * @param value
	 * @throws IOException 
	 * 
	 */
	public static void selectDropdown( By elementBy, String value,String StepDescription) throws IOException{
		
		if(CommonMethod.isElementPresent(elementBy)){
			new Select (findElement(elementBy)).selectByVisibleText(value); 
			log.info("Selecting dropdown filed.... " +elementBy);
			test.log(LogStatus.PASS, StepDescription + " Successfully",captureScreenshot());

		}
		else{
			
			 test.log(LogStatus.FAIL, StepDescription + " Failed"+
					 loggerMessage +elementBy,captureScreenshot());
			 throw new RuntimeException(StepDescription + " Failed"+
					 loggerMessage +elementBy);

		}
			
	}
	/**
	 * Handling New Tab from Parent
	 * @param driver
	 */
	public static void handleNewTab(WebDriver driver)
	{
		Set<String> allWindowHandles = driver.getWindowHandles();
		Iterator<String> iter=allWindowHandles.iterator();
		int size=allWindowHandles.size();
		String child = null;
		for(int i=0;i<size;i++){
			child=iter.next();
		}
		
		driver.switchTo().window(child);
	}
	
	/**
	 * Handling Parent tab
	 * @param driver
	 */
	public static void handleParentTab(WebDriver driver){
		
		Set<String> allWindowHandles = driver.getWindowHandles();
		String parent = (String) allWindowHandles.toArray()[0];
		driver.switchTo().window(parent);

	}
	/**
	 * Handling childParent tab
	 * @param driver
	 */
	public static void handleChildParentTab(WebDriver driver){
		
		Set<String> allWindowHandles = driver.getWindowHandles();
		String window1 = (String) allWindowHandles.toArray()[1];
		driver.switchTo().window(window1);

	}
	
	/**
	 * For getting get attribute value from field
	 * @param driver
	 * @param objectLocater
	 * @return
	 * @throws IOException
	 */
	public static String getValue(By elementBy,String StepDescription) throws IOException{
		if(CommonMethod.isElementPresent(elementBy)){
			String out=findElement(elementBy).getAttribute("value");
			log.info("Getting value from textBox... " +elementBy);
			test.log(LogStatus.PASS, StepDescription + " Successfully",captureScreenshot());
			return out;
		}
		else{
			
			 test.log(LogStatus.FAIL, StepDescription + " Failed"+
					 loggerMessage +elementBy,captureScreenshot());
			 throw new RuntimeException(StepDescription + " Failed"+
					 loggerMessage +elementBy);

		}
	}

	/**
	 * Explicit wait for particular object locator
	 * @param driver
	 * @param timeOutInSeconds
	 * @param objectLocater
	 * @throws IOException
	 */
	public static void explicitWait(int timeOutInSeconds,By elementBy) throws IOException{
		WebDriverWait wait=new WebDriverWait(driver,timeOutInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(elementBy));
		}
	
	/**
	 * Handling alerts and popups
	 * @param WebDriver
	 * @return
	 */
	public static void acceptAlert(final WebDriver driver) {
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();

			
		} catch (Exception e) {
			
		}
	}
	/**
	 * Handling cancel alert
	 * @param driver
	 * @return
	 */
	public static String cancelAlert(final WebDriver driver) {
		String message = null;
		try {
			Alert alert = driver.switchTo().alert();

			message = alert.getText();
			alert.dismiss();
			
		} catch (Exception e) {
		  message = null;
		}

		return message;
	}
	
	/**
	 * Compact way to verify if an element is on the page 
	 * @param driver
	 * @throws IOException 
	 */
	public static boolean isElementPresent(final  By elementBy) throws IOException  {
			//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		  
			if(findElements(elementBy).size()>0){
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				return true;
				
			}
			else{
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				return false;
			}	   		
	}
	
	/**
	 * List Web elements 
	 * @param driver
	 * @param object
	 * @return
	 * @throws IOException 
	 */
	public static List<WebElement> findElements(final By elementBy) throws IOException{
			return driver.findElements(elementBy);
 			}
		
	/**
	 * Upload file
	 * @param driver
	 * @param value
	 * @throws IOException 
	 * 
	 */
	public static void uploadFile( By elementBy, String path,String StepDescription ) throws IOException{
		if(CommonMethod.isElementPresent(elementBy)){
			findElement(elementBy).sendKeys(path);	
			 log.info(" Uploading file.... " +elementBy);
			 test.log(LogStatus.PASS, StepDescription + " Successfully",captureScreenshot());
		}
		else{
			 test.log(LogStatus.FAIL, StepDescription + " Failed"+
					 loggerMessage +elementBy,captureScreenshot());
			 throw new RuntimeException(StepDescription + " Failed"+
					 loggerMessage +elementBy);

		}
	}
	/**
	 * Handle Mouse Hover
	 * @param driver
	 * @param elementBy
	 */
	public static void handleMouseHover( By elementBy){
		Actions action = new Actions(driver);
		action.moveToElement(findElement(elementBy)).build().perform();
		
	
	}
	
	/**
	 * Handle Drag And Drop
	 * @param driver
	 * @param sourceElement
	 * @param DestinationElement
	 */
   public static void handleDragAndDrop(By sourceElement,By DestinationElement ){
		Actions action = new Actions(driver);
		action.dragAndDrop(findElement( sourceElement), findElement( DestinationElement));

	}
  
   /**
    * Handle Frames
    * @param driver
    * @param elementBy
    */
   public static void handleFrames( By elementBy){
	   driver.switchTo().frame(findElement(elementBy));
	      
   }
	/***
	 * Checking check box
	 * @param driver
	 * @param elementBy
	 * @param StepDescription
	 * @throws IOException
	 */
   public static void checkCheckBox( By elementBy,String StepDescription ) throws IOException{
	   
	   //Check if the object is enabled, if yes click the same
       if (findElement(elementBy).isDisplayed() && findElement(elementBy).isEnabled()){
           //Check state of check box
           boolean isChecked = findElement(elementBy).isSelected();

           //Check if Not Checked
           if(isChecked == false){
        	   findElement(elementBy).click();
           }
			test.log(LogStatus.PASS, StepDescription + " Successfully",captureScreenshot());

       }
       else{
			
			 test.log(LogStatus.FAIL, StepDescription + " Failed"+
					 loggerMessage +elementBy,captureScreenshot());
			 throw new RuntimeException(StepDescription + " Failed"+
					 loggerMessage +elementBy);

		}
	   
	  
	   }
	   /**
	    * Uncheck Selected check box
	    * @param driver
	    * @param elementBy
	    * @param StepDescription
	    * @throws IOException
	    */
	    public static void unCheckCheckBox( By elementBy,String StepDescription ) throws IOException{
		   
		   //Check if the object is enabled, if yes click the same
	       if (findElement(elementBy).isDisplayed() && findElement(elementBy).isEnabled()){
	           //Check state of check box
	           boolean isChecked = findElement(elementBy).isSelected();
	
	           //Check if Not Checked
	           if(isChecked == true){
	        	   findElement(elementBy).click();
	           }
	           
	       }
	       else{
				
				 test.log(LogStatus.FAIL, StepDescription + " Failed"+
						 loggerMessage +elementBy,captureScreenshot());
				 throw new RuntimeException(StepDescription + " Failed"+
						 loggerMessage +elementBy);

			}
		      
	   }
	   /**
	    * Taking ScreenShot
	    * @param driver
	    * @return
	    * @throws IOException
	    */
		public static  String  takeScreenShot(WebDriver driver) throws IOException{
			
			Date d = new Date();
			Timestamp t = new Timestamp(d.getTime());
			String timeStamp = t.toString();
			timeStamp = timeStamp.replace(' ', '_');
			timeStamp = timeStamp.replace(':', '_'); 
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		    FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"/Screenshots/"+timeStamp+".jpg"));
		    String path=System.getProperty("user.dir")+"/Screenshots/"+timeStamp+".jpg";
		    
			return path;		
			
		}
		
		 /**
		  * compared actual Text with the expected text
		  * @param driver
		  * @param actual
		  * @param expected
		  * @throws IOException
		  */
		public static void comparedWithExpectedText(By actual,String expectedValue) throws IOException{
			
			{
				if(findElement( actual).getText().equals(expectedValue)){
					Assert.assertEquals(findElement( actual).getText(), expectedValue);
					log.info("Actual value......"+findElement( actual).getText()+ "..... is  matching with expected value...."+expectedValue+".......");
				    test.log(LogStatus.PASS, "Actual value"+"....."+findElement( actual).getText()+ "..... is  matching with expected value...."+expectedValue+".......",captureScreenshot());
				}
				else{
				    test.log(LogStatus.FAIL, "Actual value ...."+findElement( actual).getText()+ "..... is not matching with expected value...."+expectedValue+".......",captureScreenshot());
					Assert.assertEquals(findElement( actual).getText(), expectedValue);
				    throw(new RuntimeException("Actual value ...."+findElement( actual).getText()+ "....is not matching with expected value...."+expectedValue+"......."));

				}
			}
			
		}
		
		    /**
		     * compared With Expected Element
		     * @param driver
		     * @param expected
		     * @throws IOException
		     */
			public static boolean comparedWithExpectedElement(By expected) throws IOException{
				try{
					
					if(findElements( expected).size()>0){
						Assert.assertTrue(findElement( expected).isDisplayed());
					    test.log(LogStatus.PASS, "Expected value "+expected +"present in the webpage",captureScreenshot());
					    return true;
					}
					else{
					    test.log(LogStatus.FAIL, "Expected element "+expected +" not present in the webpage",captureScreenshot());
						Assert.assertTrue(findElement( expected).isDisplayed());
					    return false;
					}
				}
				catch(Throwable t){
					 log.info(t.getLocalizedMessage());
				      Error e1 = new Error(t.getMessage()); 
				      log.error("Expected value not present in the webpage"+t.getLocalizedMessage());
				      log.error(t.getMessage());
				      e1.setStackTrace(t.getStackTrace()); 
				      throw e1;
					
				}	
		}
		
			
			
			
			
			
			
			
			
			
			
}
 
	
	
	
	
	


