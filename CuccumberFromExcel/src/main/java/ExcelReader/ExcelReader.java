package ExcelReader;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	public static void main(String[] args) {
	ExcelReader obj = new ExcelReader();
	obj.getFile("test.xlsx");		
  }

  private void getFile(String fileName) {

	ClassLoader classLoader = getClass().getClassLoader();
	File file = new File(classLoader.getResource(fileName).getFile());
	try {
		FileInputStream excelFile = new FileInputStream(file);
		Workbook workbook =new XSSFWorkbook(excelFile);
		Sheet sheet = workbook.getSheet("test");
		Row row = sheet.getRow(0);
		Cell username=row.getCell(0);
		String uname=username.getStringCellValue();
		System.out.println(uname);
		excelFile.close();
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
  }
}