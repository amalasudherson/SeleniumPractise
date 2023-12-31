package Organization;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;


import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class OrganizatioCreation {

	public static void main(String[] args) throws Throwable {

		String key = "webdriver.chrome.driver";
		String Value = ".\\src\\main\\resources\\chromedriver.exe";
		System.setProperty(key, Value);

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

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
		int RanNum = ran.nextInt(1000);
		
		FileInputStream fes = new FileInputStream("./src/test/resources/ExcelSheetData.xlsx");
		Workbook book = WorkbookFactory.create(fes);
		org.apache.poi.ss.usermodel.Sheet sheet = book.getSheet("Organization");
		Row row = sheet.getRow(0);
		org.apache.poi.ss.usermodel.Cell cell = row.getCell(0);
		String Orgdata = cell.getStringCellValue()+RanNum;
        System.out.println(1);
		driver.findElement(By.name("accountname")).sendKeys(Orgdata);
        System.out.println(2);

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//String actdata = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
		//String actdata = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
        System.out.println(3);
    	Thread.sleep(2000);
		String actdata = driver.findElement(By.cssSelector("span.dvHeaderText")).getText();
        System.out.println(4);

		
		if (actdata.contains(Orgdata)) 
		{
			System.out.println("pass");
		} else
			System.out.println("fail");

		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.linkText("Sign Out")).click();
	}
	}