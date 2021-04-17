package tests;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.apache.log4j.LogManager;
//import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.BrowserStack_SignupPage;

public class Browserstack_LoginPage {
	WebDriver driver;

	private static Logger log = LogManager.getLogger(Browserstack_LoginPage.class.getName());

	@BeforeTest
	public void invokeBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\chrome_driver1\\chromedriver.exe");

	}



	@Test(dataProvider = "testData")
	public void login(String name, String email, String password) throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);

		driver.get("https://www.browserstack.com/users/sign_up");
		log.info("Url is opened");

		BrowserStack_SignupPage stack = new BrowserStack_SignupPage(driver); //
		// stack.signUp(name, email, password);
		stack.firstName().sendKeys(name);
		log.debug("first name was entered");
		stack.email().sendKeys(email);
		log.debug("password was entered");
		stack.password().sendKeys(password);
		Thread.sleep(2000); // stack.login().click();
		driver.close();

		log.info("browser is closed");
		System.out.println(name + " " + email + " " + password);
	}

	@DataProvider(name = "testData")
	public Object[][] getData() {

		Object[][] data = new Object[2][3];
		// 1st row
		data[0][0] = "TestUser";
		data[0][1] = "TestUser@gmail.com";
		data[0][2] = "TestUserPassword";
		// 2nd row
		data[1][0] = "madhu";
		data[1][1] = "madhu.j10@gmail.com";
		data[1][2] = "madhu1@test";

		return data;

	}



}
