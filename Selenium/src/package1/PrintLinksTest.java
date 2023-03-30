package package1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrintLinksTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chro,e.driver","./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		//Count of Link
		List<WebElement>ele = driver.findElements(By.xpath("//a"));
		int count = ele.size();
		System.out.println(count);
		for(WebElement webElement:ele)
		{
			String text = webElement.getText();
			System.out.println(text);
		}
		driver.close();
		

	}

}
