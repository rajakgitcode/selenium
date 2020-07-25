package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import Test.TestBase;

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
	public WebElement mail;
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
	@FindBy(xpath = "/html/body/main/div/div/h1")
	WebElement registrationTitle;
	@FindBy(xpath = "/html/body/main/div/div/form/div[2]/fieldset[1]/h2")
	WebElement tellUsAboutYourselfTitle;
	@FindBy(xpath = "/html/body/main/div/div/form/div[2]/fieldset[2]/h2")
	WebElement setPasswordTitle;
	@FindBy(xpath = "/html/body/main/div/div/form/div[2]/fieldset[3]/h2")
	WebElement termsAndConditionsTitle;
	@FindBy(xpath = "/html/body/a")
	WebElement closeButton;
	@FindBy(xpath = "/html/body/main/div/div/form/div[2]/fieldset[1]/div[1]/div[1]/span/label")
	WebElement firstNameLabel;
	@FindBy(xpath = "/html/body/main/div/div/form/div[2]/fieldset[1]/div[1]/div[1]/span/label")
	WebElement lastNameLabel;
	@FindBy(xpath = "/html/body/main/div/div/form/div[2]/fieldset[1]/div[1]/div[1]/span/label")
	WebElement emailLabel;
	@FindBy(xpath = "/html/body/main/div/div/form/div[2]/fieldset[1]/div[1]/div[1]/span/label")
	WebElement passwordLabel;
	@FindBy(xpath = "/html/body/main/div/div/form/div[2]/fieldset[1]/div[1]/div[1]/span/label")
	WebElement retypeLabel;
	@FindBy(xpath = "/html/body/main/div/div/form/div[2]/fieldset[3]/div[1]/div/ul/li/span[2]/span/label")
	WebElement termsLabel1;
	@FindBy(xpath = "/html/body/main/div/div/form/div[2]/fieldset[3]/div[2]/div/ul/li/span[2]/span/label")
	WebElement termsLabel2;
	@FindBy(xpath = "/html/body/main/div/div/form/div[2]/fieldset[1]/div[1]/div[2]/p")
	WebElement firstNameError;
	@FindBy(xpath = "/html/body/main/div/div/form/div[2]/fieldset[2]/div[1]/div[2]/p")
	WebElement lastNameError;
	@FindBy(xpath = "/html/body/main/div/div/form/div[2]/fieldset[1]/div[4]/div/div[2]/p")
	WebElement emailError;
	@FindBy(xpath = "/html/body/main/div/div/form/div[2]/fieldset[3]/div[1]/div/p")
	WebElement pdAcceptError;
	@FindBy(xpath = "/html/body/main/div/div/form/div[2]/fieldset[3]/div[2]/div/p")
	WebElement toutAcceptError;
	@FindBy(xpath = "/html/body/main/div/div/form/div[2]/fieldset[2]/div[1]/div[2]/p")
	WebElement passwordError;
	@FindBy(xpath = "/html/body/main/div/div/form/div[2]/fieldset[2]/div[2]/div[2]/p")
	WebElement retypeError;
	@FindBy(xpath = "/html/body/main/div/div/form/div[2]/div/div")
	WebElement requiredLabel;
	@FindBy(xpath = "/html/body/footer/div/div/div/img")
	WebElement logoImgBottom;
	
	
	

	public String getFrameTitle() {
		System.out.println(registrationTitle.getText());
		return registrationTitle.getText();
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
	
	public void clickOnCloseButton() {
		closeButton = new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(closeButton));
		closeButton.click();
	}

	public void verifyRegistrationTitle()
	{
		registrationTitle = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(registrationTitle));
		softAssert.assertEquals(registrationTitle.getText(), "Registration", "Registration Title is NOT matching");
	}
	
	public void verifyTellUsAboutYourselfTitle()
	{
		tellUsAboutYourselfTitle = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(tellUsAboutYourselfTitle));
		softAssert.assertEquals(tellUsAboutYourselfTitle.getText(), "Tell Us About Yourself", "Tell Us About Yourself Title is NOT matching");
	}
	
	public void verifyPasswordTitle()
	{
		setPasswordTitle = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(setPasswordTitle));
		softAssert.assertEquals(setPasswordTitle.getText(), "Set Password", "Set Password Title is NOT matching");
	}
	
	public void verifyTermsAndConditionsTitle()
	{
		termsAndConditionsTitle = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(termsAndConditionsTitle));
		softAssert.assertEquals(termsAndConditionsTitle.getText(), "Terms and Conditions", "Terms and Conditions Title is NOT matching");
	}
	
	public void verifyFirstNameLabel()
	{
		firstNameLabel = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(firstNameLabel));
		softAssert.assertEquals(firstNameLabel.getText(), "First Name", "First Name label is NOT matching");
	}
	
	public void verifyLastNameLabel()
	{
		lastNameLabel = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(lastNameLabel));
		softAssert.assertEquals(lastNameLabel.getText(), "Last Name", "Last Name label is NOT matching");
	}
	
	public void verifyEmailLabel()
	{
		emailLabel = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(emailLabel));
		softAssert.assertEquals(emailLabel.getText(), "E-Mail", "E-Mail label is NOT matching");
	}
	
	public void verifyPasswordLabel()
	{
		passwordLabel = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(passwordLabel));
		softAssert.assertEquals(passwordLabel.getText(), "Password", "Password label is NOT matching");
	}
	
	public void verifyRetypePasswordLabel()
	{
		retypeLabel = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(retypeLabel));
		softAssert.assertEquals(retypeLabel.getText(), "Re-Enter Password", "Re-Enter Password label is NOT matching");
	}
	
	public void verifyTermsLabel1()
	{
		termsLabel1 = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(termsLabel1));
		softAssert.assertEquals(termsLabel1.getText(), "I have read the Privacy Statement and consent to this agreement.", "Terms label1 is NOT matching");
	}
	
	public void verifyTermsLabel2()
	{
		termsLabel2 = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(termsLabel2));
		softAssert.assertEquals(termsLabel2.getText(), "I have read and understood the Terms and Conditions of SAP Conversational AI.", "Terms label2 is NOT matching");
	}
	
	public void verifyRequiredLabel()
	{
		requiredLabel = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(requiredLabel));
		softAssert.assertEquals(requiredLabel.getText(), "Required", "Required Label is NOT matching");
	}
	
	public void verifyLogoImage()
	{
		logoImgBottom = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(logoImgBottom));
		softAssert.assertTrue(logoImgBottom.isDisplayed(), "Logo at the Bottom is NOT displayed");
	}
	
	public void verifyFirstNameError()
	{
		firstNameError = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(firstNameError));
		softAssert.assertEquals(firstNameError.getText(), "Required field", "First Name Error is NOT matching");
	}
	
	public void verifyLastNameError()
	{
		lastNameError = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(lastNameError));
		softAssert.assertEquals(lastNameError.getText(), "Required field", "Last Name Error is NOT matching");
	}
	
	public void verifyEmailError()
	{
		emailError = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(emailError));
		softAssert.assertEquals(emailError.getText(), "Required field", "Email Error is NOT matching");
	}
	
	public void verifyPDAcceptError()
	{
		pdAcceptError = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(pdAcceptError));
		softAssert.assertEquals(pdAcceptError.getText(), "To accept the privacy statement, click the box above", "PD Accept Error is NOT matching");
	}
	
	public void verifyToutAcceptError()
	{
		toutAcceptError = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(toutAcceptError));
		softAssert.assertEquals(toutAcceptError.getText(), "To accept the terms of use, check the box", "Tout Accept Error is NOT matching");
	}
	
	public void verifyPasswordError()
	{
		passwordError = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(passwordError));
		softAssert.assertEquals(passwordError.getText(), "The password must comply with the requirements", "Password Error is NOT matching");
	}
	
	public void verifyReEnterPasswordError()
	{
		retypeError = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(retypeError));
		softAssert.assertEquals(retypeError.getText(), "Required field", "Reenter Password Error is NOT matching");
	}
	
	
}
