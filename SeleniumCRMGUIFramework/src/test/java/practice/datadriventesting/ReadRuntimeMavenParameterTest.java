package practice.datadriventesting;

import org.testng.annotations.Test;

public class ReadRuntimeMavenParameterTest {
	
	@Test
	public void runtimeParameterTest() {
		
		String URL=System.getProperty("url");  //capture the data from commandline in runtime
		String BROWSER=System.getProperty("browser"); 
		String USERNAME=System.getProperty("un"); 
		String PASSWORD=System.getProperty("pwd"); 
		
		System.out.println("Env Data==>URL==>"+URL);
		System.out.println("Browser Data==>==>"+BROWSER);
		System.out.println("Username Data==>==>"+USERNAME);
		System.out.println("Password Data==>URL==>"+PASSWORD);
	}

}
