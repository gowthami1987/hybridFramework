package excelExportAndFileIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadGuru99ExcelFile {
	
	public Sheet readExcel(String filePath,String sheetName) throws IOException{
	File file =	new File(filePath);
	FileInputStream inputStream = new FileInputStream(file);
	Workbook guru99Workbook = null;

	//String fileExtensionName = fileName.substring(fileName.indexOf("."));

	/*if(fileExtensionName.equals(".xlsx")){
	guru99Workbook = new XSSFWorkbook(inputStream);
	}*/
		guru99Workbook = new XSSFWorkbook(inputStream);

	/*else if(fileExtensionName.equals(".xls")){
		//If it is xls file then create object of XSSFWorkbook class
		guru99Workbook = new HSSFWorkbook(inputStream);
	}*/

	Sheet  guru99Sheet = guru99Workbook.getSheet(sheetName);
	 return guru99Sheet;	
	}
}
