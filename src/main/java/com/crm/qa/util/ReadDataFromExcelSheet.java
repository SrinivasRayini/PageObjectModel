package com.crm.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelSheet {
	static Workbook book;
	static Sheet sheet;
	static String sheetname = "contacts";

	static String path="E:\\Java\\Selenium\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\testdata\\TestData.xlsx";

	public static void main(String[] args) {
		
		System.out.println(TestDataTest().toString());
	}
	public static Object[][] TestDataTest() {
		FileInputStream file = null;
		try {
			file = new FileInputStream(path);
		}
		catch(FileNotFoundException fnf) {
			fnf.printStackTrace();
		}

		try {
			book = WorkbookFactory.create(file);
		}
		catch(IOException ioe) {
			ioe.printStackTrace();
		}
		catch(EncryptedDocumentException e) {
			e.printStackTrace();
		}

		sheet = book.getSheet(sheetname);

		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		System.out.println(sheet.getLastRowNum() +" *"+ sheet.getRow(0).getLastCellNum() );

		for(int i=0;i<sheet.getLastRowNum();i++) {
			for(int j=0; j<sheet.getRow(0).getLastCellNum();j++) {
				data[i][j] = sheet.getRow(i+1).getCell(j).toString();
				System.out.println(data[i][j]);
			}//for
		}//for
		
		return data;
	}



}
