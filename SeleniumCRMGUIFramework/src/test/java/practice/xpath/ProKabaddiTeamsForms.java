package practice.xpath;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProKabaddiTeamsForms {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.prokabaddi.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		/*
		 List<WebElement> teams = driver.findElements(By.xpath("//div[@class='team-name']"));
		
		for(int i=0;i<5;i++) {
			System.out.print("\n"+teams.get(i).getText()+"------------");
			List<WebElement> forms = driver.findElements(By.xpath("(//div[@class='team-name']/ancestor::div[@class='row-head']/div[@class='table-data form'])["+(i+1)+"]/ul/li/p"));
			for(WebElement w:forms) 			
				System.out.print(w.getText()+" ");			
		}
		*/
		
		System.out.println( driver.findElement(By.xpath("(//div[@class='team-name'])[position()=2]")).getText());
		System.out.println( driver.findElement(By.xpath("(//div[@class='team-name'])[position()=3]")).getText());
		System.out.println( driver.findElement(By.xpath("(//div[@class='team-name'])[position()=4]")).getText());
		
		driver.quit();
	}

}
