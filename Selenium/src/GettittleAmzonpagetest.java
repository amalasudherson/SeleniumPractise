import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GettittleAmzonpagetest {

	public static void main(String[] args) {
		System.getProperty ("webdriver.chrome driver","./Driver/chromedriver.exe");
		// TODO Auto-generated method stub
		WebDriver diver = new ChromeDriver();
		WebDriver driver = null;
		driver.get("http://amazon.com");
		String title = driver.getTitle();
		System.out.println(title);
		driver.close();

	}

}
