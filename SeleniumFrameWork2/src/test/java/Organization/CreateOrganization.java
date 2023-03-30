package Organization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.invoke.MutableCallSite;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.internal.Debug;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateOrganization {

	public static void main(String[] args) throws Throwable {

		String key = "WebDriver driver=new ChromeDriver()";
		String value = "./src/main/resources/chromedriver.exe";
		System.setProperty(key, value);

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		FileInputStream fis = new FileInputStream("./src/test/resources/propertyFileData.properties");
		Properties pro = new Properties();
		pro.load(fis);
		String URL = pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
		String PASSWORS = pro.getProperty("password");
		driver.get(URL);
		System.out.println("userName: " + USERNAME);
		System.out.println("PASSWORS: " + PASSWORS);

//		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORS);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		Random ran=new Random();
		int RanNum = ran.nextInt(1000);
		
		//Duration d = Duration(5);
		//WebDriverWait w = new WebDriverWait(driver, d);
		// alertIsPresent() condition applied
		
		FileInputStream fes = new FileInputStream("C:\\Users\\AmalaS\\Documents\\SeleniumData\\ExcelSheetData.xlsx");
		Workbook book = WorkbookFactory.create(fes);
		Sheet sheet = book.getSheet("Organization");
		Row row = sheet.getRow(2);
		Cell cell1 = row.getCell(1);
		String exceldata = cell1.getStringCellValue()+RanNum;
		
		System.out.println("exceldata: " + exceldata);

		driver.findElement(By.name("accountname")).sendKeys(exceldata);

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String actdata = driver.findElement(By.cssSelector("span.dvHeaderText")).getText();
		if(actdata.contains(exceldata))
		{
			System.out.println("pass");
			
		}
		
		else
		{
			
			System.out.println("fail");
		}
		
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.linkText("Sign Out")).click();

		
		
		
		//Thread.sleep(4000);
//		if (w.until(ExpectedConditions.alertIsPresent())!=null) {
//			Alert alert = driver.switchTo().alert();
//			alert.dismiss();
//		}
		//w.until(ExpectedConditions.alertIsPresent());
	   // Alert alert = driver.switchTo().alert();
	   // alert.accept();

		
		// File file = new File("file location");
		// Sheet sheet = SpreadSheet.createFromFile(file).getSheet(0)MutableCallSite
		// domain = null;
		// sheet.getCellAt(row index,column index).setValue(value you want to write in
		// the cell) // getvalue()-fetches the value in the cell;
		// ((Object) sheet).getSpreadSheet().saveAs(file);
	}


}
