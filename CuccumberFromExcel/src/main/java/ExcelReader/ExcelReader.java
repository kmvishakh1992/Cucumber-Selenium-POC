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
	/*
	 * public static void main(String[] args) { ExcelReader obj = new ExcelReader();
	 * 
	 * obj.readSheet(0); System.out.println(obj.sentence);
	 * System.out.println(obj.word); }
	 */
	public static final String EXCEL_FILE_NAME = "test.xlsx";
	public static final String SHEET_NAME = "test";
	File file;
	public String word;
	public String sentence;

	private void setFile(String fileName) {
		ClassLoader classLoader = getClass().getClassLoader();
		file = new File(classLoader.getResource(fileName).getFile());

	}

	public void readSheet(int row) {
		try {
			setFile(EXCEL_FILE_NAME);
			FileInputStream excelFile = new FileInputStream(file);
			Workbook workbook = new XSSFWorkbook(excelFile);
			Sheet sheet = workbook.getSheet(SHEET_NAME);
			Row rowid = sheet.getRow(row);
			Cell sentenceCell = rowid.getCell(0);
			Cell wordCell = rowid.getCell(1);
			sentence = sentenceCell.getStringCellValue();
			word = wordCell.getStringCellValue();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}