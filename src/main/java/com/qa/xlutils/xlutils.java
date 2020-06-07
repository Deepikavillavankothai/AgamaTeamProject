package com.qa.xlutils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class xlutils {
	FileInputStream fil;
	XSSFWorkbook workbook;
	 XSSFSheet sheet;
	 XSSFRow row;
	 XSSFCell cell;
	
	public int getRowCount(String Xlpath,String Sheet) throws IOException {
		File fs = new File(Xlpath);
		fil =  new FileInputStream(fs);
		workbook=new XSSFWorkbook(fil);
		sheet=workbook.getSheet(Sheet);
		int rowcnt = sheet.getLastRowNum();
		
		return rowcnt;
	}
	
	public int getcellCount(String Xlpath,String Sheet,int rownum) throws IOException {
		File fs = new File(Xlpath);
		fil =  new FileInputStream(fs);
		workbook=new XSSFWorkbook(fil);
		sheet=workbook.getSheet(Sheet);
		row= sheet.getRow(rownum);
		int cellcount = row.getLastCellNum();
		return cellcount;
	}
	
	public String getCelldata(String Xlpath,String Sheet,int rownum,int colnum) throws IOException {
		fil=new FileInputStream(Xlpath);
		workbook=new XSSFWorkbook(fil);
		sheet=workbook.getSheet(Sheet);
		row=sheet.getRow(rownum);
		cell=row.getCell(colnum);
		String data;
		try 
		{
			DataFormatter formatter = new DataFormatter();
            String cellData = formatter.formatCellValue(cell);
            return cellData;
		}
		catch (Exception e) 
		{
			data="";
		}
		workbook.close();
		fil.close();
		return data;
		
	}	
}
