package Campaigns;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.google.common.collect.Table.Cell;

public class Campaingns {


	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Throwable {

		String key="webdriver.chrome.driver";
		String Value="./src/main/resources/chromedriver.exe";
		System.setProperty(key, Value);
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver=new ChromeDriver(options);
		WebDriver driver1=new ChromeDriver();
        driver1.manage().window().maximize();
        driver1.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        
        FileInputStream fis=new FileInputStream("./src/test/resources/PropertyFileData.properties");
        Properties pro=new Properties();
        pro.load(fis);
        String URL = pro.getProperty("url");
        String USERNAME = pro.getProperty("username");
        String PASSWORD = pro.getProperty("password");
        driver1.get(URL);
		//driver.get("http://localhost:8888/");
		driver1.findElement(By.name("user_name")).sendKeys(USERNAME);
        driver1.findElement(By.name("user_password")).sendKeys(PASSWORD);
        driver1.findElement(By.id("submitButton")).click();

	driver1.findElement(By.linkText("More")).click();
	driver1.findElement(By.linkText("Campaigns")).click();
	
	driver1.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
	
	  
    Random ran=new Random();
    int RanNUm = ran.nextInt(1000);
	
	 FileInputStream fes=new FileInputStream("C:\\\\\\\\Users\\\\\\\\AmalaS\\\\\\\\Documents\\\\\\\\SeleniumData\\\\\\\\ExcelSheetData.xlsx");
     Workbook book = WorkbookFactory.create(fes);
     Sheet sheet = book.getSheet("Campaigns");
     Row row = sheet.getRow(0);
     org.apache.poi.ss.usermodel.Cell cell = row.getCell(0);
     String CampData = cell.getStringCellValue()+RanNUm;
	
	driver1.findElement(By.name("campaignname")).sendKeys(CampData);
	driver1.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
	String actData = driver1.findElement(By.cssSelector("span.dvHeaderText")).getText();
	
	if(actData.contains(CampData))
	{
		System.out.println("Pass");
	}
	else
	{
		System.out.println("Fail");
	}
	
	Thread.sleep(1000);
	driver1.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
	driver1.findElement(By.linkText("Sign Out")).click();
	
	
	}

}