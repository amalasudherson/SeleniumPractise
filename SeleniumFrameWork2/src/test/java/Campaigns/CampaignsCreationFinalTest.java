package Campaigns;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.Property_Utility;
import Pom.CampaignCreationPage;
import Pom.HomePage;
import Pom.ValidationAndVerificationPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CampaignsCreationFinalTest extends BaseClass {

	@Test(groups = {"smoketest","regressiontest","sanitytest"})
	public void CampaignCreation1() throws Throwable {

		// driver.get(URL);
		HomePage home = new HomePage(driver);
		home.morelink(driver);
		home.campaignslinkText();

		CampaignCreationPage cam = new CampaignCreationPage(driver);
		cam.campaigncreateimage();

		Java_Utility jlib = new Java_Utility();
		int RanNum = jlib.getRandomNum();
		Excel_Utility elib = new Excel_Utility();
		String CampData = elib.getExcelData("Campaigns", 0, 0) + RanNum;

		cam.campaignnametext(CampData);

		cam.savebutton();
		 System.out.println("1");

		ValidationAndVerificationPage validate = new ValidationAndVerificationPage(driver);
		validate.campaingnValidation(driver, CampData);
		//Assert.assertEquals(actData, exceldata);
	     System.out.println("2");
	     Thread.sleep(5000);
	     home.signoutLink(driver);	
	    
	}
}