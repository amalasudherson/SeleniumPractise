package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignCreationPage1 {

	public CampaignCreationPage1(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

// Declaration
	@FindBy(xpath = "//img[@alt='Create Campaign...']")
	private WebElement campaigncreateimage;

	@FindBy(name = "campaignname")
	private WebElement campaignnametext;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement savebutton;

//GetterMethod
	public synchronized WebElement getCampaigncreateimage() {
		return campaigncreateimage;
	}

	public synchronized WebElement getCampaignnametext() {
		return campaignnametext;
	}

	public synchronized WebElement getSavebutton() {
		return savebutton;
	}

//Business logic
	public void campaigncreateimage() {
		campaigncreateimage.click();
	}

	public void campaignnametext(String campaignname) {
		campaignnametext.sendKeys(campaignname);
	}

	public void savebutton() {
		savebutton.click();
	}

}
