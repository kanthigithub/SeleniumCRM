package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String getDataFromExcel(String sheetName, int rowNum, int colNum) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream("./testdata/testScriptdata.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
//		String data = wb.getSheet(sheetName).getRow(rowNum).getCell(colNum).getStringCellValue();
//		wb.close();
//		return data;
		
		Cell cell = wb.getSheet(sheetName).getRow(rowNum).getCell(colNum);
		DataFormatter df = new DataFormatter();
		String data = df.formatCellValue(cell);
		wb.close();
		return data;
	}
	
	public String getPhoneNumFromExcel(String sheetName, int rowNum, int colNum) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream("./testdata/testScriptdata.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		Cell cell = wb.getSheet(sheetName).getRow(rowNum).getCell(colNum);
		DataFormatter df = new DataFormatter();
		String data = df.formatCellValue(cell);
		wb.close();
		return data;
	}
	
	public int getNumDataFromExcel(String sheetName, int rowNum, int colNum) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream("./testdata/testScriptdata.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		Cell cell = wb.getSheet(sheetName).getRow(rowNum).getCell(colNum);
		int data = (int) cell.getNumericCellValue();
		wb.close();
		return data;
	}
	
	public int getRowCount(String sheetName) throws Throwable, IOException {
		
		FileInputStream fis = new FileInputStream("./testdata/testScriptdata.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		int rowCount = wb.getSheet(sheetName).getLastRowNum();
		wb.close();
		
		return rowCount;
	}
	
	public int getColumnCount(String sheetName) throws Throwable, IOException {
		
		FileInputStream fis = new FileInputStream("./testdata/testScriptdata.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		int colCount = wb.getSheet(sheetName).getRow(0).getLastCellNum();
		wb.close();
		
		return colCount;
	}
	
	public void setDataIntoExcel(String sheetName, int rowNum, int colNum, String data ) throws  Throwable {
		
		FileInputStream fis = new FileInputStream("./testdata/testScriptdata.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(rowNum).createCell(colNum).setCellValue(data);
		
		FileOutputStream fos = new FileOutputStream("./testdata/testScriptdata.xlsx");
		wb.write(fos);
		wb.close();
		
	}
	

	public List<String> getMultipleDataFromExcel(String sheetName) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream("./testdata/testScriptdata.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
//		String data = wb.getSheet(sheetName).getRow(rowNum).getCell(colNum).getStringCellValue();
//		wb.close();
//		return data;
		
		Sheet sh = wb.getSheet(sheetName);
		int rowCount = sh.getLastRowNum();
		int columnCount = sh.getRow(0).getLastCellNum();
		String temp = "";
		ArrayList<String> multipleData = new ArrayList<String>();
		for(int i=0;i<rowCount;i++) {
			String data = "";
			for(int j=0;j<columnCount;j++) {
				
				temp = sh.getRow(i+1).getCell(j).getStringCellValue(); 
				data = data + " " + temp;				
			}
			multipleData.add(data);
		}
		
		wb.close();
		return multipleData;
	}
	
	
}
