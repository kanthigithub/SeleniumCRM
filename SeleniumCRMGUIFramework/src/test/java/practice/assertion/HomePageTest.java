package practice.assertion;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomePageTest {
	
	@Test
	public void verifyHomePageTest() {

		SoftAssert sa = new SoftAssert(); 
		System.out.println("verifyHomePage--start");
		System.out.println("step1");
		System.out.println("step2");
		sa.assertEquals("Home", "Home1");
		System.out.println("step3");
		sa.assertEquals("again", "again1");
		System.out.println("step4");
		sa.assertAll();
		System.out.println("verifyHomePage--end");
		
	}
	
	@Test
	public void verifyLogoInHomePageTest() {
		
		SoftAssert sa = new SoftAssert(); 
		System.out.println("verifyLogo--start");
		System.out.println("step1");
		sa.assertEquals("Logo", "Logo");
		System.out.println("step2");
		System.out.println("step3");
		System.out.println("step4");
		System.out.println("verifyLogo--end");
	}

}
