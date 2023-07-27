package Product;

import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.Property_Utility;
import Generic_Utility.Webdriver_Utility;
import POM.HomePage;
import POM.ProductCreation1;
import POM.ValidationAndVerificationPage1;

public class CreateProduct2 extends BaseClass  {
	@Test
	public void CreateProduct() throws Throwable { 


	
		Property_Utility plib = new Property_Utility();
		driver.manage().window().maximize();

		Webdriver_Utility wlib = new Webdriver_Utility();
		wlib.implicityWait(driver);
		HomePage home=new HomePage(driver);
		home.ProductLinkText();
	ProductCreation1 pro=new ProductCreation1(driver);
	pro.productcreationimage();

	Java_Utility jlib = new Java_Utility();
	int RanNum = jlib.getRandomNum();

	Excel_Utility elib = new Excel_Utility();
	String productdata = elib.getExcelData("Product", 2, 1) + RanNum;
	pro.productnametext(productdata);
	pro.savebutton();
	
	ValidationAndVerificationPage1 validate=new ValidationAndVerificationPage1(driver);

	validate.productsValidation(driver, productdata);
	home.signoutLink(driver);
}
}