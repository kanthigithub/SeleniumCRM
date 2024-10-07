package practice.testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AnnotationPractice {
	
	@Test
	public void method1() {
		System.out.println("method1");
	}
	
	@Test
	public void method2() {
		System.out.println("method2");
	}
	
	@BeforeSuite
	public void configBS() {
		System.out.println("BS--Annotation");
	}
	
	@AfterSuite
	public void configAS() {
		System.out.println("AS from annotation");
	}
	
	
	@AfterSuite
	public void configAS1() {
		System.out.println("AS1 from annotation");
	}
	
	
	@AfterSuite
	public void configAS2() {
		System.out.println("AS2 from annotation");
	}
	
	@BeforeSuite
	public void configBS2() {
		System.out.println("BS2--Annotation");
	}
	
	@BeforeSuite
	public void configBS1() {
		System.out.println("BS1--Annotation");
	}	
	
	@BeforeClass
	public void configBC() {
		System.out.println("BC--Annotation");
	}
	
	@AfterClass
	public void configAC() {
		System.out.println("AC--Annotation");
	}
	
	@BeforeClass
	public void configBC2() {
		System.out.println("BC2--Annotation");
	}
	
	@BeforeSuite
	public void configBS6() {
		System.out.println("BS6--Annotation");
	}
	

}
