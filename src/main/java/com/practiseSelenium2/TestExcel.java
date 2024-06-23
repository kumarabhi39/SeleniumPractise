package com.practiseSelenium2;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestExcel {
	
	@Test(dataProvider="testData")
	public void test1(Object[] o) {
	
		for (Object obj : o) {
			System.out.print(obj+" ");
		}
		System.out.println();
		
	}

	//This can be now treated as a dataprovider
	@DataProvider(name="testData", parallel=true)
	public Object[][] testExcelData() throws IOException {

//		File file = new File("./src/test/Resources/TestExcelSheet.xlsx");
		FileInputStream fis = new FileInputStream("./src/test/Resources/TestExcel.xlsx");

		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Test");

		int noOfRows = sheet.getPhysicalNumberOfRows();
		int noOfColums = sheet.getRow(0).getLastCellNum();

		String[][] data = new String[noOfRows - 1][noOfColums];

		for (int i = 0; i < noOfRows-1; i++) {
			for (int j = 0; j < noOfColums; j++) {
				DataFormatter df = new DataFormatter();
				data[i][j] = df.formatCellValue(sheet.getRow(i+1).getCell(j));
			}
		}

//		for (String[] datum : data) {
//			for (String datumm : datum) {
//				System.out.print(datumm+" ");
//			}
//			System.out.println();
//		}
		wb.close();
		fis.close();
		return data;
	}
}