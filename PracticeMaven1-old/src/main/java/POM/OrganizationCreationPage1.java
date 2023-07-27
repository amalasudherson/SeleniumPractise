package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationCreationPage1 {

	public OrganizationCreationPage1(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Declaration
	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement OrganizationCreationImage;

	@FindBy(name = "accountname")
	private WebElement OrganizationNameTextFiled;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;


	// getter Method

	public synchronized WebElement getOrganizationCreationImage() {
		return OrganizationCreationImage;
	}

	public synchronized WebElement getOrganizationNameTextFiled() {
		return OrganizationNameTextFiled;
	}

	public synchronized WebElement getSaveButton() {
		return saveButton;
	}

	// Business logic
	public void clickorganizationcreateimage() {
		OrganizationCreationImage.click();
	}

	public void organizationnamestext(String orgname) {
		OrganizationNameTextFiled.sendKeys(orgname);
	}

	public void savebutton() {
		saveButton.click();

	

	
	}
}
