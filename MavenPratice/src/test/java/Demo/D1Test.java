package Demo;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class D1Test {

	@Test//(groups = "smokeTest")
	public void sample()
	{
		WebDriver driver=null;
		String BROWSER = System.getProperty("browser");
		String URL =  System.getProperty("url");
		if(BROWSER.equalsIgnoreCase("chrome"));
		{
	driver = WebDriverManager.chromedriver().create();
}
		 if(BROWSER.equalsIgnoreCase("firefox"));
	
		{
			driver = WebDriverManager.firefoxdriver().create();
		}
		
		{
			WebDriverManager.chromedriver().create();
		}
		//driver.get(URL);
		}
}
	

