package com.framework.helper;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.framework.helper.LoggerHelper;


public class JavaScriptHelper {

	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(JavaScriptHelper.class);

	public JavaScriptHelper(WebDriver driver) {
		this.driver = driver;
	}

	public Object executeScript(String script) {
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		log.info(script);
		return exe.executeScript(script);
	}

	public Object executeScript(String script, Object... args) {
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		log.info(script);
		return exe.executeScript(script, args);
	}

	public void scrollToElemet(WebElement element) {
		executeScript("window.scrollTo(arguments[0],arguments[1])",
				element.getLocation().x, element.getLocation().y);
		log.info(element);
	}

	public void scrollToElemet(By locator) {
		scrollToElemet(driver.findElement(locator));
		log.info(locator);
	}

	public void scrollToElemetAndClick(By locator) {
		WebElement element = driver.findElement(locator);
		scrollToElemet(element);
		element.click();
		log.info(locator);
	}

	public void scrollToElemetAndClick(WebElement element) {
		scrollToElemet(element);
		element.click();
		log.info(element);
	}

	public void scrollIntoView(WebElement element) {
		executeScript("arguments[0].scrollIntoView()", element);
		log.info(element);
	}

	public void scrollIntoView(By locator) {
		scrollIntoView(driver.findElement(locator));
		log.info(locator);
	}

	public void scrollIntoViewAndClick(By locator) {
		WebElement element = driver.findElement(locator);
		scrollIntoView(element);
		element.click();
		log.info(locator);
	}

	public void scrollIntoViewAndClick(WebElement element) {
		scrollIntoView(element);
		element.click();
		log.info(element);
	}
}