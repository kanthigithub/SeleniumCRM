package practice.xpath;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class TokyoOlympics {
	
	public static void main(String[] args) throws AWTException, InterruptedException {
		
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://olympics.com/en/olympic-games/tokyo-2020");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		WebElement ele = driver.findElement(By.xpath("//h2[text()='Featured Athletes']"));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView", ele);
		
		Thread.sleep(2000);
		driver.findElement(By.id("onetrust-accept-btn-handler")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//span[@class='sc-330a00-4 irujJD']")).click();
		System.out.print("no of gold medals won by "+driver.findElement(By.xpath("//a[text()='Qian YANG']")).getText()+" is ");
		System.out.print(driver.findElement(By.xpath("//a[text()='Qian YANG']/ancestor::div[@class='AthleteItem-styles__Wrapper-sc-f27fecd7-0 yKUDW']/descendant::span[@data-cy='ocs-text-module']")).getText());
		
		driver.quit();
		
	}

}
