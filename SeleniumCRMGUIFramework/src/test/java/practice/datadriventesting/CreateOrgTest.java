package practice.datadriventesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import com.google.common.collect.Table.Cell;

public class CreateOrgTest {
	
	@Test 
	public void createOrgTest(XmlTest test) throws Throwable {
		
		/*
		// read common data from CMD line
		String URL=System.getProperty("url");  //capture the data from commandline in runtime
		String BROWSER=System.getProperty("browser"); 
		String USERNAME=System.getProperty("username"); 
		String PASSWORD=System.getProperty("password"); 
		*/
		
		/*
		//read common data from JSON file
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader("C:\\Users\\srian\\OneDrive\\Desktop\\Kanthi_Classes\\Adv Selenium\\jsonCommonData.json")); 				
		JSONObject jsonObj = (JSONObject)obj;		
		String BROWSER = jsonObj.get("browser").toString();
		String URL = jsonObj.get("url").toString();
		String USERNAME = jsonObj.get("username").toString();
		String PASSWORD = jsonObj.get("password").toString();
		*/
		/*
		//read common data from properties file
		FileInputStream fis = new FileInputStream("C:\\Users\\srian\\OneDrive\\Desktop\\Kanthi_Classes\\Adv Selenium\\commondata.properties.txt");
		Properties prop = new Properties();
		prop.load(fis);
		String BROWSER = prop.getProperty("browser");
		String URL = prop.getProperty("url");
		String USERNAME = prop.getProperty("username");
		String PASSWORD = prop.getProperty("password");
		*/
		
		//read common data from xml file
		String URL= test.getParameter("url");
		String BROWSER=test.getParameter("browser"); 
		String USERNAME=test.getParameter("username"); 
		String PASSWORD=test.getParameter("password"); 
		
		WebDriver driver = null;
		
		if(BROWSER.equals("chrome")){
			driver = new ChromeDriver();			
		}
		else if(BROWSER.equals("edge")) {
			driver = new EdgeDriver();			
		}
		else if(BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		else {
			driver = new ChromeDriver();
			
		}
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();;
		
		driver.findElement(By.linkText("Organizations")).click();
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		

		//generate random number
		Random random = new Random();
		int randomInt = random.nextInt(1000);
		
		//read test script data from excel
		FileInputStream fis1 = new FileInputStream("C:\\Users\\srian\\OneDrive\\Desktop\\Kanthi_Classes\\Adv Selenium\\testScriptdata.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis1);
		String ORGNAME = wb.getSheet("org").getRow(1).getCell(2).toString()+randomInt;
				
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
				
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Thread.sleep(2000);
		if(driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText().contains(ORGNAME))
			System.out.println("Organization created:- "+ORGNAME);
		else
			System.out.println("Organization not created");
		
		Thread.sleep(2000);
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		driver.quit();
	}

}
