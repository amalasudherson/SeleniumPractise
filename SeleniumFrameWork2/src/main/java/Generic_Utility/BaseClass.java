package Generic_Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import Pom.HomePage;
import Pom.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	protected WebDriver driver;

	public BaseClass() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
	}

	@BeforeSuite
	public void BS() {
		System.out.println("DataBase connection");

	}

	@BeforeTest
	public void BT() {
		System.out.println("Parallel Execution");
	}

	@BeforeClass
	public void BC() throws Throwable

	{
		Property_Utility plib = new Property_Utility();
		String Browser = plib.getKeyValue("browser");

		/*
		 * if (Browser.equalsIgnoreCase("Chrome"))
		 * 
		 * { WebDriverManager.chromedriver().setup(); driver = new ChromeDriver(); }
		 * 
		 * else if (Browser.equalsIgnoreCase("firefox")) {
		 * WebDriverManager.firefoxdriver().setup(); driver = new FirefoxDriver();
		 * 
		 * } else if (Browser.equalsIgnoreCase("edge")) {
		 * WebDriverManager.edgedriver().setup(); driver = new EdgeDriver(); } else {
		 * driver = new ChromeDriver(); } System.out.println("Launching browser"); }
		 * 
		 * {
		 */

		String Key = "webdriver.chrome.driver";
		String value = ("C:\\Users\\AmalaS\\Documents\\SeleniumData\\ExcelSheetData.xlsx");
		System.setProperty(Key, value);
		/*
		 * ChromeOptions options = new ChromeOptions();
		 * options.addArguments("--remote-allow-origins=*"); WebDriver driver = new
		 * ChromeDriver(options);
		 */

	}

	@BeforeMethod
	public void BM() throws Throwable {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);

		Property_Utility plib = new Property_Utility();
		String URL = plib.getKeyValue("url");
		String USERNAME = plib.getKeyValue("username");
		String PASSWORD = plib.getKeyValue("password");
		driver.get(URL);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginToApp(USERNAME, PASSWORD);
		System.out.println("Login Applicationn");
	}

	@AfterMethod
	public void AM() {

		HomePage home = new HomePage(driver);
		home.signoutLink(driver);
		System.out.println("Logout Application");
	}

	@AfterClass
	public void Ac() {

		driver.quit();
		System.out.println("Browser closed");
	}

	public void AT() {
		System.out.println("Parallel Execution Done");
	}

	public void AS() {
		System.out.println("DataBase Connection close");
	}
}
