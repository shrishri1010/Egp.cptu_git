package com.egp.qa.helper.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.egp.qa.helper.logger.LoggerHelper;
import com.egp.qa.helper.resource.ResourceHelper;



public class ExcelHelper {
	
	private Logger log = LoggerHelper.getLogger(ExcelHelper.class);
	static Workbook book;
	static org.apache.poi.ss.usermodel.Sheet sheet;
	
	//Bhanu pratap excel method
	/*public Object[][] getExcelData(String excelLocation, String sheetName) {
		try {
			Object dataSets[][] = null;
			FileInputStream file = new FileInputStream(new File(excelLocation));
			//Create Workbook instance
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			
			//Get sheetName from workbook
			XSSFSheet sheet = workbook.getSheet(sheetName);
			
			//count number of active rows in excel sheet
			int totalRow = sheet.getLastRowNum();
			System.out.println("total no. of rows -->>"+ totalRow);
			
			//count active coloumns in row
			int totalColumn = sheet.getRow(0).getLastCellNum();
			
			dataSets = new Object[totalRow][totalColumn-1];
			
			//Iterate through each Rows one by one
			Iterator<Row> rowIterator = sheet.iterator();
			int i=0;
			while (rowIterator.hasNext()) {
				i++;
				//For every row, we need to iterate over coloumns
				Row row = rowIterator.next();
				//iterates through cells
				Iterator<Cell> cellIterator = row.cellIterator();
				int j=0;
				while (cellIterator.hasNext()) {
					//j++;
					Cell cell = cellIterator.next();
					if (cell.getStringCellValue().contains("Start")) {
						i=0;
						break;
					}
					//getCellTypeEnum means what kind of data in the cell
					switch (cell.getCellTypeEnum()) {
						case STRING:
						dataSets[i-1][j++] = cell.getStringCellValue();
						System.out.println("data sets are --->>> "+cell.getStringCellValue());
						break;
						
						case NUMERIC:
						dataSets[i-1][j++] = cell.getNumericCellValue();
						break;
						
						case BOOLEAN:
						dataSets[i-1][j++] = cell.getBooleanCellValue();
						break;
						
						case FORMULA:
						dataSets[i-1][j++] = cell.getCellFormula();
						break;	
						
						default:
							System.out.println("no matching enum data type found");
							break;
					}
				}
			}
			return dataSets;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}*/
	
	
	//Naveen excel method
	public static Object[][] getExcelData(String excelLocation, String sheetName) {
		FileInputStream file = null;
		try {
			file=new FileInputStream(excelLocation);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		}catch (InvalidFormatException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		//i for row 
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			// k for coloumn
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i+1).getCell(k).toString();
				//System.out.println("data " + data[i][k]);
			}
		}
		return data;
	}
	
	
	public void updateResult(String excelLocation, String sheetName, String testCaseName, String testStatus) {
		try {
			FileInputStream file = new FileInputStream(new File(excelLocation));
			//Create Workbook instance
			HSSFWorkbook workbook = new HSSFWorkbook(file);
			
			//Get sheetName from workbook
			HSSFSheet sheet = workbook.getSheet(sheetName);
			
			//count number of active rows in excel sheet
			int totalRow = sheet.getLastRowNum()+1;
			System.out.println("total no. of rows -->>"+ totalRow);
			
			for (int i = 1; i < totalRow; i++) {
				HSSFRow r= sheet.getRow(i);
				String ce = r.getCell(0).getStringCellValue();
				if (ce.contains(testCaseName)) {
					r.createCell(1).setCellValue(testStatus);
					file.close();
					log.info("result updated..");
					FileOutputStream out = new FileOutputStream(new File(excelLocation));
					workbook.write(out);
					out.close();
					break;
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		ExcelHelper excelHelper = new ExcelHelper();
		String excelLocation = ResourceHelper.getResourcePath("src/main/resources/configfile/EgpTestData.xlsx");
		Object[][] data = excelHelper.getExcelData(excelLocation, "loginData");
		System.out.println(data);
		//excelHelper.updateResult(excelLocation, "TestScripts", "Login", "PASS");
		//excelHelper.updateResult(excelLocation, "TestScripts", "Registration", "FAIL");
		//excelHelper.updateResult(excelLocation, "TestScripts", "Login", "PASS");
	}
}
