import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetCurrentUrlSampleTest
{
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chro,e.driver","./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		Thread.sleep(2000);
		//String title = driver.getTitle();
		//System.out.println(title);
		//System.out.println(driver.getTitle));
		String currenturl = driver.getCurrentUrl();
		System.out.println(currenturl);
		String pageSource = driver.getPageSource();
		System.out.println(pageSource);
	}        
}
