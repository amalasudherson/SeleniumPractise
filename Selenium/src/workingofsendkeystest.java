import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class workingofsendkeystest 
{

	public static void main(String[] args) 
	{ 
		//How to use send keys()?
		System.setProperty("webdriver.chro,e.driver","./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/AmalaS/Documents/SeleniumPractise/absolutex-path.html");
		//WebElement element = driver.findElement(By.id("rty"));
			//element.sendKeys("AmalaSudherson");
		driver.findElement(By.id("rty")).sendKeys("AmalaSudherson");
}
}
