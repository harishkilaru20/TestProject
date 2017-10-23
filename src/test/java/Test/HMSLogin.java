package Test;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.PDT.pageObjects.LoginPage;
import com.framework.core.TestBase;
import com.framework.driver.CommonMethod;


public class HMSLogin extends TestBase {
	
	LoginPage loginPage = new LoginPage();
	
	
	@Test(priority=1)
	public void  login() throws IOException, InterruptedException{
		 test = extent.startTest("TC-0001  Login Testcase");
		 
		 //scenario1
		// loginPage.passDataToUsernameFiled();
		 //loginPage.clickOnLoginButton();
		// CommonMethod.comparedWithExpectedText(By.xpath("//div[@class='alert alert-error']"),"Failed to authenticate");	
		 
		 loginPage.passDataToUsernameFiled();
		 loginPage.passDataToPasswordFiled();
		 loginPage.clickOnLoginButton();
		 CommonMethod.comparedWithExpectedElement(By.xpath("//a[@href='logout.php']"));
		 CommonMethod.comparedWithExpectedText(By.xpath("//a[@href='logout.php']"),"Logout");	
		
	}
	
		
	//@Test(priority=2)
	public void  logou() throws IOException, InterruptedException{
		 test = extent.startTest("TC-0002 Logout Testcase");
		 loginPage.passDataToUsernameFiled();
		 loginPage.passDataToPasswordFiled();
		 loginPage.clickOnLoginButton();
		 CommonMethod.click(By.xpath("//a[@href='logout.php']"), "Click on logout button");
		 
		 
	}
		
		
		
		
		
		
		

	
}
