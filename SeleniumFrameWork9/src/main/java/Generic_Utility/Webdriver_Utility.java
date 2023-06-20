package Generic_Utility;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Webdriver_Utility {
	/**
	 * This method wait for pag to load in GUI
	 * 
	 * @param driver
	 * @author AmalaS
	 */

	public void implicityWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	/**
	 * This method is used for switching window
	 * 
	 * @param driver
	 * @param PartialWindowTitle
	 * @author AmalaS
	 */

	public void switchwindow(WebDriver driver, String PartialWindowTitle) {
		Set<String> allId = driver.getWindowHandles();// org //cont //prd
		Iterator<String> id = allId.iterator();

		while (id.hasNext()) {
			String win = id.next(); // org //cont
			driver.switchTo().window(win);
			String title = driver.getTitle();

			if (title.contains(PartialWindowTitle)) {
				break;
			}
		}

	}

	/**
	 * used to place mouse cursor on specified element
	 * 
	 * @param driver
	 * @param element
	 */

	public void mouseOverOnElement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();

	}
}
