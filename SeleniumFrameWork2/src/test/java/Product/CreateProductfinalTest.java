package Product;

import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.Java_Utility;
import Pom.HomePage;
import Pom.ProductCreationPage;
import Pom.ValidationAndVerificationPage;

public class CreateProductfinalTest  extends BaseClass  {
@Test
	public void CreateProduct() throws Throwable {

	HomePage home=new HomePage(driver);
	home.morelink(driver);
	home.ProductLinkText();
	
	ProductCreationPage pro=new ProductCreationPage(driver);
	pro.productcreationimage();
	
	
	Java_Utility jlib=new Java_Utility();
	int RanNum = jlib.getRandomNum();
    Excel_Utility elib=new Excel_Utility();
	String ProductsData  = elib.getExcelData("Product", 0, 0)+RanNum;
	
	pro.productnametext(ProductsData);
    pro.savebutton();
	System.out.println("1");
	
	ValidationAndVerificationPage validate=new ValidationAndVerificationPage(driver);
	System.out.println("2");

	
	validate.productsValidation(driver, ProductsData);
	
	System.out.println("3");
	 Thread.sleep(5000);
	home.signoutLink(driver);

}

}


