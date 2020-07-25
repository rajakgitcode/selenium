package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import Test.TestBase;

public class ConfirmationPage extends TestBase {

	WebDriver driver;
	SoftAssert softAssert = new SoftAssert();

	public ConfirmationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "/html/body/main/div/div/h1")
	WebElement successMessageText;
	@FindBy(xpath = "/html/body/main/div/div/div[2]")
	WebElement confirmationMailText;
	@FindBy(xpath = "/html/body/main/div/div/section/p")
	WebElement activateText;
	@FindBy(xpath = "/html/body/a")
	WebElement closeButton;
	@FindBy(xpath = "/html/body/footer/div/div/div/img")
	WebElement logoImgBottom;
	
	public String getSuccessMessage() {
		successMessageText = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(successMessageText));
		return successMessageText.getText();
	}

	public String getConfirmationMail() {
		confirmationMailText = new WebDriverWait(driver, 20)
				.until(ExpectedConditions.visibilityOf(confirmationMailText));
		return confirmationMailText.getText();
	}
	
	public String getActivateText() {
		confirmationMailText = new WebDriverWait(driver, 20)
				.until(ExpectedConditions.visibilityOf(activateText));
		return activateText.getText();
	}

	public void verifySuccessMessage() {
		successMessageText = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(successMessageText));
		softAssert.assertEquals(successMessageText.getText(), "Thank you for registering with SAP Conversational AI",
				"Success Message Text Not Matching");
	}

	public void verifyConfirmationMailMessage() {
		confirmationMailText = new WebDriverWait(driver, 20)
				.until(ExpectedConditions.visibilityOf(confirmationMailText));
		softAssert.assertTrue(
				getConfirmationMail().contains("An e-mail with a link to activate your account has been sent to"),
				"Confirmation Mail Text not matching/not received");
	}
	
	public void verifyActivationText() {
		activateText = new WebDriverWait(driver, 20)
				.until(ExpectedConditions.visibilityOf(activateText));
		softAssert.assertEquals(activateText.getText(), "To activate your account, click the link contained in the e-mail. Note that it might take a few minutes for the e-mail to reach your inbox.","Activate Text NOT matching");
	}
	
	public void verifyLogoImage() {
		logoImgBottom = new WebDriverWait(driver, 20)
				.until(ExpectedConditions.visibilityOf(logoImgBottom));
		softAssert.assertTrue(logoImgBottom.isDisplayed(), "Logo Image is missing in Bottom of confirmation Page" );
	}
	
	public void clickOnCloseButton()
	{
		closeButton = new WebDriverWait(driver, 20)
				.until(ExpectedConditions.elementToBeClickable(closeButton));
		closeButton.click();
	}
	
}
