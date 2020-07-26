package Test;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import PageObjects.ConfirmationPage;
import PageObjects.HomePage;
import PageObjects.RegistrationPage;
import Utility.ExcelUtil;
import Utility.ExtentTestNGITestListener;
import Utility.RetryTest;
import Utility.TestDataProvider;

/*
 * This Test class has a methods to interact with application to run the tests.
 */
@Listeners(Utility.ExtentTestNGITestListener.class)
public class Platform_Sign_Up extends TestBase 
{
	SoftAssert softAssert = new SoftAssert();

	@Test(dataProvider = "data-provider-Test-Platform-SignUp", dataProviderClass = TestDataProvider.class, groups = {"functional"}, retryAnalyzer = RetryTest.class, description = "testing Platform sign up with Excel Reader", enabled = true)
	public void test_Platform_Sign_Up(String firstName, String lastName, String email, String password, String retypePasswd, String opAuth, String toutAuth) throws InterruptedException 
	{
		System.out.println("*****Test Started - test_Platform_Sign_Up_With_Excel_Reader*****");
		
		HomePage homePage = new HomePage(driver);
		
		homePage.clickOnCookieOKButton();
		homePage.clickOnSignUpButton();
		homePage.switchToIframe();
			
		RegistrationPage registrationPage = new RegistrationPage(driver);
		
		registrationPage.enterFirstName(firstName);
		Thread.sleep(300);
		registrationPage.enterLastName(lastName);
		Thread.sleep(300);
		registrationPage.enterMail(email);
		Thread.sleep(300);
		registrationPage.enterNewPassword(password);
		Thread.sleep(300);
		registrationPage.enterRetypePassword(retypePasswd);
		Thread.sleep(300);
			
		registrationPage.registerButton.sendKeys(Keys.DOWN);
		
		Thread.sleep(500);
		registrationPage.clickOnPDAccept();
		registrationPage.clickOnTouAccept();
		registrationPage.clickOnRegisterButton();
			
		ConfirmationPage confirmationpage = new ConfirmationPage(driver);
			
		confirmationpage.verifySuccessMessage();
		confirmationpage.verifyConfirmationMailMessage();
		confirmationpage.verifyActivationText();
		confirmationpage.verifyLogoImage();
		confirmationpage.clickOnCloseButton();
		
		driver.switchTo().defaultContent();
		softAssert.assertAll();
	}
	
	@Test(groups = {"Acceptance"}, retryAnalyzer = RetryTest.class, description = "testing the Registration form label names/elements presents", enabled = true)
	public void test_Registration_Form_LabelText() throws InterruptedException
	{
		System.out.println("*****Test Started - test_Registration_LabelText_Matching*****");
		
		HomePage homePage = new HomePage(driver);
		
		homePage.clickOnCookieOKButton();
		homePage.clickOnSignUpButton();
		Thread.sleep(500);
		homePage.switchToIframe();
		
		RegistrationPage registrationPage = new RegistrationPage(driver);
		
		//verifying the label names/elements presents in the registration form.
		registrationPage.verifyRegistrationTitle();
		registrationPage.verifyTellUsAboutYourselfTitle();
		registrationPage.verifyPasswordTitle();
		registrationPage.verifyTermsAndConditionsTitle();
		registrationPage.verifyFirstNameLabel();
		registrationPage.verifyLastNameLabel();
		registrationPage.verifyEmailLabel();
		registrationPage.verifyPasswordLabel();
		registrationPage.verifyRetypePasswordLabel();
		registrationPage.registerButton.sendKeys(Keys.DOWN);
		Thread.sleep(500);
		registrationPage.verifyTermsLabel1();
		registrationPage.verifyTermsLabel2();
		registrationPage.verifyRequiredLabel();
		registrationPage.verifyLogoImage();
		registrationPage.clickOnCloseButton();
		
		driver.switchTo().defaultContent();
		softAssert.assertAll();
		
	}
	
	@Test(groups = {"Negative"}, retryAnalyzer = RetryTest.class, description = "Testing the Registration Form Error Messages", enabled = false)
	public void test_registration_Form_Error_Messages() throws InterruptedException
	{
		System.out.println("*****Test Started - test_Registration_ErrorText_Matching*****");
		
		HomePage homePage = new HomePage(driver);
		
		homePage.clickOnCookieOKButton();
		homePage.clickOnSignUpButton();
		Thread.sleep(5000);
		homePage.switchToIframe();
		Thread.sleep(1000);
		
		RegistrationPage registrationPage = new RegistrationPage(driver);
		
		//registrationPage.registerButton.sendKeys(Keys.DOWN);
		//Thread.sleep(500);
		registrationPage.clickOnRegisterButton();
		Thread.sleep(2000);
		
		//verifying the label names/elements presents in the registration form.
		registrationPage.verifyFirstNameError();
		registrationPage.verifyLastNameError();
		registrationPage.verifyEmailError();
		registrationPage.verifyPasswordError();
		registrationPage.verifyReEnterPasswordError();
		registrationPage.verifyPDAcceptError();
		registrationPage.verifyToutAcceptError();
		registrationPage.clickOnCloseButton();
		
		driver.switchTo().defaultContent();
		softAssert.assertAll();
		
	}

}
