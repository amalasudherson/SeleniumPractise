package Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationCreationPage {

	public OrganizationCreationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Declaration
	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement organizationcreateimage;

	@FindBy(name = "accountname")
	private WebElement organizationnametext;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement savebutton;

	// Getters method

	public WebElement getOrganizationcreateimage() {
		return organizationcreateimage;
	}

	public WebElement getOrganizationnametext() {
		return organizationnametext;
	}

	public WebElement getSavebutton() {
		return savebutton;
	}

	// Business logic
	public void organizationcreateimage() {
		organizationcreateimage.click();
	}

	public void organizationnamestext(String orgname) {
		organizationnametext.sendKeys(orgname);
	}

	public void savebutton() {
		savebutton.click();
	}
}
