package practice.datadriventesting;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class SeleniumTestReadDataFromRuntime {
	
	@Test
	public void SeleniumTest() throws Throwable {

		
//		String BROWSER = 
//		String URL = 
//		String USERNAME = 
//		String PASSWORD = 
		
		WebDriver driver = null;
		
		if(BROWSER.equals("chrome")){
			driver = new ChromeDriver();			
		}
		else if(BROWSER.equals("edge")) {
			driver = new EdgeDriver();			
		}
		else if(BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		else {
			driver = new ChromeDriver();
			
		}
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		
		driver.quit();

	}

}
