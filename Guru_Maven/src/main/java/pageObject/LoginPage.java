package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "user_login")
	@CacheLookup
	WebElement userName;

	@FindBy(id = "user_pass")
	@CacheLookup
	WebElement password;

	@FindBy(id = "wp-submit")
	@CacheLookup
	WebElement login;

	public void login_wordPress(String uid, String pwd) {
		userName.sendKeys(uid);

		password.sendKeys(pwd);

		login.click();

	}


}
