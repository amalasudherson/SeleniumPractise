package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignWithProductCreation1 {

	public CampaignWithProductCreation1(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Declaration

	@FindBy(xpath = "//img[@title='Create Product...']")
	private WebElement createproductimage;

	@FindBy(name = "productname")
	private WebElement productnametext;

	@FindBy(xpath = "//img[@alt='Create Campaign...']")
	private WebElement campaigncreateimage;

	@FindBy(name = "campaignname")
	private WebElement campaignnametext;

	@FindBy(xpath = "//img[@alt='Select']")
	private WebElement selectdropdown;

	@FindBy(id = "search_txt")
	private WebElement searchbox;

	@FindBy(name = "search")
	private WebElement searchbutton;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement savebutton;

	// Getter Method

	public synchronized WebElement getCreateproductimage() {
		return createproductimage;
	}

	public synchronized WebElement getProductnametext() {
		return productnametext;
	}

	public synchronized WebElement getCampaigncreateimage() {
		return campaigncreateimage;
	}

	public synchronized WebElement getCampaignnametext() {
		return campaignnametext;
	}

	public synchronized WebElement getSelectdropdown() {
		return selectdropdown;
	}

	public synchronized WebElement getSearchbox() {
		return searchbox;
	}

	public synchronized WebElement getSearchbutton() {
		return searchbutton;
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

	public void campaigncreateimage() {
		campaigncreateimage.click();
	}

	public void campaignnametext(String camname) {
		campaignnametext.sendKeys(camname);
	}

	public void selectdropdown() {
		selectdropdown.click();
	}

	public void searchbox(String data) {
		searchbox.sendKeys(data);
	}

	public void searchbutton() {
		searchbutton.click();
	}

	public void savebutton() {
		savebutton.click();

	}
}
