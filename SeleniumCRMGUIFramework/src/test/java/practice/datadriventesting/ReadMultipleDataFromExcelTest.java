package practice.datadriventesting;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleDataFromExcelTest {

	public static void main(String[] args) throws Throwable {
		
		FileInputStream fis = new FileInputStream("C:\\Users\\srian\\OneDrive\\Desktop\\Kanthi_Classes\\Adv Selenium\\testScriptdata.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh= wb.getSheet("Sheet2");		
		int rowCount = sh.getLastRowNum();
		for(int i=1;i<=rowCount;i++) { // instead of hard coding of no of rows we can use getLastRowNum method to get no of rows
			Row r = sh.getRow(i);
			String column1Data = r.getCell(0).toString();
			String column2Data = r.getCell(1).toString();
			System.out.println(column1Data+"\t"+column2Data);
		}
		
		wb.close();

	}

}
