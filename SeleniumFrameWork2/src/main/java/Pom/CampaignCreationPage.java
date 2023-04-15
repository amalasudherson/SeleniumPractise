package Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignCreationPage {

	public CampaignCreationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Declaration
	@FindBy(xpath = "//img[@alt='Create Campaign...']")
	private WebElement campaigncreateimage;

	@FindBy(name = "campaignname")
	private WebElement campaignnametext;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement savebutton;

	// Getters method
	public WebElement getCampaigncreateimage() {
		return campaigncreateimage;
	}

	public WebElement getCampaignnametext() {
		return campaignnametext;
	}

	public WebElement getSavebutton() {
		return savebutton;
	}

	// Business logic
	public void campaigncreateimage() {
		campaigncreateimage.click();
	}

	public void campaignnametext(String camname) {
		campaignnametext.sendKeys(camname);
	}

	public void savebutton() {
		savebutton.click();
	}
}