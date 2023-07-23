package Product;

import java.io.FileInputStream;
import java.util.List;
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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteProduct1 {

	public static void main(String[] args) throws Throwable {

		String key = "webdriver.chrome.driver";
		String Value = "./src/main/resources/chromedriver.exe";
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
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		driver.findElement(By.xpath("//a[text()='Products']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();

		Random ran = new Random();
		int RanNUm = ran.nextInt(1000);

		FileInputStream fes = new FileInputStream("./src/test/resources/ExcelSheetData.xlsx");
		Workbook book = WorkbookFactory.create(fes);
		Sheet sheet = book.getSheet("product");
		Row row = sheet.getRow(0);
		Cell cel = row.getCell(0);
		String productdata = cel.getStringCellValue() + RanNUm;

		driver.findElement(By.name("productname")).sendKeys(productdata);
		System.out.println(productdata);

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		System.out.println(1);

		driver.findElement(By.xpath("(//a[text()='Products'])[1]")).click();
		System.out.println(2);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//table[@class='lvt small']/tbody//td//a[text()='" + productdata + "']/../preceding-sibling::td[2]")).click();
		System.out.println(3);
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@value='Delete']")).click();
		Thread.sleep(2000);

		Alert alt = driver.switchTo().alert();
		alt.accept();
		List<WebElement> list = driver.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr/td[3])[position()>1]"));

		boolean flag = false;
		for (WebElement wb : list) {

			String data = wb.getText();
			if (data.contains(productdata)) {
				flag = true;
				break;
			}
		}
		if (flag) {
			System.out.println("deleted");
			System.out.println(4);

		} else {
			System.out.println("not deleted");
			
			
			
			 driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
			 System.out.println(5);
		        driver.findElement(By.linkText("Sign Out")).click();
		}

	}

}