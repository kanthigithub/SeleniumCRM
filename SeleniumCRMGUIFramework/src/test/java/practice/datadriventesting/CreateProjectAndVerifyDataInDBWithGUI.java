package practice.datadriventesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import com.mysql.jdbc.Driver;

public class CreateProjectAndVerifyDataInDBWithGUI {

	public static void main(String[] args) throws Throwable {
		
		//create project in GUI
		Random r = new Random();
		String projectName = "INSTA_"+(r.nextInt(1000));
		
		WebDriver driver = new EdgeDriver();
		driver.get("http://106.51.90.215:8084");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		driver.findElement(By.linkText("Projects")).click();
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		
		
		driver.findElement(By.name("projectName")).sendKeys(projectName);
		driver.findElement(By.name("createdBy")).sendKeys("deepak");
		Select sel = new Select(driver.findElement(By.xpath("//label[text()='Project Status ']/following-sibling::select[@name='status']")));
		sel.selectByVisibleText("On Going");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		//verify the created project in DB
		boolean flag=false;
	
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		Connection conn = DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333/projects","root@%","root");
		Statement stmt = conn.createStatement();
		
		ResultSet rset = stmt.executeQuery("select * from project");
		
		while(rset.next()) {  //moves to next row returns boolean if rows present 
			String actualProjName = rset.getString(4);
			if (projectName.equals(actualProjName)) {
				System.out.println(projectName+" is available==PASS");
				flag=true;
			}
		}
		if (flag==false) { 
			System.out.println(projectName+" is not available==FAIL");
		}
		
		conn.close();
		
	}

}
