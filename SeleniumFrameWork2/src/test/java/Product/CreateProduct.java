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
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.Property_Utility;
import Generic_Utility.Wbdriver_utility;
import Pom.HomePage;
import Pom.ProductCreationPage;
import Pom.ValidationAndVerificationPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProduct extends BaseClass  {
@Test
	public void CreateProduct() throws Throwable {

		//1st approach to launch single browser 
		/*
		 * String key = "WebDriver driver=new ChromeDriver()"; String value =
		 * "./src/main/resources/chromedriver.exe"; System.setProperty(key, value);
		 * ChromeOptions options = new ChromeOptions();
		 * options.addArguments("--remote-allow-origins=*"); WebDriver driver = new
		 * ChromeDriver(options);
		 */
		
		
		//2nd approach to launch single browser 
		/*WebDriver driver;
		Property_Utility plib = new Property_Utility();
		String BROWSER = plib.getKeyValue("browser");
		if (BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} 
		else
		{
			driver = new ChromeDriver();
		}*/
		

	//3rd approach to launch multiple through property file browser 
	/*WebDriver driver;
	Property_Utility plib=new Property_Utility();
	String BROWSER = plib.getKeyValue("browser");
	{
	if(BROWSER.equalsIgnoreCase("chrome"))
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	else if (BROWSER.equalsIgnoreCase("edge"))
	{
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
	}
	else if (BROWSER.equalsIgnoreCase("firefox"))
	{
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
	}
	else
	{
		driver=new ChromeDriver();
	}
	
	Wbdriver_utility wlib=new Wbdriver_utility();*/
	//wlib.max(driver);
	//wlib.implicitwait(driver);
	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	//Property_Utility plib=new Property_Utility();
	//String URL = plib.getKeyValue("url");
	//String USERNAME = plib.getKeyValue("username");
	//String PASSWORD = plib.getKeyValue("password");
	
	/*FileInputStream fis=new FileInputStream("./src/test/resources/commondata.properties.txt");
	Properties pro=new Properties();
	pro.load(fis);
	String URL = pro.getProperty("url");
	String USERNAME = pro.getProperty("username");
	String PASSWORD = pro.getProperty("password");*/
	
	//driver.get(URL);
	
	//driver.get("http://localhost:8888/");
	
	/*Pom.LoginPage LoginPage=new Pom.LoginPage(driver);
	LoginPage.loginToApp(USERNAME, PASSWORD);*/
	
//	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//	driver.findElement(By.id("submitButton")).click();
	
	HomePage home=new HomePage(driver);
	//home.morelink(driver);
	home.ProductLinkText();
	
//	driver.findElement(By.xpath("//a[text()='Products']")).click();
	
	ProductCreationPage pro=new ProductCreationPage(driver);
	pro.productcreationimage();
	//driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
	
	//Random ran=new Random();
	//int RanNum=ran.nextInt(1000);
	Java_Utility jlib=new Java_Utility();
	int RanNum = jlib.getRandomNum();
    Excel_Utility elib=new Excel_Utility();
	String ProductsData  = elib.getExcelData("Product", 0, 0)+RanNum;
	
	/*FileInputStream fes=new FileInputStream("./src/test/resources/Testdata.xlsx");
	Workbook book = WorkbookFactory.create(fes);
	Sheet sheet = book.getSheet("Product");
	Row row = sheet.getRow(0);
	Cell cell = row.getCell(0);
	String productdata = cell.getStringCellValue()+RanNum;*/
	
	pro.productnametext(ProductsData);
	//driver.findElement(By.name("productname")).sendKeys(productdata);
	
	pro.savebutton();
	//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	System.out.println("1");
	ValidationAndVerificationPage validate=new ValidationAndVerificationPage(driver);
	
	validate.productsValidation(driver, ProductsData);
	
	/*String actdata = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
	if(actdata.contains(productdata))
	{
		System.out.println("Pass");
	}
	else
	{
		System.out.println("Fail");
	}*/
	Thread.sleep(5000);
	System.out.println("2");
	 Thread.sleep(5000);
	home.signoutLink(driver);
//	driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
//	driver.findElement(By.linkText("Sign Out")).click();
	

}

}