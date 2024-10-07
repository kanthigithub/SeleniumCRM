package practice.xpath;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class BigBasketMenus {
	
	public static void main(String[] args) throws Throwable {
		WebDriver driver = new EdgeDriver();
		driver.get("https://bigbasket.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)");
		//js.executeScript("document.body.style.zoom='80%'");
		driver.findElement(By.xpath("(//span[text()='Category'])[1]")).click();
		Actions act = new Actions(driver);
		
		List<WebElement> elements = driver.findElements(By.xpath("//ul[@class='jsx-1259984711 w-56 px-2.5 bg-darkOnyx-800 text-silverSurfer-100 rounded-l-xs']/li[@class='jsx-1259984711']/a"));
		System.out.println(elements.size());
		for(WebElement e : elements) {
			if(!e.getText().equals("")) {	
				//System.out.println(e.getText());
				
				act.moveToElement(e).perform();	
				Thread.sleep(500);
				List<WebElement> subs = driver.findElements(By.xpath("//ul[@class='jsx-1259984711 w-56 px-2.5 bg-silverSurfer-200 text-darkOnyx-800']/li[@class='jsx-1259984711']/a"));
				for(WebElement f : subs) {
					if(!f.getText().equals("")) {
						act.moveToElement(f).perform();
						List<WebElement> subs2 = driver.findElements(By.xpath("//ul[@class='jsx-1259984711 w-56 px-2.5 bg-white text-darkOnyx-800 rounded-r-xs']/li[@class='jsx-1259984711']/a"));
						for(WebElement g : subs2) {
							if(!g.getText().equals("")) {
								System.out.println(g.getText());
							}
						}
					}
				}
			}
		}
		
	}

}
