package Demo;

import org.apache.poi.hpsf.Property;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class D1Test {

	@Test // (groups = "smokeTest")
	public void sample() throws Throwable {
		//String BROWSER1 = plib.getKeyValue("browser");
		WebDriver driver = null;
		var options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);
	

		
		String BROWSER = System.getProperty("browser");
		String URl = System.getProperty("url");
		if (BROWSER.equalsIgnoreCase("chrome"))

		{
			driver = WebDriverManager.chromedriver().create();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = WebDriverManager.firefoxdriver().create();
		} else {
			WebDriverManager.chromedriver().create();

		}
		Thread.sleep(1000);
		System.out.println("1");
		driver.get("http://localhost:8888/");
		//driver.get(URl);
		
	}
}