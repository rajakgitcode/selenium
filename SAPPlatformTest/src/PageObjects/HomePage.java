package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Test.TestBase;

public class HomePage extends TestBase {

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[contains(text(),'OK')]")
	WebElement cookieOKButton;
	@FindBy(css = ".sap-btn-action > div:nth-child(1)")
	WebElement signUpButton;
	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[2]/div[1]/iframe[1]")
	WebElement iFrame;

	public String getPageTitle() {
		return driver.getTitle();
	}

	public void clickOnCookieOKButton() {
		cookieOKButton = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(cookieOKButton));
		cookieOKButton.click();

	}

	public void clickOnSignUpButton() {
		signUpButton = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(signUpButton));
		signUpButton.click();
	}

	public void switchToIframe() {
		iFrame = new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(iFrame));
		driver.switchTo().frame(0);
	}
}
