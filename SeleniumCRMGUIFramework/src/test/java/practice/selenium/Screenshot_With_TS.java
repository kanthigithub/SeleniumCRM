package practice.selenium;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Screenshot_With_TS {
	
	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://amazon.in");
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshot/fullpage.png");
		FileUtils.copyFile(src, dest);
		
		WebElement element = driver.findElement(By.id("nav-logo-sprites"));
		TakesScreenshot ts1 = (TakesScreenshot)element;
		File src1 = ts1.getScreenshotAs(OutputType.FILE);
		File dest1 = new File("./screenshot/element.png");
		FileUtils.copyFile(src1, dest1);
		
		WebElement division = driver.findElement(By.id("desktop-1"));
		TakesScreenshot ts2 = (TakesScreenshot)division;
		File src2 = ts2.getScreenshotAs(OutputType.FILE);
		File dest2 = new File("./screenshot/division.png");
		FileUtils.copyFile(src2, dest2);
		
		driver.quit();
	}

}
