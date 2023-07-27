package Practice1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EdgeBrowser {

	public static void main(String[] args) throws Throwable  {


		
		  WebDriver driver = WebDriverManager.edgedriver().create();
		  driver.get("https://demo.automationtesting.in");
		  
		  Thread.sleep(3000);
		 

		/*WebDriver driver = WebDriverManager.chromedriver().create();
		driver.get("https://demo.automationtesting.in");
		//ChromeOptions options = new ChromeOptions();
		//options.addArguments("--remote-allow-origins=*");
		Thread.sleep(3000);*/

	}

}

