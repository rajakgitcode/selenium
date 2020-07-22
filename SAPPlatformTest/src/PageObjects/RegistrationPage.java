package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Test.TestBase;

public class RegistrationPage extends TestBase {

	WebDriver driver;

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"firstName\"]")
	WebElement firstName;
	@FindBy(xpath = "//*[@id=\"lastName\"]")
	WebElement lastName;
	@FindBy(xpath = "//*[@id=\"mail\"]")
	WebElement mail;
	@FindBy(xpath = "//*[@id=\"newPasswordInput\"]")
	WebElement newPassword;
	@FindBy(xpath = "//*[@id=\"retypeNewPasswordInput\"]")
	WebElement retypePassword;
	@FindBy(xpath = "//*[@id=\"pdAccept\"]")
	WebElement pdAccept;
	@FindBy(xpath = "//*[@id=\"touAccept\"]")
	WebElement touAccept;
	@FindBy(xpath = "//*[@id=\"sapStoreRegisterFormSubmit\"]")
	WebElement registerButton;
	@FindBy(xpath = "/html/body/main/div/div/form/div[2]/fieldset[1]/h2")
	WebElement frameTitle;

	public String getFrameTitle() {
		System.out.println(frameTitle.getText());
		return frameTitle.getText();
	}

	public void enterFirstName(String str) {
		firstName = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(firstName));
		firstName.clear();
		firstName.sendKeys(str);
	}

	public void enterLastName(String str) {
		lastName = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(lastName));
		lastName.clear();
		lastName.sendKeys(str);
	}

	public void enterMail(String str) {
		mail = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(mail));
		mail.clear();
		mail.sendKeys(str);
	}

	public void enterNewPassword(String str) {
		newPassword = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(newPassword));
		newPassword.clear();
		newPassword.sendKeys(str);
	}

	public void enterRetypePassword(String str) {
		retypePassword = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(retypePassword));
		retypePassword.clear();
		retypePassword.sendKeys(str);
	}

	public void clickOnPDAccept() {
		pdAccept = new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(pdAccept));
		pdAccept.click();
	}

	public void clickOnTouAccept() {
		touAccept = new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(touAccept));
		touAccept.click();
	}

	public void clickOnRegisterButton() {
		registerButton = new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(registerButton));
		registerButton.click();
	}

}
