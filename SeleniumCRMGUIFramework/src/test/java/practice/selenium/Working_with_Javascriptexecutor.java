package practice.selenium;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Working_with_Javascriptexecutor {
	
	public static void main(String[] args) {
		
		WebDriver driver= new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://amazon.in");
		
		//WebElement searchTB = driver.findElement(By.id("twotabsearchtextbox"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.getElementById('twotabsearchtextbox').value='iphone'");
		js.executeScript("document.getElementById('nav-search-submit-button').click()");
		js.executeScript("window.scrollBy(0,500)");
		
		
	}

}
