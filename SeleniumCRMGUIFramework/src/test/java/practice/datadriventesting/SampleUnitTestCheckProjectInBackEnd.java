package practice.datadriventesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class SampleUnitTestCheckProjectInBackEnd {
	
	@Test 
	public void projectCheckTest() throws Throwable {
		
		String expectedProjName = "FB";
		boolean flag=false;
		//step1: load / register the database driver
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		
		//step2: connect to database
		Connection conn = DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333/projects","root@%","root");
				
		//step3: create sql statement
		Statement stmt = conn.createStatement();
		
		//step4: execute select query & get result
		ResultSet rset = stmt.executeQuery("select * from project");
		while(rset.next()) {  //moves to next row returns boolean if rows present 
			String actualProjName = rset.getString(4);
			if (expectedProjName.equals(actualProjName)) {
				System.out.println(expectedProjName+" is available==PASS");
				flag=true;
			}
		}
		if (flag==false) { 
			//even though expected proj name is not available in database testcase wont fail 
			//becoz java prg is working fine so we have to use assertion to fail the test script
			System.out.println(expectedProjName+" is not available==FAIL");
			Assert.fail();
		}
		//step5: close the connection
		conn.close();


	}

}
