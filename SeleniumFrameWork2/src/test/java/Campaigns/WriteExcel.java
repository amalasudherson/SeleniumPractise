package Campaigns;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.google.common.collect.Table.Cell;

public class WriteExcel {
	public static void main(String excelPath,String SheetName,int rowNumber,int column)  {
		try {
		File file=new File(excelPath);
		
		XSSFWorkbook wb=new XSSFWorkbook();
		
		XSSFSheet sheet=wb.getSheet(SheetName);
		
		XSSFRow row=sheet.getRow(rowNumber);
		
		int columnNumber = 0;
		XSSFCell cell=row.getCell(columnNumber,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
		
		Date data = null;
		if(cell==null){
			row.createCell(columnNumber);
			
			cell.setCellValue(data);
		}
			else {
				cell.setCellValue(data);
			}
			
			FileOutputStream fio=new FileOutputStream(file);
			
			wb.write(fio);
			wb.close();
			}
	
			catch(IOException io) {
				
				io.printStackTrace();
			}
			
			}
			
	public static void main(String[]args) {
		WriteExcel we=new WriteExcel()(String excelpath ="C:\\Users\\AmalaS\\Documents\\SeleniumData\\ExcelTestData.xlsx");
		we.writData(excelpath, "WrieDataSheet", rowNumber,columnNumber, data);
	}
			
		}
