package listeners;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(listeners.Listeners.class)

public class Login {

	WebDriver driver;

	@BeforeTest
	public void invokeBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\chrome_driver1\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
	}

	@Test(priority = 0)
	public void getLogin() {
		driver.get("http://demo.guru99.com/V4/");
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys("mngr34926");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("amUpenu");
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
	}

	// Forcefully failed this test as verify listener.
	@Test(priority = 1)
	public void TestToFail() {
		System.out.println("This method is used to fail the test.");
		Assert.assertTrue(false);
	}


}
