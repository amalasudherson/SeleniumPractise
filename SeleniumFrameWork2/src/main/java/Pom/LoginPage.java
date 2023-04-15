package Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	// create constructor(initialization)
		public LoginPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
			// pageFactory-->class
			// initElements-->Static method
		}

		// declaretion
		@FindBy(name = "user_name")
		private WebElement usernameEdtTxt;

		@FindBy(name = "user_password")
		private WebElement passwordEdtTxt;

		@FindBy(id = "submitButton")
		private WebElement submitBtn;

		//utilization
		public WebElement getUsernameEdtTxt() {
			return usernameEdtTxt;
		}

		public WebElement getPasswordEdtTxt() {
			return passwordEdtTxt;
		}

		public WebElement getSubmitBtn() {
			return submitBtn;
		}

		// business logic
		/**
		 * create method 
		 * @param username
		 * @param password
		 */
		public void loginToApp(String username, String password) {
			usernameEdtTxt.sendKeys(username);
			passwordEdtTxt.sendKeys(password);
			submitBtn.click();
		}
	}

