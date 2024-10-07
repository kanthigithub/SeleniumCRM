package practice.testng;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SampleReportTest {
	
	public ExtentReports report;
	
	@BeforeSuite
	public void configBS() {
		
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvancedReports/report.html");
		spark.config().setDocumentTitle("CRM application");
		spark.config().setReportName("Contact Module report");
		spark.config().setTheme(Theme.DARK);
		
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "WINDOWS12");
		report.setSystemInfo("BROWSER", "chrome");
		
		
	}
	
	@AfterSuite
	public void configAS() {
		
		report.flush();
	}
	
	@Test
	public void createContactTest() {
		

		
		ExtentTest test = report.createTest("createContactTest");
		
		test.log(Status.INFO, "login to app");
		test.log(Status.INFO, "navigate to contact page");
		test.log(Status.INFO, "create new contact");
		if("HDFC".equals("HDFC")) {
			test.log(Status.PASS, "created");
		}
		else {
			test.log(Status.FAIL, "not created");
		}

	}
	
	@Test
	public void createContactwithOrgTest() {
		

		
		ExtentTest test = report.createTest("createContactwithOrgTest");
		
		test.log(Status.INFO, "login to app");
		test.log(Status.INFO, "navigate to contact page");
		test.log(Status.INFO, "create new contact");
		if("HDFC".equals("HDFC1")) {
			test.log(Status.PASS, "created");
		}
		else {
			test.log(Status.FAIL, "not created");
		}

	}
	
	@Test
	public void createContactwithPhTest() {
		

		
		ExtentTest test = report.createTest("createContactwithPhTest");
		
		test.log(Status.INFO, "login to app");
		test.log(Status.INFO, "navigate to contact page");
		test.log(Status.INFO, "create new contact");
		if("HDFC".equals("HDFC")) {
			test.log(Status.PASS, "created");
		}
		else {
			test.log(Status.FAIL, "not created");
		}

	}

}
