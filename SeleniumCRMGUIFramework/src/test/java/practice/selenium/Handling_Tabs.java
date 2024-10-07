package practice.selenium;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.edge.EdgeDriver;

public class Handling_Tabs {

	public static void main(String[] args) {
		
		WebDriver driver = new EdgeDriver();
		driver.get("https://bigbasket.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		/*
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.open()");
		js.executeScript("window.open()");
		js.executeScript("window.open()");
		js.executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		*/
		
		driver.switchTo().newWindow(WindowType.TAB);
		driver.navigate().to("https://amazon.in");
		
		driver.findElement(By.tagName("body")).sendKeys(Keys.CONTROL+"t");
		
		

	}

}
