package Generic_Utility;

import java.util.concurrent.TimeUnit;

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

	@BeforeSuite
	public void BS() {
		System.out.println("DataBase connection");
	}

	@BeforeTest
	public void BT() {
		System.out.println("Parallel Execution");
	}

	@BeforeClass
	public void BC() throws Throwable {
		// Setup browser
		Property_Utility plib = new Property_Utility();
		String BROWSER = plib.getKeyValue("browser");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

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
		}
		
		driver.manage().window().maximize();
		Wbdriver_utility wlib = new Wbdriver_utility();
		wlib.implicitwait(driver);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@BeforeMethod
	public void BM() throws Throwable {

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
