package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {

	public WebDriver driver;

	@BeforeClass
	public void initiateBrowser() {
		System.setProperty("webdriver.chrome.driver", "/Users/rajak/Documents/Selenium/chromedriver");
		System.setProperty("webdriver.gecko.driver", "/Users/rajak/Documents/Selenium/geckodriver");

		// driver = new ChromeDriver();
		driver = new FirefoxDriver();
		Reporter.log("=====Browser Session Started=====", true);
		driver.manage().window().maximize();

		// Home Page
		driver.get("https://cai.tools.sap/");
		Reporter.log("=====Application Started=====", true);
	}

	@AfterClass
	public void quitBrowser() {

		driver.quit();
		Reporter.log("=====Browser Session Ended=====", true);
	}

}
