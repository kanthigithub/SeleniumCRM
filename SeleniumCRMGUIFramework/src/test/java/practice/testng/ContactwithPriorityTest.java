package practice.testng;

import org.testng.annotations.Test;

public class ContactwithPriorityTest {
	
		@Test(priority=1)
		public void createContactTest() {
			
			System.out.println("execute createContact with HDFC");
				
		}
		
		@Test(priority=2)
		public void modifyContactTest() {
			// doing this in GUI takes time so use JDBC and insert data into table ,so exec of TS will be faster
			//System.out.println("execute createContact with ICICI");  
			System.out.println("execute query to create contact for ICICI");
			System.out.println("modify contact ICICI to SBI");
			
		}
		
		@Test(priority=3)
		public void deleteContactTest() {
			
			//System.out.println("execute createContact with UPI");
			System.out.println("execute query to create contact for UPI");
			System.out.println("delete contact with UPI");
			
		}
		

}
