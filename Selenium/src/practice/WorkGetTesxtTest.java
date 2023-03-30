package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WorkGetTesxtTest {

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chro,e.driver","./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		WebElement element = driver.findElement(By.xpath("//button[@name='login']"));
       // String text = element.getText();
        //System.out.println(text);
		 //String text = driver.findElement(By.xpath("//button[@name='login']")).getText();
		//System.out.println(text);
		//Point locn = element.getLocation();
		//System.out.println(locn);
		//int X = locn.getX();
		//System.out.println(X);
		//int Y = locn.getY();
		//System.out.println(Y);
		//driver.close();
	 int h = element.getSize().getHeight();
	 System.out.println(h);
	 int w = element.getSize().getWidth();
	 System.out.println(w);
	}

}


