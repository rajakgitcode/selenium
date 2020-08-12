package KeywordActionLibrary;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import Utility.Propertie;

public class KeywordAction 
{
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static WebElement element;
	public static SoftAssert softAssert = new SoftAssert();
	
	public static void openBrowser()
	{
		System.setProperty("webdriver.gecko.driver", Propertie.geckoDriverPath);
		driver = new FirefoxDriver();
		driver.manage().window().maximize();	
		
	}
	
	public static void startBrowser()
	{
		driver = new FirefoxDriver();
		//driver.get("https://cai.tools.sap/");
		driver.manage().window().maximize();	
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public static void initiateBrowser()
	{
		driver = new FirefoxDriver();
		//driver.get("https://cai.tools.sap/");
		driver.manage().window().maximize();	
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	
	  public static void navigateToUrl(String url) { driver.navigate().to(url); }
	  
	  public static void navigateToPage(String url) { driver.navigate().to(url); }
	  
	  public static void openURL(String url) { driver.get(url);
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); }
	 
	
	public static void clickOnBrowserBackButton()
	{
		driver.navigate().back();
	}
	
	public static void clickOnBrowserForwardButton()
	{
		driver.navigate().back();
	}
	
	public static void navigateBack()
	{
		driver.navigate().back();
	}
	
	public static void navigateForward()
	{
		driver.navigate().back();
	}
	
	
	  public static void click(WebElement element) 
	  { 
		  element = new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(element)); element.click();
	  }
	  
	  public static void enter(WebElement element, String text) 
	  { 
		element = new
		WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(text); 
	  }
	  
	  public static void click_CookieOKButton(String locatorType, String locatorValue) 
	  { 
		  element = driver.findElement(By.xpath("//div[contains(text(),'OK')]"));
		  element.click(); 
	  }
	 
	
	public static void clickOnCookieOKButton() 
	{
		WebElement cookieOKButton = driver.findElement(By.xpath("//div[contains(text(),'OK')]")); 
		cookieOKButton = new WebDriverWait(driver, Propertie.timeOutValue)
				.until(ExpectedConditions.elementToBeClickable(cookieOKButton));
		cookieOKButton.click();

	}

	public static void clickOnSignUpButton() {
		WebElement signUpButton = driver.findElement(By.cssSelector(".sap-btn-action > div:nth-child(1)"));
		signUpButton = new WebDriverWait(driver, Propertie.timeOutValue)
				.until(ExpectedConditions.elementToBeClickable(signUpButton));
		signUpButton.click();
	}

