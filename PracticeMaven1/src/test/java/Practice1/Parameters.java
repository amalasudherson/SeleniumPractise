package Practice1;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;



public class Parameters{

	
	
	@Test
	public void m1()
	{
		String BROWSER = System.getProperty("browser");
		String URL = System.getProperty("url");
		System.out.println(BROWSER);
		System.out.println(URL);
		//WebDriver driver = null;
		}
}

		//if(BROWSER.equalsIgnoreCase("chrome"));
//		{
//			driver = WebDriverManager.chromedriver().create();
//		}
//
//	}
//}
//		else if(BROWSER.equalsIgnoreCase("firefox"));
//		{
//			driver = WebDriverManager.firefoxdriver().create();
//		}
//		else
//		{
//			 WebDriverManager.chromedriver().create();
//		}
//		driver.get(URL);
//		
//	}


