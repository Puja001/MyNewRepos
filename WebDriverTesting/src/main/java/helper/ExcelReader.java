package helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;



public class ExcelReader {
	
	@Test
	public static void excelData() throws IOException{
		File src = new File("/Users/Praween/Documents/Javacode/WebDriverTesting/resources/signin.xlsx");
		System.out.println("Excel located");
		
		FileInputStream fis= new FileInputStream(src);
		
		 XSSFWorkbook wb= new XSSFWorkbook(fis);
		XSSFSheet sheet1 =wb.getSheetAt(0);
		
		String data0=sheet1.getRow(0).getCell(0).getStringCellValue();
		System.out.println("Data from Excel :"+data0);
		
		String data1=sheet1.getRow(0).getCell(1).getStringCellValue();
		System.out.println("Data from Excel :"+data1);
	}



}

