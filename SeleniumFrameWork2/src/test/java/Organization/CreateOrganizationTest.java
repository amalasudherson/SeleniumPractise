package Organization;

import org.testng.annotations.Test;
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
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.internal.Debug;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.Property_Utility;
import Generic_Utility.Wbdriver_utility;
import Pom.CampaignCreationPage;
import Pom.HomePage;
import Pom.LoginPage;
import Pom.OrganizationCreationPage;
import Pom.ValidationAndVerificationPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationTest extends BaseClass {

	@Test(groups = {"smoketest","regressiontest","sanitytest"})
	public void createOrganizationTest() throws Throwable {		

		HomePage home = new HomePage(driver);
		home.clickorganizationlinkText();

		OrganizationCreationPage org = new OrganizationCreationPage(driver);
		org.organizationcreateimage();
		Java_Utility jlib = new Java_Utility();
		int RanNum = jlib.getRandomNum();
		Excel_Utility elib = new Excel_Utility();
		String orgdata = elib.getExcelData("Organization", 0, 0) + RanNum;

		org.organizationnamestext(orgdata);

		org.savebutton();
		ValidationAndVerificationPage validate = new ValidationAndVerificationPage(driver);
		validate.organizationValidation(driver, orgdata);
		//Thread.sleep(2000);
		//home.signoutLink(driver);
		
	}
}
	
	public void method1()
	{
		System.out.println("method running");
	}

	@Test(groups = "smoketest")
	public void CampaignCreationTest() throws Throwable {

		String key = "WebDriver driver=new ChromeDriver()";
		String value = "./src/main/resources/chromedriver.exe";
		System.setProperty(key, value);

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		// WebDriver driver1 = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\propertyFileData.properties"); 
		
        
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

		driver.findElement(By.linkText("More")).click();
		driver.findElement(By.linkText("Campaigns")).click();
		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		
		Random ran = new Random();
		int RanNum = ran.nextInt(1000);
		Excel_Utility elib = new Excel_Utility();
		String CampData = elib.getExcelData("Campaigns", 0, 1) + RanNum;
		
		driver.findElement(By.name("campaignname")).sendKeys(CampData);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		ValidationAndVerificationPage validate = new ValidationAndVerificationPage(driver);
		validate.campaingnValidation(driver, CampData);

		 String actdata = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();

		
		//String actdata = driver.findElement(By.cssSelector("span.dvHeaderText")).getText();
		//String actdata = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		 if (actdata.contains(CampData))

			{
				System.out.println("Pass");
			} else {
				System.out.println("Fail");
			}

			// home.signoutLink(driver);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
			driver.findElement(By.linkText("Sign Out")).click();

		}

	}
		

		
		