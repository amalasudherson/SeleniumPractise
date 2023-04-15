package Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCreationPage {
	
	public ProductCreationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Declaration
	@FindBy(xpath = "//img[@title='Create Product...']")
	private WebElement productcreationimage;
	
	@FindBy(name = "productname")
	private WebElement productnametext;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement savebutton;
	
	
	//Getters method
	public WebElement getProductcreationimage() {
		return productcreationimage;
	}

	public WebElement getProductnametext() {
		return productnametext;
	}

	public WebElement getSavebutton() {
		return savebutton;
	}
	
	
	//Business logic
	public void productcreationimage()
	{
		productcreationimage.click();
	}
	
	public void productnametext(String proname)
	{
		productnametext.sendKeys(proname);
	}
	
	public void savebutton()
	{
		savebutton.click();
	}
}
	

