package Organization;

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
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.Property_Utility;
import Generic_Utility.Webdriver_Utility;
import POM.LoginPage;
@Test
public class CreateOrganizationTest extends BaseClass{

	
	public void CreateOrganization() throws Throwable {

		// public static void main(String[] args) throws Throwable {

		/*String key = "webdriver.chrome.driver";
		String Value = ".\\src\\main\\resources\\chromedriver.exe";
		System.setProperty(key, Value);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);*/

		driver.manage().window().maximize();

		Webdriver_Utility wlib = new Webdriver_Utility();
		wlib.implicityWait(driver);
		// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		Property_Utility plib = new Property_Utility();
		String URL = plib.getKeyValue("url");
		String USERNAME = plib.getKeyValue("username");
		String PASSWORD = plib.getKeyValue("password");

		// FileInputStream fis = new
		// FileInputStream("./src/test/resources/PropertyFileData.properties");
		// Properties pro = new Properties();
		// pro.load(fis);

		/*
		 * String URL = pro.getProperty("url"); String USERNAME =
		 * pro.getProperty("username"); String PASSWORD = pro.getProperty("password");
		 */
		driver.get(URL);
		// driver.get("http://localhost:8888/");
		/*
		 * driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		 * driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		 * driver.findElement(By.id("submitButton")).click();
		 */

		//LoginPage loginpage = new LoginPage(driver);
		//loginpage.loginToApp(USERNAME, PASSWORD);

		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();

		/*
		 * Random ran=new Random(); int RanNum = ran.nextInt();
		 */

		Java_Utility jlib = new Java_Utility();
		int RanNum = jlib.getRandomNum();

		Excel_Utility elib = new Excel_Utility();
		String exceldata = elib.getExcelData("Organization", 2, 1) + RanNum;

		/*
		 * FileInputStream fes = new
		 * FileInputStream("./src/test/resources/ExcelSheetData.xlsx"); Workbook book =
		 * WorkbookFactory.create(fes); Sheet sheet = book.getSheet("Organization"); Row
		 * row = sheet.getRow(1); Cell cell = row.getCell(0); String exceldata =
		 * cell.getStringCellValue() + RanNum;
		 */

		driver.findElement(By.name("accountname")).sendKeys(exceldata);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String actdata = driver.findElement(By.cssSelector("span.dvHeaderText")).getText();
		if (actdata.contains(exceldata)) {
			System.out.println("pass");
		} else
			System.out.println("fail");

		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.linkText("Sign Out")).click();

		// String actdata =
		// driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();

	}

}
