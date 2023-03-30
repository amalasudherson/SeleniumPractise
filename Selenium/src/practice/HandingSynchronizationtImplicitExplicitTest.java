package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import dev.failsafe.Timeout;

public class HandingSynchronizationtImplicitExplicitTest {

	private static final String WebDriverWait wait = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.getProperty ("webdriver.chrome driver","./Driver/chromedriver.exe");
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		//implicit wait
     driver.manage().timeouts().implicitlyWait(10,TimeUnit.MICROSECONDS);
	WebElement links = driver.findElement(By.xpath("//a"));
	//Explicit wait
     WebDriver wait= new WebDriver(driver,10);
     wait.until(ExpectedConditions.titleContains("enter"));

	}

}
