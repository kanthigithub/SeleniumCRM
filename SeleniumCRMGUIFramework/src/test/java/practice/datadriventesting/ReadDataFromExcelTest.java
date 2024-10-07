package practice.datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.comcast.crm.generic.fileutility.ExcelUtility;

public class ReadDataFromExcelTest {

	public static void main(String[] args) throws Throwable, IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\srian\\OneDrive\\Desktop\\Kanthi_Classes\\Adv Selenium\\testScriptdata.xlsx");
	
		Workbook wb = WorkbookFactory.create(fis);
//		Sheet sh= wb.getSheet("org");		
//		Row r = sh.getRow(1);
//		Cell c= r.getCell(3);
//		String data = c.getStringCellValue();
//		System.out.println(data);

		
		//System.out.println(wb.getSheet("org").getRow(1).getCell(2).getStringCellValue()); //optimized way
		
		//read numeric cell value -- better always store data in string format in excel itself
		
		//System.out.println(wb.getSheet("org").getRow(1).getCell(3).getStringCellValue()); // gives exception when reading int data
		
		//otherwise we can save integer value in double format in excel sheet
		//System.out.println(wb.getSheet("org").getRow(1).getCell(3).getNumericCellValue());
		
		//otherwise you can convert to string what ever the type present in the cell
		System.out.println(wb.getSheet("org").getRow(1).getCell(3).toString());
		
		wb.close();
		
		
		//reading multiple data using excel utility 
		
		ExcelUtility eLib = new ExcelUtility();
		List<String> data = eLib.getMultipleDataFromExcel("productlist");
		
		for(String s: data) {
			System.out.println(s);
			
		}
		
		
		
	}

}
