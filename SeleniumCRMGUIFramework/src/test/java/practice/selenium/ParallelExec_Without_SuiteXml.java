package practice.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ParallelExec_Without_SuiteXml {
	
	@Test(invocationCount = 3, threadPoolSize = 3)
	public void newTest() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://amazon.in");
		
		
	}

}
