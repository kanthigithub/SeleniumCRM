package practice.orgTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class CreateOrganizationTest {

	public static void main(String[] args) throws Throwable {
		
		/* This is a critical test case so it is smoke test case*/
		
		//read common data from properties file
		FileInputStream fis = new FileInputStream("C:\\Users\\srian\\OneDrive\\Desktop\\Kanthi_Classes\\Adv Selenium\\commondata.properties.txt");
		Properties prop = new Properties();
		prop.load(fis);
		String BROWSER = prop.getProperty("browser");
		String URL = prop.getProperty("url");
		String USERNAME = prop.getProperty("username");
		String PASSWORD = prop.getProperty("password");
		
		WebDriver driver=null;
		
		if (BROWSER.equals("chrome"))
			driver = new ChromeDriver();
		else if (BROWSER.equals("edge"))
			driver = new EdgeDriver();
		else if (BROWSER.equals("firefox"))
			driver = new FirefoxDriver();
		else
			driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		//login to application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//navigate to Organizations major tab
		driver.findElement(By.linkText("Organizations")).click();
		//click on create organization button
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		//generate random number
		Random r = new Random();
		int rInt = r.nextInt(1000);
		
		//enter all details -- read from excel
		FileInputStream fis1 = new FileInputStream("C:\\Users\\srian\\OneDrive\\Desktop\\Kanthi_Classes\\Adv Selenium\\testScriptdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("org");
		Row row = sh.getRow(1);
		String orgName = row.getCell(2).toString()+rInt;
		wb.close();
		
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//verify Header msg expected result
		String headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(headerInfo.contains(orgName))
			System.out.println(orgName + " is created==PASS");
		else
			System.out.println(orgName + " is not created==FAIL");
		
		//verify Header orgName info expected result
		String actOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText();
		if(actOrgName.equals(orgName))
			System.out.println(orgName+" information is verified==PASS");
		else
			System.out.println(orgName+" information is not verified==FAIL");
		
				
		Thread.sleep(2000);
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
		driver.quit();
	}

}
