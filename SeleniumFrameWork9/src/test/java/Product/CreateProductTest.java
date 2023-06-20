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
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.Property_Utility;
import Generic_Utility.Webdriver_Utility;
import POM.HomePage;
import POM.OrganizationCreationPage1;
import POM.ProductCreation1;
import POM.ValidationAndVerificationPage1;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProductTest extends BaseClass  {
	@Test
	public void CreateProduct() throws Throwable { 


	
	Webdriver_Utility wlib = new Webdriver_Utility();
	wlib.implicityWait(driver);
	HomePage home=new HomePage(driver);
	home.ProductLinkText();
	ProductCreation1 pro=new ProductCreation1(driver);
	pro.productcreationimage();

	Java_Utility jlib = new Java_Utility();
	int RanNum = jlib.getRandomNum();

	Excel_Utility elib = new Excel_Utility();
	String productdata = elib.getExcelData("Product", 2, 1) + RanNum;
	pro.productnametext(productdata);
	pro.savebutton();
	
	ValidationAndVerificationPage1 validate=new ValidationAndVerificationPage1(driver);

	validate.productsValidation(driver, productdata);

		/*String key = "webdriver.chrome.driver";
		String Value = ".\\src\\main\\resources\\chromedriver.exe";
		System.setProperty(key, Value);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);*/

		/*
		 * Property_Utility plib=new Property_Utility(); 
		 * String BROWSER = plib.getKeyValue("browser");
		 * WebDriver driver1; if (BROWSER.equalsIgnoreCase("chrome")); {
		 * WebDriverManager.chromedriver().setup(); driver1=new ChromeDriver(); }
		 * 
		 * { if (BROWSER.equalsIgnoreCase("edge")); {
		 * WebDriverManager.chromedriver().setup(); driver1=new EdgeDriver(); }
		 * 
		 * 
		 * { driver1=new ChromeDriver(); }
		 */

		/*FileInputStream fis = new FileInputStream("./src/test/resources/PropertyFileData.properties");
		Properties pro = new Properties();

		pro.load(fis);*/

		/*String URL = pro.getProperty("url");
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
		int RanNum = ran.nextInt();

		FileInputStream fes = new FileInputStream("./src/test/resources/ExcelSheetData.xlsx");
		Workbook book = WorkbookFactory.create(fes);
		Sheet sheet = book.getSheet("Product");
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);
		String productdata = cell.getStringCellValue() + RanNum;

		driver.findElement(By.name("productname")).sendKeys(productdata);

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String actdata = driver.findElement(By.cssSelector("span.lvtHeaderText")).getText();
		if (actdata.contains(productdata))

		{
			System.out.println("Validation pass");

		} else {
			System.out.println("Validation fail");

		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.linkText("Sign Out")).click();*/

	}
}
