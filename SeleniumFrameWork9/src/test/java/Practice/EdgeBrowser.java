package Practice;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EdgeBrowser {



	public static void main(String[] args) throws Throwable{

	/*WebDriver driver = webDriverManager.edgedriver().create();
	 driver.get("https://demo.automationtesting.in");
	 
	 Thread.sleep(3000); */
		
		WebDriver driver = WebDriverManager.chromedriver().create();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
	}

}
