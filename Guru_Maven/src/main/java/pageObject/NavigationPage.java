package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavigationPage {

	WebDriver driver;
	@FindBy(xpath = "//li[@id='menu-posts']/a/div[3]")
	@CacheLookup
	WebElement posts;

	@FindBy(css = ".page-title-action")
	@CacheLookup
	WebElement addNew;

	@FindBy(xpath = "//input[@id='title']")
	@CacheLookup
	WebElement title;

	@FindBy(xpath = "//input[@id='publish']")
	@CacheLookup
	WebElement publish;

	@FindBy(linkText = "View post")
	@CacheLookup
	WebElement viewPost;

	@FindBy(xpath = "//div[@id='message']//p[1]")
	@CacheLookup
	WebElement view;

	@FindBy(css = "#wp-admin-bar-my-account")
	@CacheLookup
	WebElement admin;

	@FindBy(linkText = "Log Out")
	@CacheLookup
	WebElement logout;

	public NavigationPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getPosts() {
		return posts;

	}

	public WebElement addingNew() {
		return addNew;
	}

	public WebElement enterKeys() {
		return title;
	}

	public WebElement publishKeys() {
		return publish;
	}

	public WebElement viewPosts() {
		return viewPost;
	}

	public WebElement views() {
		return view;
	}

	public WebElement mouseHover() {
		return admin;
	}

	public WebElement logOut() {
		return logout;
	}

}

