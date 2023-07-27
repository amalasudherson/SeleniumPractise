package POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerificationAndValidationPage {
	public VerificationAndValidationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="span.dvHeaderText")private WebElement actualOrgData;
	@FindBy(xpath="//span[@class='lvtHeaderText']")private WebElement actualProdData;
	
	//getter methods
	public WebElement getActualOrgData() {
		return actualOrgData;
	}
	public WebElement getActualProddata() {
		return actualProdData;
	}

	/*business logic
	
	 * this method is used to validate whether orgnisation created as expected or not
	 * @param driver
	 * @param expected_org_data
	 * @author Amla
	 */
	public void orgCreateValidation(String expected_org_data)
	{
		String actorgdata=actualOrgData.getText();
		if(actorgdata.contains(expected_org_data))
		{
			System.out.println("Organisation validation pass");
		}
		else
		{
			System.out.println("Organisation validation fail");
		}
	}
	/**
	 * this method is used to verify whether product is created as expected or not
	 * @param expectedProdData
	 * @author jhansi
	 * */
	
	public void prodCreateValidation(String expectedProdData)
	{
		String actdata = actualProdData.getText();
		if(actdata.contains(expectedProdData))
		{
			System.out.println("Product validation pass");
		}
		else
			System.out.println("Product validation fail");
	}
	
	/**
	 * this method is used to verify whether seleted product is deleted or not
	 * @param products_list
	 * @param exp_del_data
	 * @author jhansi
	 */
	public void prodDeleteValidation(List<WebElement> products_list,String exp_del_data) 
	{
		boolean flag=false;
		for(WebElement we:products_list)
		{
			String prod_data = we.getText();
			if(prod_data.equals(exp_del_data))
			{
				flag=true;
				break;
			}

		}
		if(flag)
		{
			System.out.println("Product "+exp_del_data+" not deleted");
		}
		else
		{
			System.out.println("Product "+exp_del_data+" deleted successfully");
		}
	}
}

