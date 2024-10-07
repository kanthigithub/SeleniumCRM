package practice.xpath;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CricBuzzTop10Rows {

	public static void main(String[] args) throws Throwable {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.cricbuzz.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Actions act = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//a[text()='Rankings']"));
		act.moveToElement(element).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='ICC Rankings - Men']")).click();
		
		List<WebElement> elements = driver.findElements(By.xpath("//div[@class='cb-col cb-col-100 cb-padding-left0']/div[*][position()>=2 and position()<=11]"));
		String output = elements.stream()
                .map(WebElement::getText)
                .collect(Collectors.joining(", "));
		System.out.println(output);
		driver.quit();
	}

}
