package Product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Generic_Utility.Excel_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.Property_Utility;
import Generic_Utility.Wbdriver_utility;
import Pom.CreateProductandDeleteProductCreationPage;
import Pom.HomePage;
import Pom.LoginPage;
import Pom.ValidationAndVerificationPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProductandDeleteProduct {

	public static void main(String[] args) throws Throwable {
		//1st approach to launch single browser 
		//WebDriver driver=new ChromeDriver();
		
		//2nd approach to launch single browser 
		/*WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();*/
		
		//3rd approach to launch multiple through property file browser 
		WebDriver driver;
		Property_Utility plib=new Property_Utility();
		String BROWSER = plib.getKeyValue("browser");
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if (BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else if (BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else
		{
			driver=new ChromeDriver();
		}
		
		Wbdriver_utility wlib=new Wbdriver_utility();
		//wlib.max(driver);
		wlib.implicitwait(driver);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Property_Utility plib=new Property_Utility();
		String URL = plib.getKeyValue("url");
		String USERNAME = plib.getKeyValue("username");
		String PASSWORD = plib.getKeyValue("password");

		
		/*FileInputStream fis=new FileInputStream("./src/test/resources/commondata.properties.txt");
		Properties pro=new Properties();
		pro.load(fis);
		String URL = pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");*/
		
		driver.get(URL);
		
		//driver.get("http://localhost:8888/");
		LoginPage LoginPage=new LoginPage(driver);
		LoginPage.loginToApp(USERNAME, PASSWORD);
		
//		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("submitButton")).click();
		
		HomePage home=new HomePage(driver);
		home.ProductLinkText();
		//driver.findElement(By.xpath("//a[text()='Products']")).click();
		
		CreateProductandDeleteProductCreationPage cpdpcp=new CreateProductandDeleteProductCreationPage(driver);
		cpdpcp.createproductimage();
		//driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		
		//Random ran=new Random();
		//int RanNum=ran.nextInt(1000);
		Java_Utility jlib=new Java_Utility();
		int RanNum = jlib.getRandomNum();
		
		Excel_Utility elib=new Excel_Utility();
		//String productdata = elib.getExceldata("Product", 0, 0)+RanNum;
		String productdata = elib.getExcelDataFormatter("Product", 0, 0)+RanNum;
		
		/*FileInputStream fes=new FileInputStream("./src/test/resources/Testdata.xlsx");
		Workbook book = WorkbookFactory.create(fes);
		Sheet sheet = book.getSheet("Product");
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);
		String productdata = cell.getStringCellValue()+RanNum;*/
		
		cpdpcp.productnametext(productdata);
		//driver.findElement(By.name("productname")).sendKeys(productdata);
		System.out.println(productdata);
		
		cpdpcp.savebutton();
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//home.productslink();
		//driver.findElement(By.xpath("//a[text()='Products']")).click();
		
		driver.findElement(By.xpath("//table[@class='lvt small']/tbody//td//a[text()='"+productdata+"']/../preceding-sibling::td[1]")).click();
		
		cpdpcp.deleteproduct();
		//driver.findElement(By.xpath("//input[@value='Delete']")).click();
		
		wlib.switchToAlertAndAccpect(driver);
		//Alert alert = driver.switchTo().alert();
		//alert.accept();
		
		ValidationAndVerificationPage validate=new ValidationAndVerificationPage(driver);
		validate.ValidationandVerificationofProductdeletion(driver, productdata);
		/*List<WebElement> lists = driver.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr/td[3])[position()>1]"));
		
		boolean flag=false;
		for(WebElement wb:lists)
		{
			String act = wb.getText();
			if(act.contains(productdata))
			{
				flag=true;
				break;
			}
		}
		if(flag)
		{
			System.out.println("Product deleted");
		}
		else
		{
			System.out.println("Product not deleted");
		}*/
		
		home.signoutLink(driver);
		
	}

}