package KeywordActionLibrary;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import Utility.Propertie;

public class KeywordAction2 
{
	public static WebDriver driver;
	WebDriverWait wait;
	WebElement element;
	SoftAssert softAssert = new SoftAssert();
	
	public void openBrowser(String browserName)
	{
		if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", Propertie.geckoDriverPath);
			driver = new FirefoxDriver();	
		}
		else if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", Propertie.chromeDriverPath);
			driver = new ChromeDriver();	
		}
		driver.manage().window().maximize();
		
	}
	
	public void openURL(String url)
	{
		driver.get("https://cai.tools.sap/");
		driver.manage().timeouts().implicitlyWait(Propertie.timeOutValue, TimeUnit.SECONDS);
	}
	
	public By locator(String locatorType, String locatorValue)
	{
		By by;
		 
		switch(locatorType)
		{
			case "id":
					by = By.id(locatorValue);
					break;
			case "name":
					by = By.name(locatorValue);
					break;
			case "xpath":
					by = By.xpath(locatorValue);
					break;
			case "css":
					by = By.cssSelector(locatorValue);
					break;
			case "classname":
					by = By.className(locatorValue);
					break;
			case "tagname":
					by = By.tagName(locatorValue);
					break;
			case "linktext":
					by = By.linkText(locatorValue);
					break;
			case "partiallinktext":
					by = By.partialLinkText(locatorValue);
					break;
			default:
					by = null;
					break;
		}
		return by;
		
	}
	
	
	public WebElement elementM(String locatorType, String locatorValue)
	{
		element = driver.findElement(locator(locatorType, locatorValue));
		return element;
	}
	
	public void enter_text(String locatorType, String locatorValue, String text)
	{
		element = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(elementM(locatorType,locatorValue)));
		element.clear();
		element.sendKeys(text);
	}
	
	public void click(String locatorType, String locatorValue)
	{
		element = new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(locator(locatorType, locatorValue)));
		element.click();
	}
	
	public void focusOnButton(String locatorType, String locatorValue)
	{
		WebElement element = driver.findElement(locator(locatorType,locatorValue));
		element = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(Keys.DOWN);
	}
	
	public void clickOnButton(String locatorType, String locatorValue)
	{
		WebElement element = driver.findElement(locator(locatorType,locatorValue));
		element = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(element));
		element.click();
	}
	
	public void clickOnLink(String locatorType, String locatorValue)
	{
		element = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(elementM(locatorType,locatorValue)));
		element.click();
	}
	
	public void switchToIframe(String locatorType, String locatorValue)
	{
		driver = new WebDriverWait(driver, 20).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator(locatorType,locatorValue)));
	}
	
	public void verify(String locatorType, String locatorValue, String expectedText)
	{
		element = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(locator(locatorType,locatorValue)));
		softAssert.assertEquals(element.getText(), expectedText, "Expected Text Not Matching.");
	}
	
	public void verifyPartialText(String locatorType, String locatorValue, String expectedText)
	{
		element = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(locator(locatorType,locatorValue)));
		softAssert.assertTrue(element.getText().contains(expectedText), "Expected Text Not Matching.");
	}
	
	public void closeBrowser()
	{
		driver.quit();
	}
}
