package com.comcast.crm.generic.fileutility;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonUtility {
	
	public String getDataFromJsonFile(String key) throws Throwable {
		
		FileReader fileR = new FileReader("./configAppData/jsonCommonData.json");
		
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(fileR);
		
		JSONObject jsonObj = (JSONObject)obj;
		
		String value = jsonObj.get(key).toString();
		
		return value;
	}

}
