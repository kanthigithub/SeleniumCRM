package practice.testng;

import org.testng.annotations.Test;

public class ContactTest {
	
		@Test
		public void createContactTest() {
			//write one complete M.T.C in one testng method itself
			System.out.println("login to app");
			System.out.println("navigate to contact page");
			System.out.println("execute createContact ");
			System.out.println("execute verify contact ");
			System.out.println("logout");
			
		}
		
		@Test
		public void createContactwithPhoneTest() {
			
			System.out.println("execute createContact with phone num Test");
			
		}
		

}
