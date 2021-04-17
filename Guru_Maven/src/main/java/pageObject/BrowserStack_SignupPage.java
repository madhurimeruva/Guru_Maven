package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BrowserStack_SignupPage {

	WebDriver driver;

	public BrowserStack_SignupPage(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "user_full_name")
	@CacheLookup
	WebElement user;

	@FindBy(id = "user_email_login")
	@CacheLookup
	WebElement email;

	@FindBy(css = "#user_password")
	@CacheLookup
	WebElement password;

	@FindBy(id = "user_submit")
	@CacheLookup
	WebElement submit;

	public WebElement firstName() {
		return user;

	}

	public WebElement email() {
		return email;

	}

	public WebElement password() {
		return password;

	}

	public WebElement login() {
		return submit;

	}
}
