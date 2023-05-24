package Generic_Utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class Webdriver_Utility {
	/**
	 * This method wait for pag to load in GUI
	 * @param driver
	 * @author AmalaS
	 */
	
	public void implicityWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	
	}


