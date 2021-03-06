package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import Test.TestBase;
import Utility.Propertie;

/*
 * This class has a Objects and methods to interact with Registartion Form.
 */
public class RegistrationPage extends TestBase {

	WebDriver driver;
	SoftAssert softAssert = new SoftAssert();

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
	public WebElement registerButton;
	@FindBy(xpath = "//*[@id='ids-heading-1']")
	WebElement registrationTitle;
	@FindBy(xpath = "//fieldset/h2[text() = 'Tell Us About Yourself']")
	WebElement tellUsAboutYourselfTitle;
	@FindBy(xpath = "//fieldset/h2[text() = 'Set Password']")
	WebElement setPasswordTitle;
	@FindBy(xpath = "//fieldset/h2[text() = 'Terms and Conditions']")
	WebElement termsAndConditionsTitle;
	@FindBy(xpath = "/html/body/a")
	WebElement closeButton;
	@FindBy(xpath = "//label[@for = 'firstName']")
	WebElement firstNameLabel;
	@FindBy(xpath = "//label[@for = 'lastName']")
	WebElement lastNameLabel;
	@FindBy(xpath = "//label[@for = 'mail']")
	WebElement emailLabel;
	@FindBy(xpath = "//label[@for = 'newPasswordInput']")
	WebElement passwordLabel;
	@FindBy(xpath = "//label[@for = 'retypeNewPasswordInput']")
	WebElement retypeLabel;
	@FindBy(xpath = "//label[@for = 'pdAccept']")
	WebElement termsLabel1;
	@FindBy(xpath = "//label[@for = 'touAccept']")
	WebElement termsLabel2;
	@FindBy(xpath = "//div/p[@id = 'firstName.errors']")
	WebElement firstNameError;
	@FindBy(xpath = "//div/p[@id = 'lastName.errors']")
	WebElement lastNameError;
	@FindBy(xpath = "//div/p[@id = 'mail.errors']")
	WebElement emailError;
	@FindBy(xpath = "//div/p[@id = 'password.errors']")
	WebElement passwordError;
	@FindBy(xpath = "//div/p[@id = 'passwordConfirm.errors']")
	WebElement retypeError;
	@FindBy(xpath = "//div/p[@id = 'pdAccept.errors']")
	WebElement pdAcceptError;
	@FindBy(xpath = "//div/p[@id = 'touAccept.errors']")
	WebElement toutAcceptError;
	@FindBy(xpath = "//div[text() = 'Required']")
	WebElement requiredLabel;
	@FindBy(xpath = "//img[@alt = 'Tenant logo']")
	WebElement logoImgBottom;
	
	
	

	public String getFrameTitle() {
		System.out.println(registrationTitle.getText());
		return registrationTitle.getText();
	}

	public void enterFirstName(String str) {
		firstName = new WebDriverWait(driver, Propertie.timeOutValue).until(ExpectedConditions.visibilityOf(firstName));
		firstName.clear();
		firstName.sendKeys(str);
	}

	public void enterLastName(String str) {
		lastName = new WebDriverWait(driver, Propertie.timeOutValue).until(ExpectedConditions.visibilityOf(lastName));
		lastName.clear();
		lastName.sendKeys(str);
	}

	public void enterMail(String str) {
		mail = new WebDriverWait(driver, Propertie.timeOutValue).until(ExpectedConditions.visibilityOf(mail));
		mail.clear();
		mail.sendKeys(str);
	}

	public void enterNewPassword(String str) {
		newPassword = new WebDriverWait(driver, Propertie.timeOutValue).until(ExpectedConditions.visibilityOf(newPassword));
		newPassword.clear();
		newPassword.sendKeys(str);
	}

	public void enterRetypePassword(String str) {
		retypePassword = new WebDriverWait(driver, Propertie.timeOutValue).until(ExpectedConditions.visibilityOf(retypePassword));
		retypePassword.clear();
		retypePassword.sendKeys(str);
	}

	public void clickOnPDAccept() {
		pdAccept = new WebDriverWait(driver, Propertie.timeOutValue).until(ExpectedConditions.elementToBeClickable(pdAccept));
		pdAccept.click();
	}

	public void clickOnTouAccept() {
		touAccept = new WebDriverWait(driver, Propertie.timeOutValue).until(ExpectedConditions.elementToBeClickable(touAccept));
		touAccept.click();
	}

	public void clickOnRegisterButton() {
		registerButton = new WebDriverWait(driver, Propertie.timeOutValue).until(ExpectedConditions.elementToBeClickable(registerButton));
		registerButton.click();
	}
	
	public void clickOnCloseButton() {
		closeButton = new WebDriverWait(driver, Propertie.timeOutValue).until(ExpectedConditions.elementToBeClickable(closeButton));
		closeButton.click();
	}

	public void verifyRegistrationTitle()
	{
		registrationTitle = new WebDriverWait(driver, Propertie.timeOutValue).until(ExpectedConditions.visibilityOf(registrationTitle));
		softAssert.assertEquals(registrationTitle.getText(), "Registration", "Registration Title is NOT matching");
	}
	
	public void verifyTellUsAboutYourselfTitle()
	{
		tellUsAboutYourselfTitle = new WebDriverWait(driver, Propertie.timeOutValue).until(ExpectedConditions.visibilityOf(tellUsAboutYourselfTitle));
		softAssert.assertEquals(tellUsAboutYourselfTitle.getText(), "Tell Us About Yourself", "Tell Us About Yourself Title is NOT matching");
	}
	
	public void verifyPasswordTitle()
	{
		setPasswordTitle = new WebDriverWait(driver, Propertie.timeOutValue).until(ExpectedConditions.visibilityOf(setPasswordTitle));
		softAssert.assertEquals(setPasswordTitle.getText(), "Set Password", "Set Password Title is NOT matching");
	}
	
