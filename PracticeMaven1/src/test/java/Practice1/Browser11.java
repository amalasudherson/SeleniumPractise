package Practice1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser11 
{

	
	public static void main(String[]args) throws Throwable
	{
		
	String Key="webdriver.chrome.driver";
	String Value="./src/main/resources/chromedriver.exe";
	System.setProperty(Key,Value);
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	
	FileInputStream fis=new FileInputStream("./src/test/resources/PropertyFileData.properties");
	
	Properties pro=new Properties();
	pro.load(fis);
	
	
String URL = pro.getProperty("url");
String USERNAME = pro.getProperty("Username");
String PASSWORD = pro.getProperty("Password");
driver.get(URL);

driver.findElement(By.id("username")).sendKeys(USERNAME);
driver.findElement(By.name("pwd")).sendKeys(PASSWORD);
driver.findElement(By.id("loginButton")).click();
	}
}

	
	
	
		 /*driver.get("https://demo.actitime.com/login.do");
	//driver.get("https://mvnrepository.com/");
	driver.findElement(By.id("username")).sendKeys("admin");
	driver.findElement(By.name("pwd")).sendKeys("manager");
	driver.findElement(By.id("loginButton")).click();*/
	

//WebDriver driver = webDriverManager chromedriver().create();
	/*String key="WebDriver.edge.driver";
	String value="./src/main/resources/msedgedriver.exe";
	System.setProperty(key,value);
	WebDriver driver=new EdgeDriver();*/
	