package Campaigns;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import Generic_Utility.Excel_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.Property_Utility;
import Generic_Utility.Webdriver_Utility;

public class CreateCampaignWithProduct {

	public static void main(String[] args) throws Throwable {

		String key = "webdriver.chrome.driver";
		String Value = ".\\src\\main\\resources\\chromedriver.exe";
		System.setProperty(key, Value);
		ChromeOptions options = new ChromeOptions();
		
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		
		Webdriver_Utility wlib=new Webdriver_Utility();
		wlib.implicityWait(driver);
		
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		Property_Utility plib=new Property_Utility();
		String URL = plib.getKeyValue("url");
		String USERNAME = plib.getKeyValue("username");
		String PASSWORD = plib.getKeyValue("password");

		/*FileInputStream fis = new FileInputStream("./src/test/resources/PropertyFileData.properties");
		Properties pro = new Properties();
		pro.load(fis);

		String URL = pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");*/
		driver.get(URL);
		// driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		driver.findElement(By.xpath("//a[text()='Products']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();

		//Random ran = new Random();
		//int RanNum = ran.nextInt();

		
		Java_Utility jlib=new Java_Utility();
		int RanNum = jlib.getRandomNum();
		
		Excel_Utility elib=new Excel_Utility();
		String productdata = elib.getExcelData("Product", 1, 1)+RanNum;
		
		/*FileInputStream fes = new FileInputStream("./src/test/resources/ExcelSheetData.xlsx");
		Workbook book = WorkbookFactory.create(fes);
		Sheet sheet = book.getSheet("Product");
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);
		String productdata = cell.getStringCellValue() + RanNum;*/

		driver.findElement(By.name("productname")).sendKeys(productdata);

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(2000);

		driver.findElement(By.linkText("More")).click();
		driver.findElement(By.name("Campaigns")).click();
		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		
		
		Excel_Utility elib1=new Excel_Utility();
		String Campaignsdata = elib1.getExcelDataFormatter("Campaigns", 0, 0)+RanNum;
		
		/*FileInputStream fes1 = new FileInputStream("./src/test/resources/ExcelSheetData.xlsx");
		Workbook book1 = WorkbookFactory.create(fes1);
		Sheet sheet1 = book1.getSheet("Campaigns");
		Row row1 = sheet1.getRow(2);
		Cell cell1 = row1.getCell(1);
		String Campaignsdata = cell1.getStringCellValue() + RanNum;*/

		System.out.println("Campaignsdata: " + Campaignsdata);

		driver.findElement(By.name("campaignname")).sendKeys(Campaignsdata);
		driver.findElement(By.xpath("//img[@alt='Select']")).click();
		
		wlib.switchwindow(driver,"Products&action");
		
		//for Switching window
		/*Set<String> allId = driver.getWindowHandles();//org  //cont  //prd
		Iterator<String> id = allId.iterator();

		while (id.hasNext()) {
			String win = id.next();  //org
			driver.switchTo().window(win);
			String title = driver.getTitle();

			if (title.contains("Products&action")) 
			{
				break;
			}
		}*/
		driver.findElement(By.id("search_txt")).sendKeys(productdata);
		driver.findElement(By.name("search")).click();

		// dynamic xpath
		driver.findElement(By.xpath("//a[text()='" + productdata + "']")).click();
		
		wlib.switchwindow(driver,"Campaigns&action");

		/*Set<String> allId1 = driver.getWindowHandles();//org  //cont  //prd
		Iterator<String> id1 = allId1.iterator();

		while (id1.hasNext()) {
			String win1 = id1.next(); //org
			driver.switchTo().window(win1);
			String title = driver.getTitle();

			if (title.contains("Campaigns&action")) 
			{
				break;
			}
		}*/
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
	//validation Pat
		String act = driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();
		if(act.contains(Campaignsdata))
		{
			System.out.println("cam pass");
		}
		else
		{
			System.out.println("cam fail");
		}
	String actData = driver.findElement(By.xpath("//span[@id='dtlview_Product']")).getText();
	if(actData.contains(productdata))
	{
		System.out.println("product pass");
	}
	else
	{
		System.out.println("product fail");
	}
	Thread.sleep(2000);
	driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
	driver.findElement(By.linkText("Sign Out")).click();
	
		
		
		
//		for (String win: window) {
//			driver.switchTo().window(win);
//			String title = driver.getTitle();
//			System.out.println("title: " + title);
//			if(title.contains("Products&action")) {
//				break;
//			}
//		}
	}
}
