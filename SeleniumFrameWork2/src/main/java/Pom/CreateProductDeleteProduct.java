package Pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductDeleteProduct {
	
	public CreateProductDeleteProduct (WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

@FindBy(xpath="//img[@alt='Create Product...']")
private WebElement productCreateImage;

@FindBy(name="productname")
private WebElement productname;

@FindBy(xpath="//input[@title='Save [Alt+S]']")
private WebElement saveButton;

@FindBy(xpath="(//a[.='Products'])[2]")
private WebElement productBackButton;

@FindBy(xpath="//input[@value='Delete']")
private WebElement deleteProduct;


//Getters method
public WebElement getProductBackButton() {
	return productBackButton;
}

public WebElement getProductCreateImage() {
	return productCreateImage;
}

public WebElement getProductname() {
	return productname;
}

public WebElement getSaveButton() {
	return saveButton;
}

public void productCreateImage()
{
	productCreateImage.click();
}
/**
 * This Method is used to Pass Value to Organization TextField
 */
public void productTextField(String orgName)
{
	productname.sendKeys(orgName);
}
/**
 * This Method is used to Save OrgName
 */

public void saveButton()
{
	saveButton.click();	
}
public void productBackButton(WebDriver driver)
{
	productBackButton.click();
}

public void deleteProduct()
{
	deleteProduct.click();
}

public void verification(WebDriver driver,String productdata) {
	 List<WebElement> Lists = driver.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr/td[3])[position()>1]"));
        
        boolean flag=false;
        for(WebElement wb:Lists)
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
        	System.out.println("deleted");
        	
        }
        else
        {
        	System.out.println("not deleted");
        }
}
}
	
	

