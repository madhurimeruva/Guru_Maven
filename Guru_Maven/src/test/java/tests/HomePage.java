package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.LoginPage;
import pageObject.NavigationPage;
import resources.BaseFunctions;

public class HomePage extends BaseFunctions {

	WebDriver driver;

	@BeforeTest
	public void invokeBrowser() throws IOException {
		driver = initializeDriver();
		// driver.get("http://demosite.center/wordpress/wp-login.php");
		driver.get(prop.getProperty("url"));
	}

	@Test
	public void basePageNavigation() throws InterruptedException {

		LoginPage lp = new LoginPage(driver);

		lp.login_wordPress("admin", "demo123");

		NavigationPage np = new NavigationPage(driver);

		np.getPosts().click();

		Thread.sleep(3000);

		np.addingNew().click();

		Thread.sleep(2000);

		np.enterKeys().sendKeys("selenium");

		np.publishKeys().click();

		Boolean actualPost = np.views().getText().equalsIgnoreCase("Post published. View post");
		Assert.assertTrue(actualPost);

		np.viewPosts().click();


	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
