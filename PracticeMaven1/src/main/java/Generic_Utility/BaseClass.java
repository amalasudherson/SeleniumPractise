package Generic_Utility;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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

import POM.HomePage;
import POM.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class  BaseClass {
	public WebDriver driver;

	@BeforeSuite
	public void BS()
	{
		System.out.println("DataBase Connection");
	}
	
	@BeforeTest
	public void BT()
	{
		System.out.println("Parallel Execution");
	}
	
	@BeforeClass
	public void BC() throws Throwable
	{
		Property_Utility plib = new Property_Utility();
		String BROWSER = plib.getKeyValue("browser");
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else 
		{
			driver = new ChromeDriver();
		}
		System.out.println("Launching browser");
	}

	
	@BeforeMethod
	public void BM() throws Throwable
	{
		System.out.println("@BeforeMethod");
		Property_Utility plib = new Property_Utility();
		String URL = plib.getKeyValue("url");
		String USERNAME = plib.getKeyValue("username");
		String PASSWORD = plib.getKeyValue("password");
		driver.get(URL);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginToApp(USERNAME, PASSWORD);
		System.out.println("Login Application");
	
	}
	
	@AfterMethod
	public void AM()
	{
		HomePage home=new HomePage(driver);
		home.signoutLink(driver);
		System.out.println("Logout Application");
	}
	
	@AfterClass
	public void AC()
	{
		//driver.quit();
		System.out.println("Browser closed");
	}
	
	@AfterTest
	public void AT()
	{
		System.out.println("parallel exceution done");
	}
	
	@AfterSuite
	public void AS()
	{
		System.out.println("database connection close");
	}
}
