package practice.datadriventesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ExecuteNonSelectQuery {

	public static void main(String[] args) throws Throwable {
		
					//step1: load / register the database driver
					Driver driverRef = new Driver();
					DriverManager.registerDriver(driverRef);
					
					//step2: connect to database
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tekp","root","root");
					System.out.println("===========done============");
					
					//step3: create sql statement
					Statement stmt = conn.createStatement();
					
					//step4: execute select query & get result
					int res=stmt.executeUpdate("insert into tp07 values(6,'NAM','C++',2)");
					System.out.println(res);
										
					//step5: close the connection
					conn.close();

	}

}
