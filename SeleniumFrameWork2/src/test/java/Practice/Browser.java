package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class Browser {

	public static void main(String[] args) throws Throwable {
		
		String key="WebDriver driver=new ChromeDriver()";
		String value="./src/main/resources/chromedriver.exe";
		System.setProperty(key,value);

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver=new ChromeDriver(options);
		
		
		//FileInputStream fis=new FileInputStream("C:\\Users\\AmalaS\\Documents\\propertyFileData.peroperties");
		FileInputStream fis=new FileInputStream("./src/test/resources/propertyFileData.peroperties");
		
		Properties pro=new Properties();
		pro.load(fis);
		
		
	String URL = pro.getProperty("url");
	String USERNAME = pro.getProperty("username");
	String PASSWORD = pro.getProperty("password");
	driver.get(URL);
	
	
	driver.findElement(By.id("username")).sendKeys(USERNAME);
	driver.findElement(By.name("pwd")).sendKeys(PASSWORD);
	driver.findElement(By.id("loginButton")).click();
	
		
		
		
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
		
		
	
		

	}
}
