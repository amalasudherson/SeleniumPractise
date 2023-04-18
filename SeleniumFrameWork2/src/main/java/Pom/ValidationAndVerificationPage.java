package Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ValidationAndVerificationPage {

	public ValidationAndVerificationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@class='dvHeaderText']")
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
	public void organizationValidation(WebDriver driver, String data) {
		String actData = actualOrganizationData.getText();

		if (actData.contains(data)) {
			System.out.println("pass");
		} else {
			System.out.println("fail");
		}
	}

	public void productsValidation(WebDriver driver, String data) {
		String actData = actualProductsData.getText();
		
		if (actData.contains(data)) {
			System.out.println("pass");
		} else {
			System.out.println("fail");
		}
	}

	public void campaingnValidation(WebDriver driver, String data) {
		String actData = actualcampaingnsData.getText();

		if (actData.contains(data)) {
			System.out.println("pass");
		} else {
			System.out.println("fail");
		}
		
	}

	public void ValidationandVerificationofProductdeletion(WebDriver driver, String data) {
		String actData = actualProductsData.getText();
	
		
		if (actData.contains(data)) {
			System.out.println("pass");
		} else {
			System.out.println("fail");
		}
	}
}