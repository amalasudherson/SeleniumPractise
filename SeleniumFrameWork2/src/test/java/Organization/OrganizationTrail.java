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

	public class OrganizationTrail {

		public static void main(String[] args) throws Throwable {
			
			//System.setProperty("webdriver.edge.driver", "./src/main/resources/msedgedriver.exe");
			System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");

			// 1st approach to launch single browser
			/*
			 * String key = "WebDriver driver=new ChromeDriver()"; String value =
			 * "./src/main/resources/chromedriver.exe"; System.setProperty(key, value);
			 * ChromeOptions options = new ChromeOptions();
			 * options.addArguments("--remote-allow-origins=*"); WebDriver driver = new
			 * ChromeDriver(options);
			 */

			// 2nd approach to launch single browser

			/*
			 * WebDriver driver; Property_Utility plib = new Property_Utility(); String
			 * BROWSER = plib.getKeyValue("browser"); if
			 * (BROWSER.equalsIgnoreCase("chrome")) {
			 * WebDriverManager.chromedriver().setup(); driver = new ChromeDriver(); } else{
			 * driver = new ChromeDriver();}
			 */

			// 3rd approach to launch multiple through property file browser
			/*
			 * String Key="webdriver.crome.driver"; String
			 * value="./src\\main\\resources\\chromedriver.exe"; System.setProperty(Key,
			 * value);
			 */

			// Setup browser
			Property_Utility plib = new Property_Utility();
			String BROWSER = plib.getKeyValue("browser");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			WebDriver driver = new ChromeDriver(options);
			
			if (BROWSER.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			} else if (BROWSER.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			} else if (BROWSER.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			} else {
				driver = new ChromeDriver();
			}

			driver.manage().window().maximize();

			Wbdriver_utility wlib = new Wbdriver_utility();
			wlib.implicitwait(driver);
			// driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			String URL = plib.getKeyValue("url");
			String USERNAME = plib.getKeyValue("username");
			String PASSWORD = plib.getKeyValue("password");

			/*
			 * FileInputStream fis=new
			 * FileInputStream("./src/test/resources/commondata.properties.txt"); Properties
			 * pro=new Properties(); pro.load(fis); String URL = pro.getProperty("url");
			 * String USERNAME = pro.getProperty("username"); String PASSWORD =
			 * pro.getProperty("password");
			 */
			driver.get(URL);
			// driver.get("http://localhost:8888/");
//			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//	        driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//	        driver.findElement(By.id("submitButton")).click();

			LoginPage loginPage = new LoginPage(driver);
			loginPage.loginToApp(USERNAME, PASSWORD);
			// loginPage.getSubmitBtn().click();

			HomePage home = new HomePage(driver);
			home.clickorganizationlinkText();
			// driver1.findElement(By.linkText("Organizations")).click();

			OrganizationCreationPage org = new OrganizationCreationPage(driver);
			org.organizationcreateimage();
			// driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();

			/*
			 * Random ran=new Random(); int RanNUm = ran.nextInt(1000);
			 */

			Java_Utility jlib = new Java_Utility();
			int RanNum = jlib.getRandomNum();

			Excel_Utility elib = new Excel_Utility();
			String exceldata = elib.getExcelData("Organization", 0, 0) + RanNum;

//	        FileInputStream fes=new FileInputStream(".C:\Users\AmalaS\Documents\SeleniumData\ExcelSheetData.xlsx");
//	        Workbook book = WorkbookFactory.create(fes);
//	        Sheet sheet = book.getSheet("Organization");
//	        Row row = sheet.getRow(2);
//	        Cell  cell = row.getCell(1);
//	        String exceldata = cell.getStringCellValue()+RanNum;

			org.organizationnamestext(exceldata);
			// driver.findElement(By.name("accountname")).sendKeys(exceldata);

			org.savebutton();
			// driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			ValidationAndVerificationPage validate = new ValidationAndVerificationPage(driver);

			validate.organizationValidation(driver, exceldata);

			/*
			 * String actdata =
			 * driver.findElement(By.cssSelector("span.dvHeaderText")).getText();
			 * if(actdata.contains(exceldata)) { System.out.println("pass"); } else {
			 * System.out.println("fail"); }
			 */

			home.signoutLink(driver);
	//driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
	//driver.findElement(By.linkText("Sign Out")).click();
		}
	}

	

