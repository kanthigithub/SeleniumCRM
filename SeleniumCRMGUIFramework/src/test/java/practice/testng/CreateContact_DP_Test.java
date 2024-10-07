package practice.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContact_DP_Test {
	
	@Test(dataProvider = "getData")
	public void createContact(String cname, String lname) {
		
		System.out.println("contact name: " + cname + ", last name: " + lname);
		
	}
	
	@DataProvider
	public Object[][] getData() {
		
		Object[][] objArr = new Object[3][2];
		
		objArr[0][0] = "Deepak";
		objArr[0][1] = "HR";
		
		objArr[1][0] = "sam";
		objArr[1][1] = "singh";
		
		objArr[2][0] = "Ram";
		objArr[2][1] = "rao";
		
		
		return objArr;
		
	}

}