	public void verifyTermsAndConditionsTitle()
	{
		termsAndConditionsTitle = new WebDriverWait(driver, Propertie.timeOutValue).until(ExpectedConditions.visibilityOf(termsAndConditionsTitle));
		softAssert.assertEquals(termsAndConditionsTitle.getText(), "Terms and Conditions", "Terms and Conditions Title is NOT matching");
	}
	
	public void verifyFirstNameLabel()
	{
		firstNameLabel = new WebDriverWait(driver, Propertie.timeOutValue).until(ExpectedConditions.visibilityOf(firstNameLabel));
		softAssert.assertEquals(firstNameLabel.getText(), "First Name", "First Name label is NOT matching");
	}
	
	public void verifyLastNameLabel()
	{
		lastNameLabel = new WebDriverWait(driver, Propertie.timeOutValue).until(ExpectedConditions.visibilityOf(lastNameLabel));
		softAssert.assertEquals(lastNameLabel.getText(), "Last Name", "Last Name label is NOT matching");
	}
	
	public void verifyEmailLabel()
	{
		emailLabel = new WebDriverWait(driver, Propertie.timeOutValue).until(ExpectedConditions.visibilityOf(emailLabel));
		softAssert.assertEquals(emailLabel.getText(), "E-Mail", "E-Mail label is NOT matching");
	}
	
	public void verifyPasswordLabel()
	{
		passwordLabel = new WebDriverWait(driver, Propertie.timeOutValue).until(ExpectedConditions.visibilityOf(passwordLabel));
		softAssert.assertEquals(passwordLabel.getText(), "Password", "Password label is NOT matching");
	}
	
	public void verifyRetypePasswordLabel()
	{
		retypeLabel = new WebDriverWait(driver, Propertie.timeOutValue).until(ExpectedConditions.visibilityOf(retypeLabel));
		softAssert.assertEquals(retypeLabel.getText(), "Re-Enter Password", "Re-Enter Password label is NOT matching");
	}
	
	public void verifyTermsLabel1()
	{
		termsLabel1 = new WebDriverWait(driver, Propertie.timeOutValue).until(ExpectedConditions.visibilityOf(termsLabel1));
		softAssert.assertEquals(termsLabel1.getText(), "I have read the Privacy Statement and consent to this agreement.", "Terms label1 is NOT matching");
	}
	
	public void verifyTermsLabel2()
	{
		termsLabel2 = new WebDriverWait(driver, Propertie.timeOutValue).until(ExpectedConditions.visibilityOf(termsLabel2));
		softAssert.assertEquals(termsLabel2.getText(), "I have read and understood the Terms and Conditions of SAP Conversational AI.", "Terms label2 is NOT matching");
	}
	
	public void verifyRequiredLabel()
	{
		requiredLabel = new WebDriverWait(driver, Propertie.timeOutValue).until(ExpectedConditions.visibilityOf(requiredLabel));
		softAssert.assertEquals(requiredLabel.getText(), "Required", "Required Label is NOT matching");
	}
	
	public void verifyLogoImage()
	{
		logoImgBottom = new WebDriverWait(driver, Propertie.timeOutValue).until(ExpectedConditions.visibilityOf(logoImgBottom));
		softAssert.assertTrue(logoImgBottom.isDisplayed(), "Logo at the Bottom is NOT displayed");
	}
	
	public void verifyFirstNameError()
	{
		firstNameError = new WebDriverWait(driver, Propertie.timeOutValue).until(ExpectedConditions.visibilityOf(firstNameError));
		softAssert.assertEquals(firstNameError.getText(), "Required field", "First Name Error is NOT matching");
	}
	
	public void verifyLastNameError()
	{
		lastNameError = new WebDriverWait(driver, Propertie.timeOutValue).until(ExpectedConditions.visibilityOf(lastNameError));
		softAssert.assertEquals(lastNameError.getText(), "Required field", "Last Name Error is NOT matching");
	}
	
	public void verifyEmailError()
	{
		emailError = new WebDriverWait(driver, Propertie.timeOutValue).until(ExpectedConditions.visibilityOf(emailError));
		softAssert.assertEquals(emailError.getText(), "Required field", "Email Error is NOT matching");
	}
	
	public void verifyPDAcceptError()
	{
		pdAcceptError = new WebDriverWait(driver, Propertie.timeOutValue).until(ExpectedConditions.visibilityOf(pdAcceptError));
		softAssert.assertEquals(pdAcceptError.getText(), "To accept the privacy statement, click the box above", "PD Accept Error is NOT matching");
	}
	
	public void verifyToutAcceptError()
	{
		toutAcceptError = new WebDriverWait(driver, Propertie.timeOutValue).until(ExpectedConditions.visibilityOf(toutAcceptError));
		softAssert.assertEquals(toutAcceptError.getText(), "To accept the terms of use, check the box", "Tout Accept Error is NOT matching");
	}
	
	public void verifyPasswordError()
	{
		passwordError = new WebDriverWait(driver, Propertie.timeOutValue).until(ExpectedConditions.visibilityOf(passwordError));
		softAssert.assertEquals(passwordError.getText(), "The password must comply with the requirements", "Password Error is NOT matching");
	}
	
	public void verifyReEnterPasswordError()
	{
		retypeError = new WebDriverWait(driver, Propertie.timeOutValue).until(ExpectedConditions.visibilityOf(retypeError));
		softAssert.assertEquals(retypeError.getText(), "Required field", "Reenter Password Error is NOT matching");
	}
	
	
}
