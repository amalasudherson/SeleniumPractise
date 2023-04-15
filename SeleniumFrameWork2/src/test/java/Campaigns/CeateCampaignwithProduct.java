package Campaigns;

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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Generic_Utility.Excel_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.Property_Utility;
import Generic_Utility.Wbdriver_utility;
import Pom.HomePage;
import Pom.LoginPage;
import Pom.ProductCreationPage;
import Pom.ValidationAndVerificationPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CeateCampaignwithProduct  {

	public static void main(String[] args) throws Throwable
	{
	
		/*String key = "WebDriver driver=new ChromeDriver()";
		String value = "./src/main/resources/chromedriver.exe";
		System.setProperty(key, value);
		ChromeOptions options = new ChromeOptions();
		
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		// 2nd approach to launch single browser 
		/*WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		*/
		
		//3rd approach to launch multiple through property file browser 
				WebDriver driver;
				Property_Utility plib=new Property_Utility();
				String BROWSER = plib.getKeyValue("browser");
				
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
				
				Wbdriver_utility wlib=new Wbdriver_utility();
				wlib.max(driver);
				wlib.implicityWait(driver);
				//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
				//Property_Utility plib=new Property_Utility();
				String URL = plib.getKeyValue("url");
				String USERNAME = plib.getKeyValue("username");
				String PASSWORD = plib.getKeyValue("password");
				
				/*FileInputStream fis=new FileInputStream("./src/test/resources/commondata.properties.txt");
				Properties pro=new Properties();
				pro.load(fis);
				String URL = pro.getProperty("url");
				String USERNAME = pro.getProperty("username");
				String PASSWORD = pro.getProperty("password");*/
				
				driver.get(URL);
				
				//driver.get("http://localhost:8888/");
				LoginPage LoginPage=new LoginPage(driver);
				LoginPage.loginToApp(USERNAME, PASSWORD);
				
//				driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//				driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//				driver.findElement(By.id("submitButton")).click();
//				
				HomePage home=new HomePage(driver);
				home.productslink();
				//driver.findElement(By.xpath("//a[text()='Products']")).click();
				
				CreateCampaignwithProductCreationPage ccpcp=new CreateCampaignwithProductCreationPage(driver);
				ccpcp.createproductimage();
				//driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
				
				//Random ran=new Random();
				//int RanNum=ran.nextInt(1000);
				Java_Utility jlib=new Java_Utility();
				int RanNum = jlib.getRandomNum();
				
				Excel_Utility elib=new Excel_Utility();
				String productdata = elib.getExceldata("Product", 0, 0)+RanNum;
				
				/*FileInputStream fes=new FileInputStream("./src/test/resources/Testdata.xlsx");
				Workbook book = WorkbookFactory.create(fes);
				Sheet sheet = book.getSheet("Product");
				Row row = sheet.getRow(0);
				Cell cell = row.getCell(0);
				String productdata = cell.getStringCellValue()+RanNum;*/
				
				ccpcp.productnametext(productdata);
				//driver.findElement(By.name("productname")).sendKeys(productdata);
				
				ccpcp.savebutton();
				//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				home.morelink(driver);
				home.campaignslink();
				ccpcp.campaigncreateimage();
				//driver.findElement(By.linkText("More")).click();
				//driver.findElement(By.linkText("Campaigns")).click();
				//driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
				

				String CampData = elib.getExceldata("Campaign", 0, 0)+RanNum;
				
				/*FileInputStream fes1=new FileInputStream("./src/test/resources/Testdata.xlsx");
				Workbook book1 = WorkbookFactory.create(fes1);
				Sheet sheet1 = book1.getSheet("Campaign");
				Row row1 = sheet1.getRow(0);
				Cell cell1 = row1.getCell(0);
				String CampData = cell1.getStringCellValue()+RanNum;*/
				
				ccpcp.campaignnametext(CampData);
				//driver.findElement(By.name("campaignname")).sendKeys(CampData);
				ccpcp.selectdropdown();
				//driver.findElement(By.xpath("//img[@alt='Select']")).click();
				
				wlib.switchwindow(driver, "Products&action");
				
				/*Set<String> allId = driver.getWindowHandles();
				Iterator<String> id = allId.iterator();
				while(id.hasNext())
				{
					String wid = id.next();
					driver.switchTo().window(wid);
					String title = driver.getTitle();
					if(title.contains("Products&action"))
					{
						break;
					}
				}*/
				
				ccpcp.searchbox(productdata);
				//driver.findElement(By.id("search_txt")).sendKeys(productdata);
				ccpcp.searchbutton();
				//driver.findElement(By.name("search")).click();
				
				//Dynamic Xpath
				driver.findElement(By.xpath("//a[text()='"+productdata+"']")).click();
				
				wlib.switchwindow(driver, "Campaigns&action");
				
				/*Set<String> allId1 = driver.getWindowHandles();
				Iterator<String> id1 = allId1.iterator();
				while(id1.hasNext())
				{
					String wid1 = id1.next();
					driver.switchTo().window(wid1);
					String title = driver.getTitle();
					if(title.contains("Campaigns&action"))
					{
						break;
					}
				}*/
				
				ccpcp.savebutton();
				//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				ValidationandVerificationPage validate=new ValidationandVerificationPage(driver);
				validate.ValidationandVerificationofCampaignAddition(driver, CampData);
				validate.ValidationandVerificationofProductAddition(driver, productdata);
				/*String act = driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();
				if(act.contains(CampData))
				{
					System.out.println("Campaign Pass");
				}
				else
				{
					System.out.println("Campaign Fail");
				}
				
				String actData = driver.findElement(By.xpath("//span[@id='dtlview_Product']")).getText();
				if(actData.contains(productdata))
				{
					System.out.println("Product Pass");
				}
				else
				{
					System.out.println("Product Fail");
				}*/
				home.signoutLink(driver);
//				driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
//				driver.findElement(By.linkText("Sign Out")).click();
				
			}

}
