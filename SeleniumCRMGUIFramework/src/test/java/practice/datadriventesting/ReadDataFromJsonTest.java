package practice.datadriventesting;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadDataFromJsonTest {

	public static void main(String[] args) throws Throwable, IOException, ParseException {
		
		//step1: parse JSON physical file into java object using JSonParse class
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader("C:\\Users\\srian\\OneDrive\\Desktop\\Kanthi_Classes\\Adv Selenium\\jsonCommonData.json"));
				
		//step2: cast the java object into jason object using downcasting 				
		JSONObject jsonObj = (JSONObject)obj;
		
		//step3: read the data using get("key")
		System.out.println(jsonObj.get("url"));
		System.out.println(jsonObj.get("browser"));
		System.out.println(jsonObj.get("username"));
		System.out.println(jsonObj.get("password"));
		System.out.println(jsonObj.get("timeOut"));
	}

}
