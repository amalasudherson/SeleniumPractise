package Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductandDeleteProductCreationPage {
	
	public CreateProductandDeleteProductCreationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Declaration
	@FindBy(xpath = "//img[@title='Create Product...']")
	private WebElement createproductimage;
	
	@FindBy(name="productname")
	private WebElement productnametext;
	
	@FindBy(xpath = "//input[@value='Delete']")
	private WebElement deleteproduct;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement savebutton;
	
	//Getters method

	public WebElement getCreateproductimage() {
		return createproductimage;
	}

	public WebElement getProductnametext() {
		return productnametext;
	}

	public WebElement getDeleteproduct() {
		return deleteproduct;
	}

	public WebElement getSavebutton() {
		return savebutton;
	}
	
	//Business logic
	
	public void createproductimage()
	{
		createproductimage.click();
	}
	
	public void productnametext(String proname)
	{
		productnametext.sendKeys(proname);
	}
	public void deleteproduct()
	{
		deleteproduct.click();
	}
	public void savebutton()
	{
		savebutton.click();
	}
	
}
	