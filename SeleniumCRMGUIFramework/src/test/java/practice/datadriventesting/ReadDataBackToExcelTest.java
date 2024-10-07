package practice.datadriventesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataBackToExcelTest {

	public static void main(String[] args) throws Throwable, IOException {
		
		FileInputStream fis = new FileInputStream("C:\\Users\\srian\\OneDrive\\Desktop\\Kanthi_Classes\\Adv Selenium\\testScriptdata.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh= wb.getSheet("org");		
		Row r = sh.getRow(1);
		Cell c= r.createCell(4);
		//c.setCellType(CellType.STRING);
		c.setCellValue("FAIL");
		
		FileOutputStream fos = new FileOutputStream("C:\\Users\\srian\\OneDrive\\Desktop\\Kanthi_Classes\\Adv Selenium\\testScriptdata.xlsx");
		wb.write(fos);
		wb.close();
		System.err.println("========executed=======");
	}

}
