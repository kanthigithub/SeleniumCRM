package practice.pom.repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class SampleTestWithPOM {
	
	@FindBy(name="user_name")
	WebElement ele1;
	
	@FindBy(name="user_password")
	WebElement ele2;
	
	@FindAll({@FindBy(id="submitButton"),@FindBy(xpath="//input[@type='submit']")})
	WebElement ele3;
	
	@Test
	public void sampleTest() {
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888");
		
		SampleTestWithPOM obj = PageFactory.initElements(driver,SampleTestWithPOM.class);
		
		obj.ele1.sendKeys("admin");
		obj.ele2.sendKeys("admin");
		
		driver.navigate().refresh(); // now element address will be changed
		obj.ele1.sendKeys("admin");		//so stale element ref exception 
		obj.ele2.sendKeys("admin");
		
		obj.ele3.click();		
		
	}
	
}
