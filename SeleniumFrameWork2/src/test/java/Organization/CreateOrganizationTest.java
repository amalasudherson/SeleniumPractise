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
import Pom.HomePage;
import Pom.LoginPage;
import Pom.OrganizationCreationPage;
import Pom.ValidationAndVerificationPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationTest  {

	@Test
	public void createOrganization() throws Throwable {

		// Setup browser
		Property_Utility plib = new Property_Utility();
		String BROWSER = plib.getKeyValue("browser");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver;

		driver = new ChromeDriver(options);

		if (BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else

			driver.manage().window().maximize();

		Wbdriver_utility wlib = new Wbdriver_utility();
		wlib.implicitwait(driver);
		 driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		 String URL = plib.getKeyValue("url");
		 String USERNAME = plib.getKeyValue("username");
		 String PASSWORD = plib.getKeyValue("password");

		 driver.get(URL);

		 LoginPage loginPage = new LoginPage(driver);
		 loginPage.loginToApp(USERNAME, PASSWORD);

		HomePage home = new HomePage(driver);
		home.clickorganizationlinkText();
		// driver1.findElement(By.linkText("Organizations")).click();

		OrganizationCreationPage org = new OrganizationCreationPage(driver);
		org.organizationcreateimage();
		Java_Utility jlib = new Java_Utility();
		int RanNum = jlib.getRandomNum();
		Excel_Utility elib = new Excel_Utility();
		String exceldata = elib.getExcelData("Organization", 0, 0) + RanNum;

		org.organizationnamestext(exceldata);
		// driver.findElement(By.name("accountname")).sendKeys(exceldata);

		org.savebutton();
		// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		ValidationAndVerificationPage validate = new ValidationAndVerificationPage(driver);
		validate.organizationValidation(driver, exceldata);

		home.signoutLink(driver);
	}
}