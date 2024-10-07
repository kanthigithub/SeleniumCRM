package practice.testng;

import org.testng.annotations.Test;

public class OrderTest2 {
	
		@Test(invocationCount = 10)
		public void createOrderTest() {

			System.out.println("execute createOrderTest ==> 123");

		}
		
		@Test(enabled=false)
		public void createOrderTest2() { 
			// instead of invocation if we use for loop to run script 10 times drawback is there
			for(int i=1;i<=10;i++) {
				System.out.println("execute createOrderTest ==> 456");
				// there is a problem in 6th iteration then remaining iterations wont execute
				if (i==6) 
					break;
			}
		}

}
