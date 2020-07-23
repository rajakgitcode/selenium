package Test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.Reporter;
//import org.testng.Reporter;

@Listeners(Utility.ExtentTestNGITestListener.class)
public class TestBase {

	public WebDriver driver;

	@BeforeClass
	public void initiateBrowser() {
		System.setProperty("webdriver.chrome.driver", "/Users/rajak/Documents/Selenium/chromedriver");
		System.setProperty("webdriver.gecko.driver", "/Users/rajak/Documents/Selenium/geckodriver");
		
		// driver = new ChromeDriver();
		driver = new FirefoxDriver();
		Reporter.log("*****Browser Session Started*****", true);
		driver.manage().window().maximize();

		// Home Page
		driver.get("https://cai.tools.sap/");
		Reporter.log("*****Application Started*****", true);
	}

	@AfterMethod
	 public void captureScreen(ITestResult result) throws IOException
	 {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); //time stamp
	  if(result.getStatus()==ITestResult.FAILURE)
	  {
	   TakesScreenshot ts=(TakesScreenshot)driver;
	   File source=ts.getScreenshotAs(OutputType.FILE); // capture screenshot file
	   File target=new File(System.getProperty("user.dir")+"/Screenshots/"+result.getName() + "_" + timeStamp + ".jpg");
	   
	   FileHandler.copy(source,target);
	   System.out.println("screenshot captured");
	  }
	   
	 }
	
	@AfterClass
	public void quitBrowser() {

		driver.quit();
		Reporter.log("*****Browser Session Ended*****", true);
	}

}
