package utilis;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDataProvider {
	WebDriver driver;

	@BeforeTest
	public void invokeBrowser() throws IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\chrome_driver1\\chromedriver.exe");
		// driver.get("http://demosite.center/wordpress/wp-login.php");

	}
	@Test(dataProvider = "testdata1")
	public void test1(String username, String password) {
		driver.get("http://demosite.center/wordpress/wp-login.php");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		driver.findElement(By.id("btnLogin")).click();
		driver.close();
		System.out.println(username + " | " + password);
	}

	@DataProvider(name = "testdata1")
	public Object[][] getData() {

		String excelPath = "C:\\javaprac\\Guru_Maven\\excel\\data.xlsx";

		String sheetName = "sheet1";

		Object data[][] = testData(excelPath, sheetName);
		return data;
	}

	public static Object[][] testData(String excelPath, String sheetName) {

		ExcelUtilis excel = new ExcelUtilis(excelPath, sheetName);

		int rowCount = excel.getRowCount();

		int colCount = excel.getColumnCount();

		Object[][] data = new Object[rowCount - 1][colCount];

		// here i =1 is given bcoz in the 0th index its header so we dont need that data
		for (int i = 1; i < rowCount; i++) {
			for (int j = 0; j < colCount; j++) {

				String cellData = excel.getCellDataString(i, j);

				System.out.print(cellData + " | ");

				data[i - 1][j] = cellData;

			}

			System.out.println();
		}
		return data;
	}

}
