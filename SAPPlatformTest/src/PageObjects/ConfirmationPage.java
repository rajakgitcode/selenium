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

	public String getSuccessMessage() {
		successMessageText = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(successMessageText));
		return successMessageText.getText();
	}

	public String getConfirmationMail() {
		confirmationMailText = new WebDriverWait(driver, 20)
				.until(ExpectedConditions.visibilityOf(confirmationMailText));
		return confirmationMailText.getText();
	}

	public void verifySuccessMessage() {
		successMessageText = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(successMessageText));
		softAssert.assertEquals(getSuccessMessage(), "Thank you for registering with SAP Conversational AI",
				"Success Message Text Not Matching");
	}

	public void verifyConfirmationMailMessage() {
		confirmationMailText = new WebDriverWait(driver, 20)
				.until(ExpectedConditions.visibilityOf(confirmationMailText));
		softAssert.assertTrue(
				getConfirmationMail().contains("An e-mail with a link to activate your account has been sent to"),
				"Confirmation Mail Text not matching/not received");
	}

}
