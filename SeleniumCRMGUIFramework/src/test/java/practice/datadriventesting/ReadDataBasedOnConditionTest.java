package practice.datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataBasedOnConditionTest { 

	public static void main(String[] args) throws Throwable, IOException {
		String expectedTestId = "tc_03";
		String data1="",data2="",data3="";
		boolean flag=false;
		
		FileInputStream fis = new FileInputStream("C:\\Users\\srian\\OneDrive\\Desktop\\Kanthi_Classes\\Adv Selenium\\testScriptdata.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh= wb.getSheet("org");		
		int rowCount = sh.getLastRowNum();
		
		for(int i=0;i<=rowCount;i++) {
			String data="";
			try {
				data=sh.getRow(i).getCell(0).toString();
				if(data.equals(expectedTestId)) {
					flag=true;
					data1 = sh.getRow(i).getCell(1).toString();
					data2 = sh.getRow(i).getCell(2).toString();
					data3 = sh.getRow(i).getCell(3).toString();
				}
			}catch (Exception e) {}
		}
		if (flag==true) 
		 System.out.println(data1+"\t"+data2+"\t"+data3);
		else
			System.out.println(expectedTestId+" data is not available");
		wb.close();

	}

}
