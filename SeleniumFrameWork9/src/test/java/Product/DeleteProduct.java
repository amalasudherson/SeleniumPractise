package Product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

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

import Generic_Utility.Excel_Utility;
import Generic_Utility.Java_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteProduct {

	public static void main(String[] args) throws Throwable {

		String key = "webdriver.chrome.driver";
		String Value = ".\\src\\main\\resources\\chromedriver.exe";
		System.setProperty(key, Value);
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	
		FileInputStream fis = new FileInputStream("./src/test/resources/PropertyFileData.properties");
		Properties pro = new Properties();
		pro.load(fis);

		String URL = pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");
		driver.get(URL);
		// driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		driver.findElement(By.xpath("//a[text()='Products']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();

		Random ran = new Random();
		int RanNum = ran.nextInt(1000);

		FileInputStream fes = new FileInputStream("./src/test/resources/ExcelSheetData.xlsx");
		Workbook book = WorkbookFactory.create(fes);
		Sheet sheet = book.getSheet("Product");
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);
		String productdata = cell.getStringCellValue() + RanNum;

		driver.findElement(By.name("productname")).sendKeys(productdata);

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		driver.findElement(By.xpath("(//a[text()='Products'])[1]")).click();

		driver.findElement(By.xpath(
				"//table[@class='lvt small']/tbody//td//a[text()='" + productdata + "']/../preceding-sibling::td[2]"))
				.click();
		driver.findElement(By.xpath("//input[@value='Delete']")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

}

/*
 * String actdata =
 * driver.findElement(By.cssSelector("span.lvtHeaderText")).getText();
 * if(actdata.contains(productdata))
 * 
 * { System.out.println("Validation pass");
 * 
 * } else { System.out.println("Validation fail");
 * 
 * } driver.findElement(By.xpath("//input[@title='Delete [Alt+D]']")).click();
 * 
 * Alert alert = driver.switchTo().alert(); alert.accept();
 * 
 * Thread.sleep(2000);
 * driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).
 * click(); driver.findElement(By.linkText("Sign Out")).click(); } }
 */
