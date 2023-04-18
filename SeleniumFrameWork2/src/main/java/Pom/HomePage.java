package Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utility.Wbdriver_utility;

public class HomePage {
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Declaration
	
	@FindBy(linkText="Products")
	private WebElement productLinkText; 
	
	@FindBy(linkText="Organizations")
	private WebElement organizationslinkText;
	
	@FindBy(linkText = "More")
	private WebElement morelink;
	
	@FindBy(linkText = "Campaigns")
	private WebElement campaignslinkText;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement signoutimg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signoutLinkText;
	
	//Getters method

	public WebElement getOrganizationLinkText() {
		return organizationslinkText;
	}
	public WebElement getSignoutImg() {
		return signoutimg;
	}
	public WebElement getSignoutLinkText( ) {
		return signoutLinkText;
	}

	public WebElement getMoreLink() {
		return morelink;
	}

	public WebElement getCampaignsLinkText() {
		return getCampaignsLinkText();
	}

	public WebElement getProductLinkText() {
		return getProductLinkText();
	}
	
	//Business logic for Product
	
	public void ProductLinkText()
	{
	productLinkText.click();
	}

	
	//Business logic for More
	public void morelink(WebDriver driver)
	{
		Wbdriver_utility wlib=new Wbdriver_utility();
		wlib.mouseOverOnElement(driver, morelink);
	}
	
	//Campaign
	public void campaignslinkText()
	{
		
		campaignslinkText.click();
	}
	
	//Organization
	public void clickorganizationlinkText()
	{
		organizationslinkText.click();
	}
	

	//Sign out
	public void signoutLink(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.moveToElement(signoutimg).perform();
		signoutLinkText.click();
	}
}

	

	