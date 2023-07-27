package Product;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Generic_Utility.Property_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProduct1 {

	public static void main(String[] args) throws Throwable {

		/*String key="webdriver.chrome.driver";
		String Value="./src/main/resources/chromedriver.exe";
		System.setProperty(key, Value);
		WebDriver driver=new ChromeDriver();*/
		
		/* WebDriver driver;
		 WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();*/
		
	/*	WebDriver driver;
		Property_Utility plib=new Property_Utility();
		String BROWSER = plib.getKeyValue("browser");
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else
		{
			driver=new ChromeDriver();
		}*/
		
		WebDriver driver;
		Property_Utility plib=new Property_Utility();
		String BROWSER = plib.getKeyValue("browser");
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else
		{
			driver=new ChromeDriver();
		}
		
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        
        FileInputStream fis=new FileInputStream("./src/test/resources/PropertyFileData.properties");
        Properties pro=new Properties();
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
        
        Random ran=new Random();
        int RanNUm = ran.nextInt(1000);
        
        FileInputStream fes =new FileInputStream("./src/test/resources/ExcelSheetData.xlsx");
        Workbook book = WorkbookFactory.create(fes);
        Sheet sheet = book.getSheet("product");
        Row row = sheet.getRow(0);
        Cell cel = row.getCell(0);
        String productdata = cel.getStringCellValue()+RanNUm;
        
        driver.findElement(By.name("productname")).sendKeys(productdata);
        
        driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
        Thread.sleep(2000);
        
       String actData = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
        
        if(actData.contains(productdata))
        {
        	System.out.println("Validation pass");
        }
        else
        {
        	System.out.println("Validation Fail");
        }
        
        driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
        driver.findElement(By.linkText("Sign Out")).click();
	}

}