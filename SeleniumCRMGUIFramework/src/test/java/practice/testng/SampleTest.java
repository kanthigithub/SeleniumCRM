package practice.testng;

import org.testng.annotations.Test;

public class SampleTest {
	
		@Test
		public void test1() {
			System.out.println("execute test");
			test2();
			
		}
		
		@Test
		private void test2() {
			System.out.println("execute update");
		}

}
