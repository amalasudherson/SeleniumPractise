package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductAndDeleteProductCreation1 {

	public CreateProductAndDeleteProductCreation1(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Declaration
	@FindBy(xpath = "//img[@title='Create Product...']")
	private WebElement createproductimage;

	@FindBy(name = "productname")
	private WebElement productnametext;

	@FindBy(xpath = "//input[@value='Delete']")
	private WebElement deleteproduct;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement savebutton;

	// Getters method
	public synchronized WebElement getCreateproductimage() {
		return createproductimage;
	}

	public synchronized WebElement getProductnametext() {
		return productnametext;
	}

	public synchronized WebElement getDeleteproduct() {
		return deleteproduct;
	}

	public synchronized WebElement getSavebutton() {
		return savebutton;
	}

	// Business logic

	public void createproductimage() {
		createproductimage.click();
	}

	public void productnametext(String proname) {
		productnametext.sendKeys(proname);
	}

	public void deleteproduct() {
		deleteproduct.click();
	}

	public void savebutton() {
		savebutton.click();
	}
}
