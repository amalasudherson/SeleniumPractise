package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FontSizeSampletTest {

	private static WebDriver driver;
	private static Object elemet;
	private static WebElement element;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.getProperty ("webdriver.chrome driver","./Driver/chromedriver.exe");
		// TODO Auto-generated method stub
		WebDriver diver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		//WebElement elemet = driver.findElement(By.xpath("//input[@id='email']"));
		//String font = element.getCssValue("Font-size");
			//System.out.println(font);
			//driver.close();
		
	}

}
