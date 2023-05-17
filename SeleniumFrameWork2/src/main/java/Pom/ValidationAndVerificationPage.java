package Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ValidationAndVerificationPage {

	public ValidationAndVerificationPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	//@FindBy(xpath = "//span[@id='dtlview OrganizationName']")
	private WebElement actualOrganizationData;
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement actualProductsData;
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement actualcampaingnsData;

	// getter method
	public WebElement getActualOrganizationData() {
		return actualOrganizationData;
	}

	// bussiness logics
	public String organizationValidation(WebDriver driver, String data) {
		String actData = actualOrganizationData.getText();

		if (actData.contains(data)) {
			System.out.println("pass");
		} else {
			System.out.println("fail");
		}
		return actData;
	}

	public String productsValidation(WebDriver driver, String data) {
		String actData = actualProductsData.getText();
		
		if (actData.contains(data)) {
			System.out.println("pass");
		} else {
			System.out.println("fail");
		}
		return actData;
	}

	public String campaingnValidation(WebDriver driver, String data) {
		String actData = actualcampaingnsData.getText();

		if (actData.contains(data)) {
			System.out.println("pass");
		} else {
			System.out.println("fail");
		}
		return actData;
		
	}

	public String ValidationandVerificationofProductdeletion(WebDriver driver, String data) {
		String actData = actualProductsData.getText();
	
		
		if (actData.contains(data)) {
			System.out.println("pass");
		} else {
			System.out.println("fail");
		}
		return actData;
	}

	public String ValidationandVerificationofCampaignAddition(WebDriver driver, String data) {
		String actData = actualcampaingnsData.getText();

		if (actData.contains(data))
		{
			System.out.println("pass");
		} else {
			System.out.println("fail");
		}
		return actData;
		
	}

	public String ValidationandVerificationofProductAddition(WebDriver driver, String data) {
String actData = actualProductsData.getText();
		
		if (actData.contains(data)) {
			System.out.println("pass");
		} else {
			System.out.println("fail");
		}
		return actData;
	}
		
	}
		
	
