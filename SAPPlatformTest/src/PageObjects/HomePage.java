package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;

import Test.TestBase;
import Utility.Propertie;

/*
 * This page class has a UI Objects and methods to interact with Home page.
 */

@Listeners(Utility.ExtentTestNGITestListener.class)
public class HomePage extends TestBase {

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[contains(text(),'OK')]")
	WebElement cookieOKButton;
	@FindBy(css = ".sap-btn-action > div:nth-child(1)")
	WebElement signUpButton;
	@FindBy(xpath = "//iframe[@id='IDS_UI_Window']")
	WebElement iFrame;
	

	public String getPageTitle() {
		return driver.getTitle();
	}

	public void clickOnCookieOKButton() {
		cookieOKButton = new WebDriverWait(driver, Propertie.timeOutValue).until(ExpectedConditions.elementToBeClickable(cookieOKButton));
		cookieOKButton.click();

	}

	public void clickOnSignUpButton() {
		signUpButton = new WebDriverWait(driver, Propertie.timeOutValue).until(ExpectedConditions.elementToBeClickable(signUpButton));
		signUpButton.click();
	}

	public void switchToIframe() {
		
		driver = new WebDriverWait(driver, Propertie.timeOutValue).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iFrame));
		//driver.switchTo().frame(0);
		
		
	}

	
}
