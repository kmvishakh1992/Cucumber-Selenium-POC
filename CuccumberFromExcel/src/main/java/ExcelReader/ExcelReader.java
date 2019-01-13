package ExcelReader;


import java.io.File;

public class ExcelReader {
	
	public static void main(String[] args) {
	ExcelReader obj = new ExcelReader();
	obj.getFile("test.xlsx");		
  }

  private void getFile(String fileName) {

	ClassLoader classLoader = getClass().getClassLoader();
	File file = new File(classLoader.getResource(fileName).getFile());

	
  }
}