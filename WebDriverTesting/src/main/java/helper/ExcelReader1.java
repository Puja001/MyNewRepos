package helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelReader1 {
	
	@Test
	public static void excelData() throws IOException{
		File src = new File("/Users/Praween/Documents/Javacode/WebDriverTesting/resources/signin.xlsx");
		System.out.println("Excel located");
		
		FileInputStream fis= new FileInputStream(src);
		
		 XSSFWorkbook wb= new XSSFWorkbook(fis);
		XSSFSheet sheet1 =wb.getSheetAt(0);
		
		int rowcount=sheet1.getLastRowNum();
		System.out.println("Total row is"+rowcount);
		
		for(int i=0;i<rowcount;i++){
			String data0= sheet1.getRow(i).getCell(0).getStringCellValue();
			System.out.println("Test data From excel is :"+data0);
			
		}
		
	}


}
