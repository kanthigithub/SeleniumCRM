package practice.contactTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateContactWithOrgTest {

	public static void main(String[] args) throws Throwable {
		
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
		Sheet sh = wb.getSheet("contact");
		Row row = sh.getRow(7);
		String orgName = row.getCell(2).toString()+rInt;
		String contactLastName = row.getCell(3).getStringCellValue();
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
		String actOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText().trim();
		if(actOrgName.equals(orgName))
			System.out.println(orgName+" information is verified==PASS");
		else
			System.out.println(orgName+" information is not verified==FAIL");
		
		//navigate to Contacts major tab
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		//enter details
		driver.findElement(By.name("lastname")).sendKeys(contactLastName);
		driver.findElement(By.xpath("//input[@name='account_id']/following-sibling::img[@title='Select']")).click();
		
		//switch to child window
		Set<String> set1 = driver.getWindowHandles();
		Iterator<String> it1 = set1.iterator();
		while(it1.hasNext()) {
			String winId = it1.next();
			driver.switchTo().window(winId);
			String thisUrl =  driver.getCurrentUrl();
			if(thisUrl.contains("module=Accounts")) {
				
				break;
			}
			
		}
		
		
		driver.findElement(By.name("search_text")).sendKeys(orgName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		
		//switch to parent window
		Set<String> set2 = driver.getWindowHandles();
		Iterator<String> it2 = set2.iterator();
		while(it2.hasNext()) {
			String winId = it2.next();
			driver.switchTo().window(winId);
			String thisUrl =  driver.getCurrentUrl();
			if(thisUrl.contains("Contacts&action")) {				
				break;
			}
	
		}
		/*
		//switch to parent window
		Set<String> set2 = driver.getWindowHandles();
		for(String winId:set2) {			
			String thisUrl = driver.getCurrentUrl();
			if(thisUrl.contains("Contacts&action")) {
				driver.switchTo().window(winId);
				break;
			}
			
		}*/
				
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//verify header msg name expected result
		String headerInfo2 = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(headerInfo2.contains(contactLastName))
			System.out.println(contactLastName + " is created==PASS");
		else
			System.out.println(contactLastName + " is not created==FAIL");
		
		//verify last name info expected result
		String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();
		if(actLastName.equals(contactLastName))
			System.out.println(contactLastName+" information is verified==PASS");
		else
			System.out.println(contactLastName+" information is not verified==FAIL");
		
		
				
		Thread.sleep(2000);
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
		driver.quit();
		

	}

}
