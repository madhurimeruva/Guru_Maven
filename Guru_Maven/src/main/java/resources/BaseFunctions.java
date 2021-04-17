package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseFunctions {

	public WebDriver driver;

	public Properties prop;
	public WebDriver initializeDriver() throws IOException {
		prop = new Properties();

		FileInputStream fis = new FileInputStream("C:\\javaprac\\Guru_Maven\\src\\main\\java\\data.properties");

		prop.load(fis);

		String browserName = prop.getProperty("browser");

		String urlName = prop.getProperty("url");

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\chrome_driver1\\chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\geckodriver\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equals("internet explorer")) {
			System.setProperty("webdriver.ie.driver", "C:\\IEDriverServer\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();

		} else {
			System.out.println("Browser is not initiated correctly");
			System.exit(0);
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);

		return driver;
	}
}
