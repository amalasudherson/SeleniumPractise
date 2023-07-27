package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCreation1 {
	public ProductCreation1(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

//	Declaration
	@FindBy(xpath = "//img[@alt='Create Product...']")
	private WebElement ProductCreationimage;

	@FindBy(name = "productname")
	private WebElement productnametextfiled;

	@FindBy(xpath = "//input[@title='Save [Alt+S]'][1]")
	private WebElement savebutton;

	// getter Method

	public synchronized WebElement getCreateProductimage() {
		return ProductCreationimage;
	}

	public synchronized WebElement getProductnametext() {
		return productnametextfiled;
	}

	public synchronized WebElement getSavebutton() {
		return savebutton;
	}

	// Business logic
	public void productcreationimage() {
		ProductCreationimage.click();
	}

	public void productnametext(String proname) {
		productnametextfiled.sendKeys(proname);
	}

	public void savebutton() {
		savebutton.click();
	}
}
