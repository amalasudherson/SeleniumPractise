package Generic_Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {

	private POIFSFileSystem fis1;
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
	public Object[][] readMultipleData(String SheetName) throws Throwable {
		FileInputStream fis1 = new FileInputStream("./src/test/resources/ExcelSheetData.xlsx");
		Workbook book = WorkbookFactory.create(fis1);
		
	Sheet sh = book.getSheet(SheetName);
		int lastRow = sh.getLastRowNum()+1;
		int lastCell = sh.getRow(0).getLastCellNum();
		
		
		//Sheet sheet = book.getSheet(SheetName);
		//int numrow = Sheet.getPhysicalNumberOfRows();//num of rows
		//int numcell = Sheet.getRow(0).getLastCellNum();

		Object[][] obj = new Object[lastRow][lastCell];
		
		
		for (int i=0;i<lastRow;i++)
		{
			for (int j=0;j<lastCell;j++);
			{
				obj[i][lastCell] =sh.getRow(i).getCell(lastCell).getStringCellValue();
			}
		}
		return obj;
	}
}
