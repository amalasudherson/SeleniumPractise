package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Browser {

	public static void main(String[] args) throws Throwable {

		String key = "webdriver.chrome.driver";
		String Value = ".\\src\\main\\resources\\chromedriver.exe";
		System.setProperty(key, Value);

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);

		// FileInputStream fis = new
		// FileInputStream("C:\\Users\\AmalaS\\Documents\\PropertyfileData.properties");
		FileInputStream fis = new FileInputStream("./src/test/resources/PropertyFileData.properties");

		Properties pro = new Properties();
		pro.load(fis);

		String URL = pro.getProperty("url");
		String USERNAME = pro.getProperty("Username");
		String PASSWORD = pro.getProperty("Password");
		driver.get(URL);

		// driver.get("https://demo.actitime.com/login.do");
		driver.findElement(By.id("username")).sendKeys(USERNAME);
		driver.findElement(By.name("pwd")).sendKeys(PASSWORD);
		driver.findElement(By.id("loginButton")).click();

		/*
		 * String Key="webdriver.edg.driver"; String
		 * Value=".\\src\\main\\resources\\chromedriver.exe";
		 * System.setProperty(Key,Value); WebDriver driver1=new EdgeDriver();
		 */

	}

}
