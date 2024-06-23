package com.practiseSelenium2;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class WritingDataIntoExcel {

	@Test
	public void testExcelWriting() throws Exception {

		FileInputStream fis = new FileInputStream("./src/test/Resources/TestExcel.xlsx");

		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Test");

		int noOfRows = sheet.getPhysicalNumberOfRows();
		int noOfColums = sheet.getRow(0).getLastCellNum();

		String[][] data = new String[noOfRows - 1][noOfColums];

		for (int i = 0; i < noOfRows - 1; i++) {
			for (int j = 0; j < noOfColums; j++) {
				DataFormatter df = new DataFormatter();
				data[i][j] = df.formatCellValue(sheet.getRow(i + 1).getCell(j));
			}
		}
//		Printing data read
		for (String[] d : data) {
			for (String d1 : d) {
				System.out.print(d1 + " ");
			}
			System.out.println();
		}
		
//		Writing data
//		FileOutputStream fo = new FileOutputStream("./src/test/Resources/TestExcelSheet.xlsx");
//
//		XSSFWorkbook wb1 = new XSSFWorkbook();
//		XSSFSheet sheet1 = wb.getSheet("Test");
//		sheet1.createRow(3).createCell(0).setCellValue("Abhi");
//		wb1.write(fo);
//		wb1.close();
//		fo.close();
		

		wb.close();
		fis.close();

	}

}
