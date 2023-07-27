package Campaigns;

import org.testng.Assert;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.Property_Utility;
import Generic_Utility.Webdriver_Utility;
import POM.CampaignCreationPage1;
import POM.HomePage;
import POM.ValidationAndVerificationPage1;


public class CampaignsCreationTest extends BaseClass {

	//@Test(groups = "smoketest")
	@Test(groups = {"smoketest","regressiontest","sanitytest"})
	public void CampaignCreation1() throws Throwable {

		// driver.get(URL);
		Property_Utility plib = new Property_Utility();
		driver.manage().window().maximize();

		Webdriver_Utility wlib = new Webdriver_Utility();
		wlib.implicityWait(driver);
		HomePage home=new HomePage(driver);
		home.morelink(driver);
		home.campaignslinkText();
		CampaignCreationPage1 cam = new CampaignCreationPage1(driver);
		cam.campaigncreateimage();
		Java_Utility jlib = new Java_Utility();
		int RanNum = jlib.getRandomNum();
		Excel_Utility elib = new Excel_Utility();
		String CampData = elib.getExcelData("Campaigns", 0, 0) + RanNum;
		cam.campaignnametext(CampData);
        System.out.println(1);
        cam.savebutton();
        System.out.println(2);
        
        ValidationAndVerificationPage1 validate=new ValidationAndVerificationPage1(driver);
        System.out.println(2);

		validate.organizationValidation(driver, CampData);
		//System.out.println(3);
		//Thread.sleep(2000);
		//home.signoutLink(driver);
	}


}
	


	/*	String key = "webdriver.chrome.driver";
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

		driver.findElement(By.linkText("More")).click();
		driver.findElement(By.name("Campaigns")).click();
		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
	
        Random ran = new Random();
		int RanNum = ran.nextInt();

		Excel_Utility elib = new Excel_Utility();
		String CampData = elib.getExcelDataFormatter("Campaign", 0, 0) + RanNum;

		
		  FileInputStream fes = new
		  FileInputStream("./src/test/resources/ExcelSheetData.xlsx"); Workbook book =
		 WorkbookFactory.create(fes); Sheet sheet = book.getSheet("Campaigns"); Row
		  row = sheet.getRow(2); Cell cell = row.getCell(1); String Campaignsdata =
		 cell.getStringCellValue()+RanNum;
		 

		driver.findElement(By.name("campaignname")).sendKeys(CampData);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String actdata = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();

		if (actdata.contains(CampData))

		{
			System.out.println("Validation pass");

		} else {
			System.out.println("Validation fail");

		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.linkText("Sign Out")).click();*/



	


