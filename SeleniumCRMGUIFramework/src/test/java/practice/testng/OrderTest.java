package practice.testng;

import org.testng.annotations.Test;

public class OrderTest {
	
		@Test
		public void createOrderTest() {

			System.out.println("execute createOrderTest ==> 123");
			//creating exception so depends on method will skip instead of failing
			String str=null;
			//System.out.println(str.equals("123"));
		}
		
		@Test(dependsOnMethods = "createOrderTest")
		public void billingAnOrderTest() {
			
			System.out.println("execute billingAnOrderTest ==> 123");
			
		}
		
		@Test(dependsOnMethods = "billingAnOrderTest")
		public void createInvoiceTest() {
			
			System.out.println("execute createInvoiceTest ==> 123");
			
		}

}
