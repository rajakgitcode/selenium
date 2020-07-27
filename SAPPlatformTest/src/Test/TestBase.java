package Test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import Utility.ExtentTestNGITestListener;
import Utility.Propertie;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
//import org.testng.Reporter;

/*
 * This Test Base class has a methods to initiate and close webdriver.
 */

@Listeners(Utility.ExtentTestNGITestListener.class)
public class TestBase {

	public WebDriver driver;

	@BeforeMethod
	public void initiateBrowser() throws MalformedURLException 
	{
		System.setProperty("webdriver.chrome.driver", "/Users/rajak/Documents/Selenium/chromedriver");
		System.setProperty("webdriver.gecko.driver", "/Users/rajak/Documents/Selenium/geckodriver");

		
		ChromeOptions chromeOptions = new ChromeOptions();
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
		capabilities.setCapability(CapabilityType.PLATFORM_NAME, Platform.LINUX);
		capabilities.setCapability("name", "PlatformSignUP");
		capabilities.setCapability("build", "TestBuild");
		
		
		//driver = new RemoteWebDriver(new URL(Propertie.remoteWebDriverURL), capabilities);
		driver = new ChromeDriver();
		//driver = new FirefoxDriver();
		Reporter.log("*****Browser Session Started*****", true);
		
		driver.manage().window().maximize();

		// Home Page
		driver.get(Propertie.applicationURL);
		
		Reporter.log("*****Application Started*****", true);
	}
	
	@AfterMethod
	public void captureScreen(ITestResult result) throws IOException 
	{
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); // time stamp
		
		if (result.getStatus() == ITestResult.FAILURE) 
		{
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE); // capture screenshot file
			File target = new File(
					System.getProperty("user.dir") + "/Screenshots/" + result.getName() + "_" + timeStamp + ".jpg");

			FileHandler.copy(source, target);
			System.out.println("screenshot captured");
		}

	}
	
	//To add test PASS/FAIL status cookie details to Zalenium dashboard
	@AfterMethod
	public void manageCookie()
	{
		driver.manage().addCookie(ExtentTestNGITestListener.cookie);
		
	}

	@AfterMethod
	public void quitBrowser() {

		driver.quit();
		Reporter.log("*****Browser Session Ended*****", true);
	}

}
