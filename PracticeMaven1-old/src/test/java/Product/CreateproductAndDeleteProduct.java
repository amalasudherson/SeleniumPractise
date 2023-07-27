package Product;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateproductAndDeleteProduct {

	public static void main(String[] args) throws Throwable {

		String key = "webdriver.chrome.driver";
		String Value = ".\\src\\main\\resources\\chromedriver.exe";
		System.setProperty(key, Value);
		// ChromeOptions options = new ChromeOptions();
		// options.addArguments("--remote-allow-origins=*");
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
		System.out.println(1);
		Random ran = new Random();
		int RanNum = ran.nextInt();
		System.out.println(2);

		FileInputStream fes = new FileInputStream("./src/test/resources/ExcelSheetData.xlsx");
		Workbook book = WorkbookFactory.create(fes);
		Sheet sheet = book.getSheet("Product");
		Row row = sheet.getRow(2);
		Cell cell = row.getCell(1);
		String productdata = cell.getStringCellValue();
		Thread.sleep(2000);
		System.out.println(3);

		driver.findElement(By.name("productname")).sendKeys(productdata);
		Thread.sleep(2000);
		System.out.println(4);

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(2000);
		System.out.println(5);

		driver.findElement(By.xpath("//input[@title='Delete [Alt+D]']")).click();
		System.out.println(6);

		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		System.out.println(7);
		Thread.sleep(2000);

		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		Thread.sleep(2000);
		System.out.println(8);
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("Pass");
		 driver.close();

	}

}
