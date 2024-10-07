package practice.testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Practice2 {
	

	@Test
	public void method4() {
		System.out.println("method4");
	}
	
	@AfterMethod
	public void configAM1() {
		System.out.println("AM1--practice");
	}
	
	@BeforeMethod
	public void configBM1() {
		System.out.println("BM1--practice");
	}
	
	@AfterMethod
	public void configAM3() {
		System.out.println("AM3--practice");
	}
	
	@BeforeMethod
	public void configBM2() {
		System.out.println("BM2--practice");
	}
	
	@Test
	public void method3() {
		System.out.println("method3");
	}
	
	@AfterSuite
	public void configAS() {
		System.out.println("AS from practice");
	}
	
	@BeforeSuite
	public void configBS3() {
		System.out.println("BS3--practice");
	}
	
	@AfterMethod
	public void configAM2() {
		System.out.println("AM2--practice");
	}
	
	@BeforeSuite
	public void configBS1() {
		System.out.println("BS1--practice");
	}
	
	@BeforeSuite
	public void configBS2() {
		System.out.println("BS2--practice");
	}	
	
	@BeforeClass
	public void configBC() {
		System.out.println("BC--practice");
	}
	
	@AfterClass
	public void configAC() {
		System.out.println("AC--practice");
	}
	
	@BeforeClass
	public void configBC2() {
		System.out.println("BC2--practice");
	}
	

}
