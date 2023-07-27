package Practice1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicXpath {
@Test
public void DynmicXpath1Test() throws Throwable {
	//public static void main(String[] args) throws Throwable {

		String key="webdriver.chrome.driver";
		String Value="./src/main/resources/chromedriver.exe";
		System.setProperty(key, Value);
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        
        driver.get("https://www.makemytrip.com/flights/");
        driver.findElement(By.xpath("//span[text()='Departure']")).click();
        
        Thread.sleep(1000);

        String month = "August 2023";
        String date = "4";

driver.findElement(By.xpath("//div[text()='"+month+"']"
		+ "/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']")).click();
	}

}
