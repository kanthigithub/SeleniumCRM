package practice.xpath;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IccCricketTeamPoints {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.icc-cricket.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//a[@data-tag='rankings']")).click();
		
		driver.findElement(By.xpath("//h3[contains(text(),\"Men's team rankings\")]/ancestor::div[@class='si-component si-standings si-team-ranking']/descendant::h4[@class='si-table-title' and contains(.,'t20')]/ancestor::div[@class='si-table swiper-slide']/descendant::span[text()='Full Rankings']")).click();
		
		List<WebElement> tnames = driver.findElements(By.xpath("//div[@class='si-table-body']/div[@class='si-table-row']/descendant::span[@class='si-fname si-text']"));
		List<WebElement> tpts = driver.findElements(By.xpath("//div[@class='si-table-body']/div[@class='si-table-row']/descendant::div[@class='si-table-data si-pts']/span[@class='si-text']"));
		
		for(int i=0; i<tnames.size(); i++) {
			
			System.out.println(tnames.get(i).getText()+"----------"+tpts.get(i).getText());
		}


	}

}
