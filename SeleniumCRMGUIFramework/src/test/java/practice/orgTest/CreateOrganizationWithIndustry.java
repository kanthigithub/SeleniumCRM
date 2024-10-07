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


public class CreateOrganizationWithIndustry {

	public static void main(String[] args) throws Throwable {
		
		/* This is not a critical test case so it is regression test case*/
		
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
		Row row = sh.getRow(4);
		String orgName = row.getCell(2).toString()+rInt;
		String industry = row.getCell(3).toString();
		String type = row.getCell(4).toString();
		wb.close();
		
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		WebElement weIndustry = driver.findElement(By.name("industry"));
		Select sel1 = new Select(weIndustry);
		sel1.selectByVisibleText(industry);
		
		WebElement weType = driver.findElement(By.name("accounttype"));
		Select sel2 = new Select(weType);
		sel2.selectByVisibleText(type);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//verify the industry and type info 
		String actIndustry = driver.findElement(By.id("dtlview_Industry")).getText();
		if(actIndustry.equals(industry))
			System.out.println(industry+" information is verified==PASS");
		else
			System.out.println(industry+" information is not verified==FAIL");
		
		String actType = driver.findElement(By.id("dtlview_Type")).getText();
		if(actType.contains(type))
			System.out.println(type+" information is verified==PASS");
		else
			System.out.println(type+" type information is not verified==FAIL");
		
		Thread.sleep(2000);
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
				
		driver.quit();
	}

}
