package Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DynamicXpath {

	public static void main(String[] args) throws Throwable {

		String key = "webdriver.chrome.driver";
		String Value = ".\\src\\main\\resources\\chromedriver.exe";
		System.setProperty(key, Value);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get("https://www.makemytrip.com/international-flights/");
		driver.findElement(By.xpath("//span[text()='Departure']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
		String month = "July 2023";
		String date = "15";
		
		driver.findElement(By.xpath("//div[text()='"+month+"']/ancestor::div[@class='DayPicker-Months']/descendant::p[text()='"+date+"']")).click();

	}

}
