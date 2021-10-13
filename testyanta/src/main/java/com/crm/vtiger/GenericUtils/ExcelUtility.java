package com.crm.vtiger.GenericUtils;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.internal.objects.IObjectDispenser;

public class ExcelUtility {
	

		/*
		 * @author divya
		 */
		/**
		 * This method is used to read the data from excel by specifying sheet number, row number and cell number
		 * @param sheetname
		 * @param rownum
		 * @param cellnum
		 * @return
		 * @throws Throwable
		 */
		public String getExceData(String sheetname,int rownum,int cellnum) throws Throwable {
			
			FileInputStream fis=new FileInputStream(IPathConstant.EXCELPATH);
			Workbook workbook = WorkbookFactory.create(fis);
			Sheet sheet = workbook.getSheet(sheetname);
			Row row = sheet.getRow(rownum);
			Cell cell = row.getCell(cellnum);
			return cell.getStringCellValue();
		}

		
		/**
		 * This is method return all the data in the sheet
		 * @param sheetName
		 * @return
		 * @throws Throwable 
		 * @throws Throwable
		 */
		public Object[][] getExcelData(String sheetName) throws Throwable{
			
			FileInputStream file = new FileInputStream(IPathConstant.EXCELPATH);
			Workbook workbook = WorkbookFactory.create(file);
			Sheet sheet = workbook.getSheet(sheetName);
			int lastRow = sheet.getLastRowNum();
			int lastCell = sheet.getRow(0).getLastCellNum();
			Object[][] data=new Object[lastRow][lastCell];
			for(int i=0; i<lastRow; i++) {
				for(int j=0; j<lastCell; j++) {
					data[i][j]=sheet.getRow(i+1).getCell(j).getStringCellValue();
				}
			}
			return data;
		}
		/**
		 * This method is used to write the data inside the excel sheet
		 * @param sheetname
		 * @param rownum
		 * @param column
		 * @param value
		 * @throws Throwable
		 */
		public void writeExcelData(String sheetname, int rownum, int column, String value) throws Throwable {
			FileInputStream file=new FileInputStream(IPathConstant.EXCELPATH);
			Workbook workbook = WorkbookFactory.create(file);
			workbook.createSheet(sheetname).createRow(rownum).createCell(column).setCellValue(value);
			FileOutputStream writeFile=new FileOutputStream(IPathConstant.EXCELPATH);
			workbook.write(writeFile);
			
		}
		
	}
	
	

