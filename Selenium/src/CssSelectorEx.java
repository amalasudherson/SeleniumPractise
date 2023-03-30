import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssSelectorEx {

	public static void main(String[]args)
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.actitime.com/login.do");
		
		//using id
		//driver.findElenet(By.id("username")).sendKeys("admin");
		//[AttributeName='AtrinuteValue']
		//driver.findElement(By.cssSelector("[id='username']")).sendKeys("admin");
		
		//htmltag[AttributeName='AttributeValue']
		driver.findElement(By.cssSelector("input[id='username']")).sendKeys("admin");
		
	}
}
