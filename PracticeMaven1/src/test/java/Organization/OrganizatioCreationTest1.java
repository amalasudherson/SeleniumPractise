package Organization;

import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.Property_Utility;
import Generic_Utility.Webdriver_Utility;
import POM.HomePage;
import POM.OrganizationCreationPage1;
import POM.ValidationAndVerificationPage1;

public class OrganizatioCreationTest1 {

	public class CreateOrganization1Test extends BaseClass{
	
@Test
	public void CreateOrganization() throws Throwable { 
		
		Property_Utility plib = new Property_Utility();
		driver.manage().window().maximize();

		Webdriver_Utility wlib = new Webdriver_Utility();
		wlib.implicityWait(driver);
		HomePage home=new HomePage(driver);
		home.clickOrganizationlinkText();
		OrganizationCreationPage1 org=new OrganizationCreationPage1(driver);
		org.clickorganizationcreateimage();

		Java_Utility jlib = new Java_Utility();
		int RanNum = jlib.getRandomNum();

		Excel_Utility elib = new Excel_Utility();
		String exceldata = elib.getExcelData("Organization", 2, 1) + RanNum;
		org.organizationnamestext(exceldata);
		org.savebutton();
		
		ValidationAndVerificationPage1 validate=new ValidationAndVerificationPage1(driver);
	
		validate.organizationValidation(driver, exceldata);
		home.signoutLink(driver);
		
		
		
		}
	}
}


