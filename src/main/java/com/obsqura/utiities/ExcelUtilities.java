package com.obsqura.utiities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import com.obsqura.constants.Constants;

public class ExcelUtilities {
	
	public FileInputStream fis;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle style;
	String path=Constants.EXCEL_FILE_PATH;
	
	
	public ExcelUtilities() {

 		this.path=path;
 		try {
 			fis = new FileInputStream(path);
 			workbook = new XSSFWorkbook(fis);
 			sheet = workbook.getSheetAt(0);
 			fis.close();
 		} catch (Exception e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
 	}
	
	
	
	public ExcelUtilities(String path) {
		this.path=path;
	}
	public int getRowCount(String sheetName) throws Throwable
	{
    fis= new FileInputStream(path);
	workbook=new XSSFWorkbook(fis);
	sheet=workbook.getSheet(sheetName);
	int rowCount=sheet.getLastRowNum();
	workbook.close();
	fis.close();
	return rowCount;
		
	}
	public int getCellCount(String sheetName,int rownum) throws Throwable
	{
    fis= new FileInputStream(path);
	workbook=new XSSFWorkbook(fis);
	sheet=workbook.getSheet(sheetName);
	row=sheet.getRow(rownum);
	int CellCount=row.getLastCellNum();
	workbook.close();
	fis.close();
	return CellCount;
		
	}
	
	public String getCellData(String sheetName,int rownum,int colum) throws Throwable
	{
    fis= new FileInputStream(path);
	workbook=new XSSFWorkbook(fis);
	sheet=workbook.getSheet(sheetName);
	row=sheet.getRow(rownum);
	cell=row.getCell(colum);
	
	DataFormatter formatter=new DataFormatter();
	String data;
	try {
	data=formatter.formatCellValue(cell);
	}
	catch(Exception e) {
	data="";
	}
	workbook.close();
	fis.close();
	return data;
		
	}

	public void selectExcelFile(String workBookName, String sheetName) {
		try {
			String path = Constants.EXCEL_FILE_PATH;
			File src = new File(path);
			FileInputStream fi = new FileInputStream(src);
			workbook = new XSSFWorkbook(fi);
			sheet = workbook.getSheet(sheetName);

		} catch (Exception e) {

		}

	}
	
	
	
	
	
	
	
	
	
}


