package Demo;

import org.apache.poi.hpsf.Property;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class D1Test {

	@Test // (groups = "smokeTest")
	public void sample() {
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
		//driver.get(URl);
	}
}