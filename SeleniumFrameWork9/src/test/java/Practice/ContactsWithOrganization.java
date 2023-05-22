package Practice;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ContactsWithOrganization {

	public static void main(String[] args) throws Throwable {

		String key = "webdriver.chrome.driver";
		String Value = ".\\src\\main\\resources\\chromedriver.exe";
		System.setProperty(key, Value);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		FileInputStream fis = new FileInputStream("./src/test/resources/PropertyFileData.properties");
		Properties pro = new Properties();
		pro.load(fis);

		String URL = pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");
		driver.get(URL);
		// driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();

		Random ran=new Random();
		int RanNum = ran.nextInt();
		
		FileInputStream fes = new FileInputStream("./src/test/resources/ExcelSheetData.xlsx");
		Workbook book = WorkbookFactory.create(fes);
		Sheet sheet = book.getSheet("Organization");
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);
		String Organizationdata = cell.getStringCellValue()+RanNum;

		driver.findElement(By.name("accountname")).sendKeys(Organizationdata);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(2000);

		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys("Amala");
		driver.findElement(By.xpath("//img[@alt='Select']")).click();
		
		//for Switching window
				Set<String> allId = driver.getWindowHandles();//org  //cont  //prd
				Iterator<String> id = allId.iterator();

				while (id.hasNext()) {
					String wid = id.next();  //org
					driver.switchTo().window(wid);
					String title = driver.getTitle();

					if (title.contains("Accounts&action")) 
					{
						break;
					}
				}
		
		
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(Organizationdata);
		driver.findElement(By.xpath("//input[@type='button']")).click();
		
		
		// dynamic xpath
		driver.findElement(By.xpath("//a[text()='" + Organizationdata + "']")).click();
		
		Set<String> allId1 = driver.getWindowHandles();//org  //cont  //prd
		Iterator<String> id1 = allId1.iterator();

		while (id1.hasNext()) {
			String wid1 = id1.next(); //org
			driver.switchTo().window(wid1);
			String title = driver.getTitle();

			if (title.contains("Contacts&action"))
			{
				break;
			}
			
		}
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Validation Part
		String act = driver.findElement(By.xpath("//span[@id='dtlview_Last Name']")).getText();
		if(act.contains("Amala"))
			System.out.println("Con Pass");
			
			else
			{
				System.out.println("Con fail");
			}
		String actdata = driver.findElement(By.id("mouseArea_Organization Name")).getText();
		if(actdata.contains(Organizationdata))
			System.out.println("Org Pass");
		else
		{
			System.out.println("Org fail");
		}
			
		Thread.sleep(2000);
		 driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		 driver.findElement(By.linkText("Sign Out")).click();
	}
}
		
		

			
			

			

	
				
		
		
	


