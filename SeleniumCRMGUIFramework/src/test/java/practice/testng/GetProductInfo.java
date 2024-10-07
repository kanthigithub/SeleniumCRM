package practice.testng;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;

public class GetProductInfo {
	
	@Test(dataProvider = "getData")
	public void getProductInfoTest(String brandName, String prodName) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://amazon.in");
		
		//search brand
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandName, Keys.ENTER);
		
		//capture price of prodName
		String price=driver.findElement(By.xpath("//span[text()='"+prodName+"']/ancestor::div[@class='a-section a-spacing-small a-spacing-top-small']/descendant::span[@class='a-price-whole']")).getText();
		System.out.println("price is: "+price);
		
		driver.quit();
	}
	
	@DataProvider
	public Object[][] getData() throws IOException, Throwable {
		ExcelUtility eLib = new ExcelUtility();
		int r = eLib.getRowCount("AmazonProducts");
		int c = eLib.getColumnCount("AmazonProducts");
		Object[][] objArr = new Object[r][c];
		
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				objArr[i][j] = eLib.getDataFromExcel("AmazonProducts", i+1, j);
			}
			
		}
		
		return objArr;
		
	}

}
