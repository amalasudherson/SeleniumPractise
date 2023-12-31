package Generic_Utility;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {

	/**
	 * This method is used to fetch data from Excel
	 * 
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws Throwable
	 * @author Amala
	 */
	public String getExcelData(String sheetName, int rowNum, int cellNum) throws Throwable {
		final String dir = System.getProperty("user.dir");
		System.out.println("current dir = " + dir);
		FileInputStream fes = new FileInputStream(".\\src\\test\\resources\\ExcelSheetData.xlsx");		
		Workbook book = WorkbookFactory.create(fes);
		Sheet sheet = book.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		String value = cell.getStringCellValue();

		System.out.println("value: " + value);
		return value;
	}

	public String getExcelDataFormatter(String sheetName, int rowNum, int cellNum) throws Throwable {
		FileInputStream fes = new FileInputStream("./src/test/resources/ExcelSheetData.xlsx");
		Workbook book = WorkbookFactory.create(fes);
		DataFormatter format = new DataFormatter();
		String data = format.formatCellValue(book.getSheet(sheetName).getRow(rowNum).getCell(cellNum));
		return data;

	}

}