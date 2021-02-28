package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDriven {

	
	public XSSFWorkbook wb;
	
	 public ExcelDriven()
	{
		File src=new File("./testdata/testdata.xlsx");
		
		try {
			FileInputStream fis=new FileInputStream(src);
			wb=new XSSFWorkbook(fis);
		}
		catch (Exception e)
		{
			System.out.println("unable to read excel file " +e.getMessage());
		}
	}
	
	
	public String getStringData(String sheetName,int rownum,int colnum)
	{
		return wb.getSheet(sheetName).getRow(rownum).getCell(colnum).getStringCellValue();
	}
	
	public String getNumericgData(String sheetName,int rownum,int colnum)
	{
		
		String name=wb.getSheet(sheetName).getRow(rownum).getCell(colnum).toString();
		 wb.getSheet(sheetName).getRow(rownum).getCell(colnum).getNumericCellValue();
		 
		 return name;
	}
	
	public int rowCount(String sheetName)
	{
		return wb.getSheet(sheetName).getLastRowNum();
	}
	
	public int colCount(String sheetName,int rownum)
	{
		return wb.getSheet(sheetName).getRow(rownum).getLastCellNum();
	}
}
