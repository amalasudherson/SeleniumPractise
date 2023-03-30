package Generic_Utility;

import java.io.FileInputStream;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.google.common.collect.Table.Cell;

public abstract class Excel_Utility {
	public String getExcelData(String sheetName,int rowNum,int cellNum)
	
	
	FileInputStream fes=new FileInputStream("C:\\\\\\\\Users\\\\\\\\AmalaS\\\\\\\\Documents\\\\\\\\SeleniumData\\\\\\\\ExcelSheetData.xlsx");
	Workbook book = WorkbookFactory.create(fes);
	private String sheetName;
	Sheet sheet = (Sheet) book.getSheet(sheetName);
	Row row = sheet.getRow(rowNum);
	Cell cell = row.getCell(cellNum);
	String value = cell.getStringCellValue();
	return value;
	}


public String getExcelDataFromatter(String sheeetName,int rowNum,int cellNum) throws Throwable
{
	FileInputStream fes=new FileInputStream("C:\\\\Users\\\\AmalaS\\\\Documents\\\\SeleniumData\\\\ExcelSheetData.xlsx");
	Workbook book = WorkbookFactory.create(fes);
	DataFormatter format=new DataFormatter();
	format.formatCellValue(book.getSheet(sheetName).getRow(rowNum).getCell(cellNum));
	return data;
}