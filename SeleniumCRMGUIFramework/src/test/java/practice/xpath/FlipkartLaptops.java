package practice.xpath;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipkartLaptops {

	public static void main(String[] args) throws Throwable {

		WebDriver driver = new ChromeDriver();
		driver.get("https://flipkart.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.name("q")).sendKeys("laptops");

//		List<WebElement> elements = driver.findElements(By.xpath("//li[@class='AgOexi']"));
		Thread.sleep(2000);
		List<WebElement> elements2 = driver.findElements(By.xpath("//li[@class='_3D0G9a']/div/a/div[2]"));
//		
//		for(WebElement e: elements) {
//			System.out.println(e.getText());
//		}

		for (WebElement e : elements2) {
			if (e.getText().contains("laptop under 40000")) {
				e.click();
				break;
			}
		}

		List<WebElement> elements3 = driver.findElements(By.xpath("//div[@class='KzDlHZ']"));
		for (WebElement e : elements3) {
			// if(driver.findElements(By.xpath("//div[@class='KzDlHZ']/../div[@class='f8qK5m'
			// ]")) == null)
			String lName = e.getText();
			// if((driver.findElements(By.xpath("//div[contains(text(),'"+lName+"')]/../div"))).size()
			// == 3) {
			if (driver.findElement(By.xpath("//div[contains(text(),'" + lName + "')]/../div")).getAttribute("class")
					.equals("KzDlHZ")) {
				String lPrice = driver.findElement(By.xpath(
						"//div[contains(text(),'" + lName + "')]/../../descendant::div[@class='Nx9bqj _4b5DiR']"))
						.getText();
				System.out.println(lName + "===>" + lPrice);
			}
		}

		driver.quit();

	}

}
