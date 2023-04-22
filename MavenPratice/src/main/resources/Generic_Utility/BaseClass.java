package Generic_Utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import Pom.HomePage;
import Pom.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	protected WebDriver driver;
	Property_Utility plib;
	ChromeOptions options;

	@BeforeSuite(groups = { "smoketest", "regressiontest", "sanitytest" })
	public void BS() {
		System.out.println("DataBase connection");
	}

	@BeforeTest(groups = { "smoketest", "regressiontest", "sanitytest" })
	public void BT() {
		System.out.println("Parallel Execution");
	}

	@Parameters("BROWSER")
	@BeforeClass(groups = { "smoketest", "regressiontest", "sanitytest" })
	public void BC(String BROWSER) throws Throwable {
		System.out.println("@BeforeClass");
		// Setup browser
	
		Property_Utility plib = new Property_Utility();
		String BROWSER1 = plib.getKeyValue("browser");
		options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);

		if (BROWSER1.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
		} else if (BROWSER1.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (BROWSER1.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		Wbdriver_utility wlib = new Wbdriver_utility();
		wlib.implicitwait(driver);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@BeforeMethod(groups = { "smoketest", "regressiontest", "sanitytest" })
	public void BM() throws Throwable {
		driver.manage().window().maximize();
		System.out.println("@BeforeMethod");
		Property_Utility plib = new Property_Utility();
		String URL = plib.getKeyValue("url");
		String USERNAME = plib.getKeyValue("username");
		String PASSWORD = plib.getKeyValue("password");
		driver.get(URL);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginToApp(USERNAME, PASSWORD);
		System.out.println("Login Applicationn");
	}

	@AfterMethod(groups = { "smoketest", "regressiontest", "sanitytest" })
	public void AM() {
		System.out.println("@AfterMethod");
		HomePage home = new HomePage(driver);
		home.signoutLink(driver);
		System.out.println("Logout Application");
	}

	@AfterClass(groups = { "smoketest", "regressiontest", "sanitytest" })
	public void Ac() {
		System.out.println("@AfterClass");
		driver.quit();
		System.out.println("Browser closed");
	}

	@AfterTest(groups = { "smoketest", "regressiontest", "sanitytest" })
	public void AT() {
		System.out.println("Parallel Execution Done");
	}

	@AfterSuite(groups = { "smoketest", "regressiontest", "sanitytest" })
	public void AS() {
		System.out.println("DataBase Connection close");
	}
}
