package practice.xpath;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CliniquePrg {

	public static void main(String[] args) throws Throwable {

		WebDriver driver = new ChromeDriver();
		driver.get("https://clinique.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(2000);
		WebElement element = driver
				.findElement(By.xpath("//div[@id='onetrust-close-btn-container']/button[@aria-label='Close']/.."));
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
		act.click().perform();

		WebElement element2 = driver.findElement(By.xpath("//a[contains(text(),'Skin Concern')]"));
		act.moveToElement(element2).perform();
		Thread.sleep(2000);
		List<WebElement> elements = driver
				.findElements(By.xpath("(//p[contains(text(),'Concerns')])[1]/following-sibling::a"));
		// System.out.println(elements.size());
		for (WebElement e : elements) {
			System.out.println(e.getText());
		}

		driver.quit();
	}

}
