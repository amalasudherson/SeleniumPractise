package Generic_Utility;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class Wbdriver_utility {
	
	/**
	 * This method wait for page to load in GUI
	 * 
	 * @param driver
	 */
	
	public void implicityWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	/**
	 * This method is used for switching windows
	 * @param driver
	 */
}


public void switchwindow(WebDriver driver, String PartialWindowTitle) 
{
	
	Set<String> a11id = driver.getWindowHandles(); //org  //cont  //prd
	Iterator<String> id = a11id.iterator();
	
	while(id.hasNext())
	{
		 String wid = id.next();//org  //cont
		 driver.switchTo(.window(wid);
		 String title = driver.getTitle();
		
		if(title.contains(PartialWindowTitle)) 
		{
			break;
		}

    }
}


}