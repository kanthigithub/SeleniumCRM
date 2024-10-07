package practice.datadriventesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ExecuteSelectQueryTest {

	public static void main(String[] args) throws SQLException {
		
		Connection conn=null;
		try {
			//step1: load / register the database driver
			Driver driverRef = new Driver();
			DriverManager.registerDriver(driverRef);
			
			//step2: connect to database
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tekp","root","root");
			System.out.println("===========done============");
			
			//step3: create sql statement
			Statement stmt = conn.createStatement();
			
			//step4: execute select query & get result
			ResultSet rset = stmt.executeQuery("select * from tp07");
			while(rset.next()) {  //moves to next row returns boolean if rows present and
				System.out.println(rset.getString(1)+"\t"+rset.getString(2)+"\t"+rset.getString(3)+"\t"+rset.getString(4));
			}
		}
		catch(Exception e) {
			System.out.println("handle exception");
		}
		finally {
			//step5: close the connection
			System.out.println("finally block");
			conn.close();
		}
	}

}