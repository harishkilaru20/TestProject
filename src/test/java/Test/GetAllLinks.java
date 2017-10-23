package Test;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAllLinks {
	
	public WebDriver driver;
	public void setup() {
	
		
		System.setProperty("webdriver.chrome.driver", "F:\\FrameworkWS\\seleniumFramework\\src\\main\\resources\\driver\\chromedriver.exe");
		driver= new ChromeDriver();
		
		//System.setProperty("webdriver.gecko.driver", "E:\\workspace\\Selenium\\jars\\geckodriver.exe");
		//driver= new FirefoxDriver();
	
		
		driver.manage().window().maximize();
		driver.get("http://www.selenium4tetsing.com/");
		
		
		}
	public void getAlllinks(){
		ArrayList<String> al = new ArrayList<String>();
	List<WebElement>wb = driver.findElements(By.tagName("a"));
		
		System.out.println(wb.size());
		for(int i=1; i<wb.size();i++){
			
			driver.get(al.get(i));
			
			String url = wb.get(i).getAttribute("href");
			System.out.println(url);
			al.add(url);
			
		}
		System.out.println(al.size());
		
	}

	 

	public static void main(String[] args) {
		GetAllLinks get = new GetAllLinks();
		get.setup();
		get.getAlllinks();
		
		

	}

}
  