	public static void switchToIframe() {

		WebElement iFrame = driver.findElement(By.xpath("//iframe[@id = 'IDS_UI_Window']"));
		driver = new WebDriverWait(driver, Propertie.timeOutValue)
				.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iFrame));
		//driver.switchTo().frame(0);

	}
	
	
	  //Registration Page 
	public static void enterFirstName(String str)
	{
	  WebElement firstName = driver.findElement(By.xpath("//*[@id='firstName']"));
	  firstName = new WebDriverWait(driver,
	  Propertie.timeOutValue).until(ExpectedConditions.visibilityOf(firstName));
	  firstName.clear(); firstName.sendKeys(str); 
	 }
	  
	  public static void enterLastName(String str) 
	  {
	  
		  WebElement lastName = driver.findElement(By.xpath("//*[@id='lastName']"));
		  lastName = new WebDriverWait(driver,
		  Propertie.timeOutValue).until(ExpectedConditions.visibilityOf(lastName));
		  lastName.clear(); lastName.sendKeys(str); 
	  }
	  
	  public static void enterMail(String str) 
	  { 
		  WebElement mail = driver.findElement(By.xpath("//*[@id='mail']")); 
		  mail = new WebDriverWait(driver,Propertie.timeOutValue).until(ExpectedConditions.visibilityOf(mail));
		  mail.clear(); mail.sendKeys(str); 
	  }
	  
	 
	  public static void enterNewPassword(String str)
	  { 
		  WebElement newPassword = driver.findElement(By.xpath("//*[@id='newPasswordInput']")); 
		  newPassword = new WebDriverWait(driver, Propertie.timeOutValue).until(ExpectedConditions.visibilityOf(newPassword)); newPassword.clear();
		  newPassword.sendKeys(str); 
	  }
	  
	  public static void enterRetypePassword(String str) 
	  { 
		  WebElement retypePassword = driver.findElement(By.xpath("//*[@id=\"retypeNewPasswordInput\"]"));
		  retypePassword = new WebDriverWait(driver, Propertie.timeOutValue).until(ExpectedConditions.visibilityOf(retypePassword));
		  retypePassword.clear(); 
		  retypePassword.sendKeys(str); 
	  }
	 

	public static void clickOnPDAccept() 
	{
		WebElement pdAccept = driver.findElement(By.xpath("//*[@id=\"pdAccept\"]"));
		pdAccept = new WebDriverWait(driver, Propertie.timeOutValue).until(ExpectedConditions.elementToBeClickable(pdAccept));
		pdAccept.click();
	}

	public static void clickOnTouAccept() 
	{
		WebElement touAccept = driver.findElement(By.xpath("//*[@id=\"touAccept\"]"));
		touAccept = new WebDriverWait(driver, Propertie.timeOutValue)
				.until(ExpectedConditions.elementToBeClickable(touAccept));
		touAccept.click();
	}

	public static void clickOnRegisterButton() 
	{
		WebElement registerButton = driver.findElement(By.xpath("//*[@id=\"sapStoreRegisterFormSubmit\"]"));
		registerButton.sendKeys(Keys.DOWN);
		registerButton = new WebDriverWait(driver, Propertie.timeOutValue)
				.until(ExpectedConditions.elementToBeClickable(registerButton));
		registerButton.click();
	}

	
	public static void verifySuccessMessage() {
		WebElement successMessageText = driver.findElement(By.xpath("/html/body/main/div/div/h1"));
		successMessageText = new WebDriverWait(driver, Propertie.timeOutValue)
				.until(ExpectedConditions.visibilityOf(successMessageText));
		softAssert.assertEquals(successMessageText.getText(), "Thank you for registering with SAP Conversational AI",
				"Success Message Text Not Matching");
	}
	
	public static String getConfirmationMail() {
		WebElement confirmationMailText = driver.findElement(By.xpath("/html/body/main/div/div/div[2]"));
		confirmationMailText = new WebDriverWait(driver, Propertie.timeOutValue)
				.until(ExpectedConditions.visibilityOf(confirmationMailText));
		return confirmationMailText.getText();
	}

	public static void verifyConfirmationMailMessage() {
		WebElement confirmationMailText = driver.findElement(By.xpath("/html/body/main/div/div/div[2]"));
		confirmationMailText = new WebDriverWait(driver, Propertie.timeOutValue)
				.until(ExpectedConditions.visibilityOf(confirmationMailText));
		softAssert.assertTrue(
				getConfirmationMail().contains("An e-mail with a link to activate your account has been sent to"),
				"Confirmation Mail Text not matching/not received");
	}

	public static void verifyActivationText() {
		WebElement activateText = driver.findElement(By.xpath("/html/body/main/div/div/section/p"));
		activateText = new WebDriverWait(driver, Propertie.timeOutValue)
				.until(ExpectedConditions.visibilityOf(activateText));
		softAssert.assertEquals(activateText.getText(),
				"To activate your account, click the link contained in the e-mail. Note that it might take a few minutes for the e-mail to reach your inbox.",
				"Activate Text NOT matching");
	}

	public static void verifyLogoImage() {
		WebElement logoImgBottom = driver.findElement(By.xpath("/html/body/footer/div/div/div/img"));
		logoImgBottom = new WebDriverWait(driver, Propertie.timeOutValue)
				.until(ExpectedConditions.visibilityOf(logoImgBottom));
		softAssert.assertTrue(logoImgBottom.isDisplayed(), "Logo Image is missing in Bottom of confirmation Page");
	}

	public static void clickOnCloseButton() {
		WebElement closeButton = driver.findElement(By.xpath("/html/body/a"));
		closeButton = new WebDriverWait(driver, Propertie.timeOutValue)
				.until(ExpectedConditions.elementToBeClickable(closeButton));
		closeButton.click();
	}
	
	public static void closeBrowser()
	{
		driver.quit();
	}

}
