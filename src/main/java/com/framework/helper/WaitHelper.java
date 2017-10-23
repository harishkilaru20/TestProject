
package com.framework.helper;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.framework.helper.LoggerHelper;


public class WaitHelper  {
	
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(WaitHelper.class);

	public WaitHelper(WebDriver driver) {
		this.driver = driver;

	}
	@SuppressWarnings("unused")
	private WebDriverWait getWait(int timeOutInSeconds,int pollingEveryInMiliSec) {
		log.debug("");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.pollingEvery(pollingEveryInMiliSec, TimeUnit.MILLISECONDS);
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(ElementNotVisibleException.class);
		wait.ignoring(StaleElementReferenceException.class);
		wait.ignoring(NoSuchFrameException.class);
		return wait;
	}

	public void setImplicitWait(long timeout,TimeUnit unit) {
		driver
		.manage()
		.timeouts()
		.implicitlyWait(timeout, unit == null ? TimeUnit.SECONDS : unit);
	}
	
	public void hardWait(int timeOutInMiliSec) throws InterruptedException {
		log.info(timeOutInMiliSec);
		Thread.sleep(timeOutInMiliSec);
	}
	
	public WebElement handleStaleElement(By locator,int retryCount,int delayInSeconds) throws InterruptedException {
		log.info(locator);
		WebElement element = null;
		
		while (retryCount >= 0) {
			try {
				element = driver.findElement(locator);
				return element;
			} catch (StaleElementReferenceException e) {
				hardWait(delayInSeconds);
				retryCount--;
			}
		}
		throw new StaleElementReferenceException("Element cannot be recovered");
	}
	
	public static void explicitWait(WebDriver driver,int timeOutInSeconds,By elementBy) throws IOException{
		WebDriverWait wait=new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(elementBy));
		}
	
	
	public void waitForElementVisible(By locator,int timeOutInSeconds,int pollingEveryInMiliSec) {
		WebDriverWait wait=new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
	}

	
	
	
	
	
	
	
	
	
	
	
}


