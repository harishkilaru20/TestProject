package com.PDT.pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;

import com.framework.core.TestBase;
import com.framework.driver.CommonMethod;

public class LoginPage extends TestBase {
	
	public By username1 = By.name("username");
	public By password1 = By.name("password");
	public By login = By.name("submit");
	
	
	
	
	public void passDataToUsernameFiled() throws IOException{
		String username = data.getCellData("LoginDetails", "UserName", 2);
		CommonMethod.clear(username1, "Clearing username field");
		CommonMethod.sendKeys(username1,username , "passing username to texbox field");
	}
	
	
	public void passDataToPasswordFiled() throws IOException{
		String password = data.getCellData("LoginDetails", "Password", 2);
		CommonMethod.clear(password1, "Clearing password field");
		CommonMethod.sendKeys(password1,password , "passing password to texbox field");
		
		
	}
	
	public void clickOnLoginButton() throws IOException{
		
		CommonMethod.click(login, "Click on login button");
	}
	
	
	
	
	
	
	
	

}
