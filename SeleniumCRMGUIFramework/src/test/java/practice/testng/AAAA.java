package practice.testng;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AAAA {
	
	@Test
	public void method4() {
		System.out.println("method4");
	}
	
	@BeforeSuite
	public void configBS() {
		System.out.println("BS--AAAA ");
	}

	@AfterSuite
	public void configAS() {
		System.out.println("AS from AAAA");
	}
	
}
