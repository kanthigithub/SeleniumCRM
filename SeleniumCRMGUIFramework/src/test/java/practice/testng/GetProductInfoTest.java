package practice.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GetProductInfoTest {
	
	@Test(dataProvider = "getData")
	public void getProductInfoTest(String cname, String lname, long phone) {
		
		System.out.println("contact name: " + cname + ", last name: " + lname+", phone: "+phone);
		
	}
	
	@DataProvider
	public Object[][] getData() {
		
		Object[][] objArr = new Object[3][3];
		
		objArr[0][0] = "Deepak";
		objArr[0][1] = "HR";
		objArr[0][2] = 9898981111l;
		
		objArr[1][0] = "sam";
		objArr[1][1] = "singh";
		objArr[1][2] = 9898981222l;
		
		objArr[2][0] = "Ram";
		objArr[2][1] = "rao";
		objArr[2][2] = 9898981333l;
		
		
		return objArr;
		
	}

}
