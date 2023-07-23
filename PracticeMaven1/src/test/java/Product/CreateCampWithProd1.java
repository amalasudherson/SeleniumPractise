package Product;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Generic_Utility.Excel_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.Webdriver_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampWithProd1 {
		
		public static void main(String[] args) throws Throwable {

			String key="webdriver.chrome.driver";
			String Value="./src/main/resources/chromedriver.exe";
			System.setProperty(key, Value);
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        
	        Webdriver_Utility wlib=new Webdriver_Utility();
	        wlib.implicityWait(driver);
	       // driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	        
	        FileInputStream fis=new FileInputStream("./src/test/resources/PropertyFileData.properties");
	        Properties pro=new Properties();
	        pro.load(fis);
	        String URL = pro.getProperty("url");
	        String USERNAME = pro.getProperty("username");
	        String PASSWORD = pro.getProperty("password");
	        driver.get(URL);
			//driver.get("http://localhost:8888/");
			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	        driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	        driver.findElement(By.id("submitButton")).click();
	        
	        driver.findElement(By.linkText("Products")).click();
	        driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
	        
//	        Random ran=new Random();
//	        int RanNUm = ran.nextInt(1000);
	        
	        Java_Utility jlib=new Java_Utility();
	        int RanNum = jlib.getRandomNum();
	        
	        Excel_Utility elib=new Excel_Utility();
	        String productdata = elib.getExcelData("product", 0, 0)+RanNum;
	        
	   /*     FileInputStream fes =new FileInputStream("./src/test/resources/ExcelSheetData.xlsx");
	        Workbook book = WorkbookFactory.create(fes);
	        Sheet sheet = book.getSheet("product");
	        Row row = sheet.getRow(0);
	        Cell cel = row.getCell(0);
	        String productdata = cel.getStringCellValue()+RanNum;*/
	        
	        driver.findElement(By.name("productname")).sendKeys(productdata);
	        
	        driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	        
	      driver.findElement(By.linkText("More")).click();
	    	driver.findElement(By.linkText("Campaigns")).click();
	    	
	    	driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
	    	
	    	String CampData = elib.getExcelData("Campaigns", 0, 0)+RanNum;
	    	
	    	/* FileInputStream fes1=new FileInputStream("./src/test/resources/ExcelSheetData.xlsx");
	         Workbook book1 = WorkbookFactory.create(fes1);
	         Sheet sheet1 = book1.getSheet("Campaigns");
	         Row row1 = sheet1.getRow(0);
	         Cell cell1 = row1.getCell(0);
	         String CampData = cell1.getStringCellValue()+RanNum;*/
	    	
	    	driver.findElement(By.name("campaignname")).sendKeys(CampData);
	    	
	    driver.findElement(By.xpath("//img[@alt='Select']")).click();
	    
	    wlib.switchwindow(driver, "Products&action");
	 /*  Set<String> allId = driver.getWindowHandles();//org   //cont  //prd
	      Iterator<String> id = allId.iterator();
	      
	      while(id.hasNext())
	      {
	    	  String wid = id.next();//org   //cont
	    	  driver.switchTo().window(wid);
	    	  String title = driver.getTitle();
	    	  
	    	  if(title.contains("Products&action"))
	    	  {
	    		  break;
	    	  }
	      }*/
	    	  driver.findElement(By.id("search_txt")).sendKeys(productdata);
	    	  driver.findElement(By.name("search")).click();
	    	  
	    	  //dynamic xpath
	    	//  driver.findElement(By.xpath("//a[text()='iphone776']")).click();
	    	 driver.findElement(By.xpath("//a[text()='"+productdata+"']")).click();
	    	  
	    	 wlib.switchwindow(driver, "Campaigns&action");
	    	  
	    	/*  Set<String> allId1 = driver.getWindowHandles();//org   //cont  //prd
	          Iterator<String> id1 = allId1.iterator();
	          
	          while(id1.hasNext())
	          {
	        	  String wid1 = id1.next();//org
	        	  driver.switchTo().window(wid1);
	        	  String title = driver.getTitle();
	        	  
	        	  if(title.contains("Campaigns&action"))
	        	  {
	        		  break;
	        	  }
	          }*/
	    	  
	          driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	          
	        String act = driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();
	        if(act.contains(CampData))
	        {
	        	System.out.println("camp pass");
	        }
	        else
	        {
	        	System.out.println("camp fail");
	        }
	        
	        String actData = driver.findElement(By.xpath("//span[@id='dtlview_Product']")).getText();
	        if(actData.contains(productdata))
	        {
	        	System.out.println("product Pass");
	        }
	        else
	        {
	        	System.out.println("Product fail");
	        }
	        
	        driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
	        driver.findElement(By.linkText("Sign Out")).click();
	          }
	
	}


